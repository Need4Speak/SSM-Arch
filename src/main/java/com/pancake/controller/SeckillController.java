package com.pancake.controller;

import com.pancake.entity.Seckill;
import com.pancake.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by m on 2017/6/9.
 */
//@Controller
@RestController
@RequestMapping("/seckill")
public class SeckillController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

//    @RequestMapping(value = "/list", method = RequestMethod.GET,
//            produces = {"application/json;charset=UTF-8"})
//    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Seckill> list(){
        return seckillService.getSeckillList();
    }
}
