package com.shellming.eleservice.controller;

import com.shellming.eleservice.common.ResultBean;
import com.shellming.eleservice.entity.Role;
import com.shellming.eleservice.service.impl.RoleServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "role")
@Api(description = "角色接口")
public class RoleController {
    Logger Log = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    RoleServiceImpl roleService;

    @ApiOperation(value = "角色列表" ,  notes="查询角色列表")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultBean list() throws Exception {
        Log.info("获取角色列表");
        Map map = new HashMap();
        return ResultBean.success(roleService.list(map));
    };

    @ApiOperation(value = "角色列表" ,  notes="创建角色")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResultBean insert(@RequestBody Role role) throws Exception {
        role.setId(UUID.randomUUID().toString());
        Log.info("创建角色{}", role);
        int ret = roleService.insert(role);
        Log.info("创建角色 -> {}", ret);
        if (ret > 0) {
            return ResultBean.success(ret);
        }
        return ResultBean.fail("创建失败");
    };

    @ApiOperation(value = "删除用户" ,  notes="删除角色")
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ResultBean deleteByPrimaryKey(@RequestBody String id) {
        Log.info("删除用户{}", id);
        int ret = roleService.deleteByPrimaryKey(id);
        Log.info("删除用户 -> {}", ret);
        if (ret > 0) {
            return ResultBean.success(ret);
        }
        return ResultBean.fail("删除失败");
    };
}
