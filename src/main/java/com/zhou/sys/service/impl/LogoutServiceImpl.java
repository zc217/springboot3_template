package com.zhou.sys.service.impl;

import com.zhou.sys.service.LogoutService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LogoutServiceImpl implements LogoutService {

    @Autowired
    private HttpServletRequest request;

    @Override
    public Boolean logout() {
        String token = request.getHeader("token");

//        token
        return true;
    }
}
