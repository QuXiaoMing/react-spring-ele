package com.shellming.eleservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "user")
public class User {
    Logger Log = LoggerFactory.getLogger(User.class);

    @RequestMapping(value = "")
    public List getUserList() {
        Log.info("获取用户列表");
        return new ArrayList();
    }
}
