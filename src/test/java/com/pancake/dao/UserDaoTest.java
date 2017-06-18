package com.pancake.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jws.soap.SOAPBinding;

import static org.junit.Assert.*;

/**
 * Created by chao on 2017/6/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-*.xml")
public class UserDaoTest {
    private final static Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
    @Autowired
    private UserDao userDao;
    @Test
    public void queryAll() throws Exception {
    }

    @Test
    public void add() throws Exception {
    }

    @Test
    public void findById() throws Exception {
        logger.info(userDao.findById(1L).toString());
    }

}