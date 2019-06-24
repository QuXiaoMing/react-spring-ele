package com.shellming.eleservice.controller;

import com.shellming.eleservice.common.ResultBean;
import com.shellming.eleservice.entity.User;
import com.shellming.eleservice.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping(value = "user")
@Api(description = "用户接口")
public class UserController{
    Logger Log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "用户列表" ,  notes="查询用户列表")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultBean getUserList(@RequestParam(defaultValue = "0") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        Log.info("获取用户列表");
        Map map = new HashMap();
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        return ResultBean.success(userService.list(map));
    }

    @ApiOperation(value = "创建用户" ,  notes="创建用户")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResultBean<?> create(@RequestBody @Valid User user) throws Exception {
        Log.info("创建用户{}", user);
        user.setUser_id(UUID.randomUUID().toString());
        user.setCreate_at(new Date());
        user.setUpdate_at(new Date());

        int ret = userService.create(user);
        if (ret > 0) {
            return ResultBean.success(ret);
        }
        Log.info("创建结果{}", ret);
        throw new Exception("创建失败");
    }
}
