package com.shellming.eleservice.interceptor;

import com.shellming.eleservice.common.BusinessException;
import com.shellming.eleservice.common.ResultBean;
import com.shellming.eleservice.config.JwtParam;
import com.shellming.eleservice.constant.JwtConstant;
import com.shellming.eleservice.service.JwtIgnore;
import com.shellming.eleservice.util.JwtUtils;
import io.jsonwebtoken.Claims;
import io.swagger.models.HttpMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtInterceptor implements HandlerInterceptor {

    Logger log = LoggerFactory.getLogger(JwtInterceptor.class);

    @Autowired
    private JwtParam jwtParam;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        // 鉴权白名单
        String uri = request.getRequestURI().toString();
        if (JwtConstant.isIgnoreUri(uri)) {
            return true;
        }

        // 忽略带JwtIgnore注解的请求, 不做后续token认证校验
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            JwtIgnore jwtIgnore = handlerMethod.getMethodAnnotation(JwtIgnore.class);
            if (jwtIgnore != null) {
                return true;
            }
        }

        if (HttpMethod.OPTIONS.equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        final String authHeader = request.getHeader(JwtConstant.AUTH_HEADER_KEY);

        if (StringUtils.isEmpty(authHeader)) {
            // TODO 这里自行抛出异常
            log.info("===== 用户未登录, 请先登录 =====");
            this.sendResult(response,"401", "未登陆");
            return false;
        }

        // 校验头格式校验
        if (!JwtUtils.validate(authHeader)) {
            // TODO 这里自行抛出异常
            log.info("===== token格式异常 =====");
            this.sendResult(response,"401", "token格式异常");
            return false;
        }

        // token解析
        final String authToken = JwtUtils.getRawToken(authHeader);
        Claims claims = JwtUtils.parseToken(authToken, jwtParam.getBase64Secret());
        if (claims == null) {
            log.info("===== token解析异常 =====");
            this.sendResult(response,"401", "token解析异常");
            return false;
        }

        // 传递所需信息
        request.setAttribute("CLAIMS", claims);
        return true;
    }

    private void sendResult(HttpServletResponse response, String code, String message) {
        try {
            response.getOutputStream().write(ResultBean.fail(code, message).toString().getBytes());
        } catch (Exception e) {
            log.error("sendResult{}", e);
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {

    }
}