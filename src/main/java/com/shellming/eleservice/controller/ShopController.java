package com.shellming.eleservice.controller;

import com.shellming.eleservice.common.ResultBean;
import com.shellming.eleservice.entity.Shop;
import com.shellming.eleservice.service.impl.ShopServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
