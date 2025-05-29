package com.zhou.sys.controller;

import com.zhou.common.Result;
import com.zhou.common.utils.JwtUtils;
import com.zhou.sys.response.HomeResponse;
import com.zhou.sys.service.HomeService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    
    @Autowired
    private HomeService homeService;
    
    @GetMapping("/home")
    public Result<HomeResponse> home(){
        
        HomeResponse homeResponse = homeService.home();
        return Result.success(homeResponse);
    }
}
