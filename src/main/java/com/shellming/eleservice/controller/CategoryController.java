package com.shellming.eleservice.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shellming.eleservice.common.ResultBean;
import com.shellming.eleservice.entity.Category;
import com.shellming.eleservice.service.impl.CategoryServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "分类接口", description = "分类接口")
@Slf4j
@RequestMapping(value = "category")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;

    @ApiOperation(value = "分类列表")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultBean list(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, @RequestParam(required = false) String name) {
        Map map = new HashMap();
        if (StringUtils.isNotBlank(name)) {
            map.put("name", name);
        }
        log.info("查询分类列表", map);
        PageHelper.startPage(pageNum, pageSize);
        List list = categoryService.list(map);
        PageInfo ret = new PageInfo(list);
        return ResultBean.success(ret);
    }

    @ApiOperation(value = "添加分类")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResultBean create(@RequestBody Category category) {
        log.info("添加分类");
        int ret = categoryService.insert(category);
        log.info("创建结果{}", ret);
        if (ret > 0) {
            return ResultBean.success(ret);
        }
        return ResultBean.fail("创建失败");
    }

    @ApiOperation(value = "删除分类")
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ResultBean create(@RequestBody Integer id) {
        log.info("删除分类");
        int ret = categoryService.deleteByPrimaryKey(id);
        log.info("删除分类结果{}", ret);
        if (ret > 0) {
            return ResultBean.success(ret);
        }
        return ResultBean.fail("删除失败");
    }


    @ApiOperation(value = "修改分类")
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResultBean updateByPrimaryKeySelective(@RequestBody Category category) {
        log.info("修改分类:{}", category);
        int ret = categoryService.updateByPrimaryKeySelective(category);
        log.info("修改分类结果{}", ret);
        if (ret > 0) {
            return ResultBean.success(ret);
        }
        return ResultBean.fail("修改失败");
    }

    @ApiOperation(value = "获取子分类")
    @RequestMapping(value = "findByParentId", method = RequestMethod.GET)
    public ResultBean findByParentId(@RequestParam int parentId, @RequestParam Boolean tree) {
        log.info("获取子分类:" + parentId);
        List<Category> list = categoryService.findByParentId(parentId);
        if (tree == true && list.size() > 0) {
            log.info("获取树形菜单");
            for (Category o : list) {
                int id = o.getId();
                ResultBean ret = this.findByParentId(id, true);
                if (ret.isSuccess()) {
                    Object children = ret.getData();
                    o.setChildren((List) children);
                }
            }
        }
        log.info("获取树形菜单 ->{}", list);
        return ResultBean.success(list);
    }
}
