package com.shellming.eleservice.constant;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class JwtConstant {
    public static String USER_ID_KEY = "USER_ID_KEY";
    public static String AUTH_HEADER_KEY = "Authorization";

    //    不鉴权的资源地址
    public static List<String> ignoreList = Arrays.asList("/swagger-ui", "/webjars", "/swagger-resources", "/v2/api-docs");

    //    判断资源是需要鉴权
    public static Boolean isIgnoreUri(String uri) {
        for (String ignoreUri:JwtConstant.ignoreList) {
            if (uri.startsWith(ignoreUri)) {
                return true;
            }
        }
        return false;
    }

}