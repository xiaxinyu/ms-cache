package com.sailfish.cache.redis.controller;

import com.sailfish.cache.redis.model.User;
import com.sailfish.cache.redis.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * @author XIAXINYU3
 * @date 2020/11/30
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    RedisUtil redisUtil;

    @ResponseBody
    @RequestMapping("/set/{name}")
    public String set(@PathVariable String name) {
        redisUtil.set(name, User.builder().id(new Random().nextLong()).name("summer").build());
        return "success";
    }

    @ResponseBody
    @RequestMapping("/get/{name}")
    public User get(@PathVariable String name) {
        return (User) redisUtil.get(name);
    }
}