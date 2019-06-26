package com.shellming.eleservice.controller;

import com.shellming.eleservice.common.ResultBean;
import com.shellming.eleservice.config.JwtParam;
import com.shellming.eleservice.constant.JwtConstant;
import com.shellming.eleservice.entity.User;
import com.shellming.eleservice.service.JwtIgnore;
import com.shellming.eleservice.service.impl.UserServiceImpl;
import com.shellming.eleservice.util.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@Api(description = "登录接口")
public class LoginController {

    @Autowired
    private JwtParam jwtParam;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    protected RedisTemplate redisTemplate;

    // 登录
    @ApiOperation(value = "登录")
    @PostMapping("/login")
    @JwtIgnore // 加此注解, 请求不做token验证
    public ResultBean login(@RequestParam("username") String username, @RequestParam("password") String password) {
        if (!StringUtils.isNotBlank(username) || !StringUtils.isNotBlank(password)) {
            return ResultBean.fail("用户名密码不能为空");
        }
        User user = userService.getUserByUserName(username);
        if (user == null) {
            return ResultBean.fail("用户不存在");
        }
        if (!user.getPassword().equals(password)) {
            return ResultBean.fail("帐号或密码错误");
        }
        // 1.用户密码验证我这里忽略, 假设用户验证成功, 取得用户id为5
        String userId = user.getUser_id();
        // 2.验证通过生成token
        String token = JwtUtils.createToken(userId, jwtParam);
        if (token == null) {
            log.error("===== 用户签名失败 =====");
            return null;
        }
        log.info("===== 用户{}生成签名{} =====", userId, token);

        // 储存到 Redis
        redisTemplate.opsForValue().set(JwtConstant.AUTH_HEADER_KEY + token, user);
        return ResultBean.success(JwtUtils.getAuthorizationHeader(token));
    }

    // 退出登录
    @ApiOperation("退出登录")
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResultBean logout(HttpServletRequest request) {
        // token解析
        final String authHeader = request.getHeader(JwtConstant.AUTH_HEADER_KEY);
        final String authToken = JwtUtils.getRawToken(authHeader);
        log.info("退出登录" + authToken);
        redisTemplate.opsForValue().set(JwtConstant.AUTH_HEADER_KEY + authToken, null);
        return ResultBean.success("操作成功");
    }


    // 验证
    @PostMapping("/hilox")
    @JwtIgnore
    public String hilox() {
        return "Hello World!";
    }
}
