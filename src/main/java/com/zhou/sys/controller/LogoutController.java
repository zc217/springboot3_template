package com.zhou.sys.controller;

import com.zhou.common.Result;
import com.zhou.sys.service.LogoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoutController {

    @Autowired
    private LogoutService logoutService;

    @GetMapping("/logout")
    public Result<Boolean> logout() {
        Boolean result =  logoutService.logout();
        return Result.success(result);
    }
}
