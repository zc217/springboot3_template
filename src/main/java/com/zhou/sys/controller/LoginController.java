package com.zhou.sys.controller;

import com.zhou.common.entity.Result;
import com.zhou.sys.request.LoginRequest;
import com.zhou.sys.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("login")
    public Result<String> login(@RequestBody LoginRequest loginRequest){
        String token = loginService.login(loginRequest);
        return Result.success(token);
    }
}
