package com.zhou.sys.service.impl;

import com.zhou.common.utils.JwtUtils;
import com.zhou.sys.response.HomeResponse;
import com.zhou.sys.service.HomeService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HttpServletRequest request;


    @Override
    public HomeResponse home() {
        String token = request.getHeader("token");
        Claims claims = JwtUtils.parse(token);
        String realName = String.valueOf(claims.get("realName"));
        HomeResponse homeResponse = new HomeResponse();
        homeResponse.setRealName(realName);
        return homeResponse;
    }
}
