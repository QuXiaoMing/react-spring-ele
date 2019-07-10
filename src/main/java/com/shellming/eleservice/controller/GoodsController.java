package com.shellming.eleservice.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shellming.eleservice.common.ResultBean;
import com.shellming.eleservice.entity.Goods;
import com.shellming.eleservice.service.impl.GoodsServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Api(value = "商品接口", description = "商品接口")
@RestController
@RequestMapping(value = "goods")
@Slf4j
public class GoodsController {
    @Autowired
    private GoodsServiceImpl goodsService;

    @ApiOperation(value = "商品列表")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultBean list(@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "1") int pageNum) throws Exception {
        HashMap map = new HashMap();
        PageHelper.startPage(pageNum, pageSize);
        log.info("商品列表{}", map);
        List list = goodsService.list(map);
        PageInfo ret = new PageInfo(list);
        return ResultBean.success(ret);
    }

    @ApiOperation(value = "添加商品")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResultBean insert(@RequestBody Goods goods) {
        log.info("添加商品{}", goods);
        int ret = goodsService.insert(goods);
        if (ret > 0) {
            return ResultBean.success(ret);
        }
        return ResultBean.fail("创建失败");
    }

    @ApiOperation(value = "修改商品信息")
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResultBean updateByPrimaryKeySelective(@RequestBody Goods goods) {
        log.info("修改商品商品{}", goods);
        int ret = goodsService.updateByPrimaryKeySelective(goods);
        if (ret > 0) {
            return ResultBean.success(ret);
        }
        return ResultBean.fail("修改失败");
    }

    @ApiOperation(value = "删除商品")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResultBean deleteByPrimaryKey(@PathVariable("id") int id) {
        log.info("删除商品{}", id);
        int ret = goodsService.deleteByPrimaryKey(id);
        if (ret > 0) {
            return ResultBean.success(ret);
        }
        return ResultBean.fail("删除失败");
    }

    @ApiOperation(value = "获取商品详情")
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResultBean selectByPrimaryKey(@PathVariable("id") int id) {
        log.info("获取商品详情{}", id);
        Goods ret = goodsService.selectByPrimaryKey(id);
        log.info("获取商品详情{}", ret);
        return ResultBean.success(ret);
    }
}
