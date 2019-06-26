package com.shellming.eleservice.controller;

import com.shellming.eleservice.common.ResultBean;
import com.shellming.eleservice.service.JwtIgnore;
import com.shellming.eleservice.service.impl.CityServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("city")
@Api("城市接口")
public class CityController {

    @Autowired
    private CityServiceImpl cityService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation("获取城市列表")
    @JwtIgnore
    public ResultBean list() {
        int cout = cityService.loadCityData();
        return ResultBean.success(cout);
    }
}
