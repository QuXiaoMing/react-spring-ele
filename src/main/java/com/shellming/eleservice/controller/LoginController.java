package com.shellming.eleservice.controller;

import com.shellming.eleservice.config.JwtParam;
import com.shellming.eleservice.service.JwtIgnore;
import com.shellming.eleservice.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private JwtParam jwtParam;

    // 登录
    @GetMapping("/login")
    @JwtIgnore // 加此注解, 请求不做token验证
    public String login() {
        // 1.用户密码验证我这里忽略, 假设用户验证成功, 取得用户id为5
        Integer userId = 5;
        // 2.验证通过生成token
        String token = JwtUtils.createToken(userId + "", jwtParam);
        if (token == null) {
            log.error("===== 用户签名失败 =====");
            return null;
        }
        log.info("===== 用户{}生成签名{} =====", userId, token);
        return JwtUtils.getAuthorizationHeader(token);
    }

    // 验证
    @PostMapping("/hilox")
    public String hilox() {
        return "Hello World!";
    }
}
