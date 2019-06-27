package com.shellming.eleservice.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shellming.eleservice.common.ResultBean;
import com.shellming.eleservice.entity.Shop;
import com.shellming.eleservice.service.impl.ShopServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(description = "商家接口")
@RequestMapping("shop")
@Slf4j
public class ShopController {

    @Autowired
    private ShopServiceImpl shopService;

    @ApiOperation(value = "创建商户")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResultBean create(@RequestBody Shop shop) {
        log.info("创建商户:{}", shop);
        int ret = shopService.create(shop);
        if (ret > 0) {
            return ResultBean.success("创建成功");
        }
        return ResultBean.fail("创建失败");
    }

    @ApiOperation(value = "商户列表")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultBean create(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Map map = new HashMap();
        log.info("商户列表:{}", map);
        List ret = shopService.list(map);
        PageInfo pageInfo = new PageInfo(ret);
        log.info("商户列表:{}", pageInfo);
        return ResultBean.success(pageInfo);
    }
}
