package com.shellming.eleservice.controller;

import com.shellming.eleservice.entity.User;
import com.shellming.eleservice.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(value = "user")
@Api(description = "用户接口")
public class UserController {
    Logger Log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserService userService;

    @ApiOperation(value = "新增用户" ,  notes="新增注册")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List getUserList() {
        Log.info("获取用户列表");
        Map map = new HashMap<>();
        map.put("user_id", "123");
        return userService.list(map);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public int create() {
        Log.info("创建用户");

        User user = new User();
        user.setUser_id(UUID.randomUUID().toString());
        user.setUser_name("刘德华");
        user.setPassword("asdasdasdasdasd");
        user.setSex("0");
        user.setType("0");
        user.setOrder_status("2");
        user.setCreate_at(new Date());
        user.setUpdate_at(new Date());

        int ret = userService.create(user);
        Log.info("创建结果{}", ret);
        return ret;
    }
}
