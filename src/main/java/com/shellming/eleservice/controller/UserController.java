package com.shellming.eleservice.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @ApiOperation(value = "获取用户信息" ,  notes="获取用户信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultBean getUserList(@PathVariable("id") String id) {
        Log.info("获取用户信息" + id);
        User user = userService.getUserById(id);
        Log.info("获取用户信息{}", user);
        return ResultBean.success(user);
    }

    @ApiOperation(value = "用户列表" ,  notes="查询用户列表")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultBean getUserList(@RequestParam(defaultValue = "0") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Log.info("获取用户列表");
        Map map = new HashMap();
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);

        List<User> userList = userService.list(map);
        PageInfo<User> result = new PageInfo<>(userList);
        Log.info("获取用户列表{}", userList);
        return ResultBean.success(result);
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

    @ApiOperation(value = "设置用户角色" ,  notes="设置用户角色")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResultBean<?> setRoles(@PathVariable("id") String id,@RequestParam("roles") String rolse) throws Exception {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResultBean.fail("用户不存在");
        }
        Log.info("设置用户角色{},{}", user.toString(), rolse);
        user.setRoles(rolse);

        int ret = userService.updateByPrimaryKeySelective(user);
        Log.info("设置用户角色{}", ret);
        if (ret > 0) {
            return ResultBean.success(ret);
        }
        throw new Exception("设置失败");
    }
}
