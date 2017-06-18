package com.pancake.util;

import com.pancake.entity.User;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;

import static org.junit.Assert.*;

/**
 * Created by chao on 2017/6/18.
 */
public class UpdateUtilTest {
    @Test
    public void update() throws Exception {
        UpdateUtil<User> userUpdateUtil = new UpdateUtil<User>(User.class);
        User userA = new User();
        User userB = new User();
        userUpdateUtil.update(userA, userB);
        System.out.println("userA Status: " + userA.getStatus());
    }

    @Test
    public void test() {
        System.out.println(String.valueOf(11111L));
    }

}