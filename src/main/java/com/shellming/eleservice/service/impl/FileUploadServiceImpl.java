package com.shellming.eleservice.service.impl;

import com.shellming.eleservice.common.ResultBean;
import com.shellming.eleservice.service.IFileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class FileUploadServiceImpl implements IFileUploadService {

    @Override
    public ResultBean upload(MultipartFile myfiles, String path, String basePath) throws Exception {
        if (myfiles.getSize() > 1024 * 1024 * 5) {
            return ResultBean.fail("文件过大，请上传5M以内的图片");
        }
        Date dt = new Date();
        Long time = dt.getTime();

        if (myfiles == null) {
            return ResultBean.fail("未选择文件");
        }

        String realPath = "d://uploadFiles/";      //  获取保存的路径，本地磁盘中的一个文件夹
        if (myfiles.isEmpty()) {
            //  未选择文件
            return ResultBean.fail("未选择文件");
        } else {
            //  文件原名称
            String originFileName = "";
            //  上传文件重命名
            String originalFilename = time.toString().substring(time.toString().length() - 8,
                    time.toString().length());
            originalFilename = originalFilename.concat(".");
            originalFilename = originalFilename.concat(myfiles.getOriginalFilename().toString()
                    .substring(myfiles.getOriginalFilename().toString().indexOf(".") + 1));
            //  这里使用Apache的FileUtils方法来进行保存
            FileUtils.copyInputStreamToFile(myfiles.getInputStream(), new File(realPath, originalFilename));
            Map resMap = new HashMap();
            resMap.put("filename", originalFilename);
            resMap.put("path", basePath + "/static/image/" + originalFilename);
            resMap.put("relativePath", "/static/image/" + originalFilename);
            return ResultBean.success(resMap);
        }
    }
}
