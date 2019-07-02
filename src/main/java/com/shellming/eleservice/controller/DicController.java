package com.shellming.eleservice.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shellming.eleservice.common.ResultBean;
import com.shellming.eleservice.entity.Dic;
import com.shellming.eleservice.service.impl.DicSerciveImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@Slf4j
@Api(description = "字典维护")
@RequestMapping(value = "dic")
public class DicController {

    @Autowired
    private DicSerciveImpl dicSercive;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "字典列表")
    public ResultBean list(@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(required = false) String name, @RequestParam(required = false) String key) {
        Map map = new HashMap();
        if (StringUtils.isNotBlank(name)) {
            map.put("name", name);
        }
        if (StringUtils.isNotBlank(key)) {
            map.put("key", key);
        }
        PageHelper.startPage(pageNum, pageSize);
        log.info("获取系统字典列表:{}", map);
        List list = dicSercive.list(map);
        log.info("获取系统字典列表 ->: {}", list);
        PageInfo pageInfo = new PageInfo(list);
        return ResultBean.success(pageInfo);
    }

    @ApiOperation(value = "增加字段")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResultBean create(@RequestBody Dic dic) {
        log.info("添加字段{}", dic);
        dic.setId(UUID.randomUUID().toString());
        int ret = dicSercive.insert(dic);
        if (ret > 0) {
            return ResultBean.success("添加成功");
        }
        return ResultBean.fail("添加失败");
    }

    @ApiOperation(value = "删除字段")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultBean deleteByPrimaryKey(@PathVariable("id") String id) {
        log.info("删除字段{}", id);
        int ret = dicSercive.deleteByPrimaryKey(id);
        if (ret > 0) {
            return ResultBean.success("删除成功");
        }
        return ResultBean.fail("删除失败");
    }

}
