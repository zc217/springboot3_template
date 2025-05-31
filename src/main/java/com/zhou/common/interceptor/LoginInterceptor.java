package com.zhou.common.interceptor;

import com.zhou.common.exception.BusinessException;
import com.zhou.common.utils.JwtUtils;
import com.zhou.common.utils.RedisUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;


@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    private final RedisUtils redisUtils;

    public LoginInterceptor(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!request.getRequestURI().equals("/login")) {
            String token = request.getHeader("token");
            if (token == null) {
                throw new BusinessException(2001, "用户未登录");
            }
            Claims claims = JwtUtils.parse(token);
            String username = String.valueOf(claims.get("username"));
            String key = username + ":token";
            Object valueObj = redisUtils.get(key);
            if (valueObj == null) {
                throw new BusinessException(2002, "用户长时间未操作，请重新登录");
            }
            redisUtils.set(key, token, 60 * 60 * 2);
        }
        return true;
    }
}
