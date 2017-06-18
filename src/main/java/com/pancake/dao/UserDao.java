package com.pancake.dao;

import com.pancake.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chao on 2017/6/13.
 */
public interface UserDao {

    /**
     * 返回 User 表中的记录
     * @param offset 第几页
     * @param limit 一页多少记录
     * @return User list
     */
    List<User> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 添加user
     * @param user User对象
     */
    void add(User user);

    /**
     * 根据 user id 查找 user。
     * @param id user id
     * @return
     */
    User findById(long id);

    void update(User user);

    void deleteById(long Id);
}
