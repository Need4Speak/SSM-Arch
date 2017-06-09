package com.pancake.dao;

import com.pancake.entity.SuccessKilled;
import org.apache.ibatis.annotations.Param;

/**
 * Created by m on 2017/6/8.
 */
public interface SuccessKilledDao {
    /**
     * 插入购买明细，可过滤重复
     * @param seckillId
     * @param userPhone
     * @return
     */
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

    /**
     * 根据id查询SuccessKilled，并携带秒杀产品对象实体
     * @param skillId
     * @return
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
}
