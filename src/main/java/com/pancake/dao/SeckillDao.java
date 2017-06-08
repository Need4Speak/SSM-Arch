package com.pancake.dao;

import com.pancake.entity.Seckill;

import java.util.Date;
import java.util.List;

/**
 * Created by m on 2017/6/8.
 */
public interface SeckillDao {

    /**
     *
     * @param seckillId
     * @param killTime
     * @return
     */
    int reduceNumber(long seckillId, Date killTime);


    /**
     *
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     *
     * @param offet
     * @param limit
     * @return
     */
    List<Seckill> queryAll(int offet, int limit);
}
