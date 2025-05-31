package com.zhou.sys.service.impl;

import com.zhou.common.utils.JwtUtils;
import com.zhou.common.utils.RedisUtils;
import com.zhou.sys.service.LogoutService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LogoutServiceImpl implements LogoutService {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public Boolean logout() {
        String token = request.getHeader("token");

        Claims claims = JwtUtils.parse(token);
        String username = String.valueOf(claims.get("username"));
        String key = username + ":token";
        redisUtils.delete(key);
//        redisUtils.delete(token);
        return true;
    }
}
