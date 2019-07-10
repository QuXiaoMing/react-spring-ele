package com.shellming.eleservice.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shellming.eleservice.common.ResultBean;
import com.shellming.eleservice.entity.Category;
import com.shellming.eleservice.entity.Shop;
import com.shellming.eleservice.service.impl.CategoryServiceImpl;
import com.shellming.eleservice.service.impl.ShopServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@Api(description = "商家接口")
@RequestMapping("shop")
@Slf4j
public class ShopController {

    @Autowired
    private ShopServiceImpl shopService;

    @Autowired
    private CategoryServiceImpl categoryService;

    @ApiOperation(value = "创建商户")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResultBean create(@RequestBody @Valid Shop shop) {
        // 绑定分类
        this.bindShop(shop);

        shop.setId(UUID.randomUUID().toString());
        shop.setLatitude(12.12);
        shop.setLongitude(12.12);
        log.info("创建商户:{}", shop);
        int ret = shopService.create(shop);
        if (ret > 0) {
            return ResultBean.success("创建成功");
        }
        return ResultBean.fail("创建失败");
    }

    @ApiOperation(value = "修改商户信息")
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResultBean updateByPrimaryKeySelective(@RequestBody @Valid Shop shop) {
        log.info("修改商户信息:{}", shop);
        this.bindShop(shop);
        // TODO 报错
        int ret = shopService.updateByPrimaryKey(shop);
        if (ret > 0) {
            return ResultBean.success("修改成功");
        }
        return ResultBean.fail("修改失败");
    }

    private void bindShop(Shop shop) {
        try {
            // 绑定分类
            Integer categoryId = Integer.parseInt(shop.getCategory());
            Category category = categoryService.selectByPrimaryKey(categoryId);
            String categoryJsonString = JSON.toJSONString(category);
            log.info("category:{}", categoryJsonString);
            shop.setCategory(categoryJsonString);
        } catch (NumberFormatException e) {
            log.error("绑定分类失败{}", e);
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "商户列表")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultBean list(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, @RequestParam(required = false) String name) {
        PageHelper.startPage(pageNum, pageSize);
        Map map = new HashMap();
        if (StringUtils.isNotBlank(name)) {
            map.put("name", name);
        }
        log.info("商户列表:{}", map);
        List ret = shopService.list(map);
        PageInfo pageInfo = new PageInfo(ret);
        log.info("商户列表:{}", pageInfo);
        return ResultBean.success(pageInfo);
    }


    @ApiOperation(value = "商户详情")
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResultBean list(@PathVariable("id") String id) {
        log.info("商户详情:{}", id);
        Shop shop = shopService.selectByPrimaryKey(id);
        if (shop == null) {
            return ResultBean.fail("店铺不存在");
        }
        return ResultBean.success(shop);
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    @ApiOperation("城市搜索")
    public ResultBean search(@RequestParam("latitude") Double latitude, @RequestParam("longitude") Double longitude) {
        Map map = new HashMap();
        map.put("longitude", longitude);
        map.put("latitude", latitude);
        log.info("搜索餐馆{}", map);
        List list = shopService.search(map);
        log.info("搜索餐馆 -> {}", list);
        if (list != null) {
            return ResultBean.success(list);
        }
        return ResultBean.fail("获取失败");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation("删除店铺")
    public ResultBean deleteBy(@PathVariable("id") String id) {
        int ret = shopService.deleteByPrimaryKey(id);
        if (ret > 0) {
            return ResultBean.success("删除成功");
        }
        return ResultBean.fail("删除失败");
    }
}
