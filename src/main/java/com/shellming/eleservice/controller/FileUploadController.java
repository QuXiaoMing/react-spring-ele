package com.shellming.eleservice.controller;


import com.alibaba.fastjson.JSON;
import com.shellming.eleservice.common.ResultBean;
import com.shellming.eleservice.service.impl.FileUploadServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Api(value = "文件上传", description = "文件上传")
@RequestMapping("/upload")
@RestController
@Slf4j
public class FileUploadController {

    @Autowired
    private FileUploadServiceImpl fileUploadService;

    @ApiOperation(value = "上传")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResultBean uploadApk(MultipartFile[] file, HttpServletRequest request, HttpServletResponse response) throws Exception{
        log.info("上传{}", file.length);
        List result = new ArrayList();
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;

        for (MultipartFile fileItem : file) {
            ResultBean ret = fileUploadService.upload(fileItem, path, basePath);
            if (ret.isSuccess()) {
                Object data = ret.getData();
                result.add(data);
            } else {
                log.info(ret.getMsg());
            }
        }
        return ResultBean.success(result);
    }
}