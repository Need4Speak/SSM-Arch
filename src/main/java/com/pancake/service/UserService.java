package com.pancake.service;

import com.pancake.entity.User;

import java.util.List;

/**
 * Created by chao on 2017/6/13.
 */
public interface UserService {

    /**
     * 查询所有用户信息
     * @return User 对象列表
     */
    List<User> getUserList(int offset, int limit);
}
