package com.pancake.service.impl;

import com.pancake.dao.SeckillDao;
import com.pancake.dao.SuccessKilledDao;
import com.pancake.dto.Exposer;
import com.pancake.dto.SeckillExecution;
import com.pancake.entity.Seckill;
import com.pancake.entity.SuccessKilled;
import com.pancake.exception.SeckillCloseException;
import com.pancake.exception.RepeatKillException;
import com.pancake.exception.SeckillException;
import com.pancake.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by m on 2017/6/9.
 */
@Service
public class SeckillServiceImpl implements SeckillService{
    private final static Logger logger = LoggerFactory.getLogger(SeckillServiceImpl.class);
    //注入Service依赖
    @Autowired
    private SeckillDao seckillDao;
    @Autowired
    private SuccessKilledDao successKilledDao;

    //md5盐值
    private final String slat = "aaaaa";


    public List<Seckill> getSeckillList() {
        return seckillDao.queryAll(0,4);
    }

    @Transactional
    public Seckill getById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    public Exposer exportSeckillUrl(long seckillId) {
        Seckill seckill = seckillDao.queryById(seckillId);
        if (seckill == null) {
            return new Exposer(false, seckillId);
        }
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        Date nowTime = new Date();
        if (nowTime.getTime() < startTime.getTime()
                || nowTime.getTime() > endTime.getTime()) {
            return new Exposer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
        }
        String md5 = getMD5(seckillId);
        return new Exposer(true, md5, seckillId);
    }

    private String getMD5(long seckillId) {
        String base = seckillId + "/" +slat;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }

    @Transactional
    /**
     * 使用注解控制事务的优点：
     * 1. 开发团队达成一致约定，明确标注事务方法的编程风格
     * 2. 保证事务方法的执行时间尽可能短，不要穿插其他网络操作RPC/HTTP请求或者剥离到事务方法以外
     * 3. 不是所有的方法都需要事务，如只有一条修改操作，或者只读操作
     */
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException, RepeatKillException, SeckillCloseException {
        if (md5 == null || !md5.equals(getMD5(seckillId))) {
            throw new SeckillException("seckill data rewrite");
        }
        try {
            //执行秒杀逻辑：减库存 + 记录购买行为
            Date nowTime = new Date();
            int updateCount = seckillDao.reduceNumber(seckillId, nowTime);
            if (updateCount <= 0) {
                //没有更新到记录
                throw new SeckillCloseException("seckill is closed");
            } else {
                //记录购买行为
                int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
                if (insertCount <= 0) {
                    //重复秒杀
                    throw new RepeatKillException("seckill repeat");
                } else {
                    //秒杀成功
                    SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
                    return new SeckillExecution(seckillId, 1, "秒杀成功", successKilled);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            //所有编译器异常，转化为运行期异常
            throw new SeckillException("seckill inner error: " + e.getMessage());
        }

    }
}
