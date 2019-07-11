package com.shellming.eleservice.service;

import com.shellming.eleservice.common.ResultBean;
import org.springframework.web.multipart.MultipartFile;

public interface IFileUploadService {
    ResultBean upload(MultipartFile myfiles, String path, String basePath) throws Exception;
}
