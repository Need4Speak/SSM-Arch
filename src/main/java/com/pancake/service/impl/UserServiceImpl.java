package com.pancake.service.impl;

import com.pancake.dao.UserDao;
import com.pancake.entity.User;
import com.pancake.exception.UserException;
import com.pancake.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by chao on 2017/6/13.
 */
@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;

    /**
     * 分页返回所有用户信息
     * @param offset 当前页码
     * @param limit 每页的记录数
     * @return User list
     */
    public List<User> getUserList(int offset, int limit) {
        List<User> list = userDao.queryAll(offset,limit);
        if (null == list) {
            new UserException("No user was found.");
        }
        logger.debug("last_sign_time: " + list.get(0).getLastSignTime());
        return list;
    }

    /**
     * 添加用户到数据库
     * @param user User对象
     */
    @Transactional
    public void addUser(User user) throws UserException{
        userDao.add(user);
    }

    /**
     * 根据 传入的 user 对象更新数据库
     * @param user 前台传入的 User 对象
     * @return 更新是否成功
     * @throws UserException
     */
    @Transactional
    public boolean update(User user) throws UserException{
        //如果user与数据库中存储的user不同，则更新数据库
        if (!user.equals(userDao.findById(user.getId()))) {
            userDao.update(user);
            return true;
        }
        return false;
    }

    /**
     * 根据主键 userId 删除表中的记录
     * @param userId 主键
     * @return 删除是否成功
     * @throws UserException
     */
    @Transactional
    public boolean deleteById(long userId) throws UserException{
        //如果user与数据库中存储的user不同，则更新数据库
        if (null == userDao.findById(userId)) {
            return false;
        }
        else {
            userDao.deleteById(userId);
            return true;
        }
    }
}
