package com.pancake.service.impl;

import com.pancake.entity.User;
import com.pancake.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by chao on 2017/6/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-*.xml")
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void getUserList() throws Exception {
    }

    @Test
    public void addUser() throws RuntimeException {
        User user = new User("许刚", "111", 18311111111L, "male",
                new Timestamp(System.currentTimeMillis()), 0);
        user.setUniCode("test");
        userService.addUser(user);

    }

}