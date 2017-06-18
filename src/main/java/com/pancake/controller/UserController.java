package com.pancake.controller;

import com.pancake.entity.Result;
import com.pancake.entity.User;
import com.pancake.enums.StatEnum;
import com.pancake.service.UserService;
import com.pancake.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chao on 2017/6/13.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    /**
     * 分页返回所有用户信息
     * @return Result 对象
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public Result queryAll() {
        int offset = 0;
        int limit = 100;
        return ResultUtil.success(userService.getUserList(offset,limit));
    }

    /**
     * 添加用户
     * @param user 前台传来的数据自动装入 user 对象中
     * @return result 对象
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Result add(@RequestBody User user) {
        if (null != user) {
            userService.addUser(user);
            return ResultUtil.success();
        } else {
            return ResultUtil.error(StatEnum.NULL_OBJECT.getState(), StatEnum.NULL_OBJECT.getStateInfo());
        }
    }

    /**
     * 更新数据，前台必须把所有user的信息都传递给后台
     * @param user 前台传来的数据自动装入 user 对象中
     * @return result 对象
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@RequestBody User user) {
        if (null != user) {
            if (userService.update(user))
                return ResultUtil.success();
            else
                return ResultUtil.error(StatEnum.UPDATE_FAIL.getState(), StatEnum.UPDATE_FAIL.getStateInfo());
        } else {
            return ResultUtil.error(StatEnum.NULL_OBJECT.getState(), StatEnum.NULL_OBJECT.getStateInfo());
        }
    }

    @RequestMapping(value = "delete/{userId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable("userId") long userId) {
        if(0L == userId) {
            return ResultUtil.error(StatEnum.NULL_USER_ID.getState(), StatEnum.NULL_USER_ID.getStateInfo());
        }
        else {
            if (userService.deleteById(userId)) {
                return ResultUtil.success();
            } else {
                return ResultUtil.error(StatEnum.DELETE_USER_FAIL.getState(), StatEnum.DELETE_USER_FAIL.getStateInfo());
            }
        }
    }
    /**
     * 测试
     * @return Result 对象
     */
    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ResponseBody
    public Result test() {
        return ResultUtil.success();
    }

}
