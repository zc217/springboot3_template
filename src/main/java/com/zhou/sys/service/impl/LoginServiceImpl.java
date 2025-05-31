package com.zhou.sys.service.impl;

import com.zhou.common.exception.BusinessException;
import com.zhou.common.utils.JwtUtils;
import com.zhou.common.utils.PasswordUtils;
import com.zhou.common.utils.RedisUtils;
import com.zhou.sys.mapper.SysUserMapper;
import com.zhou.sys.model.SysUser;
import com.zhou.sys.request.LoginRequest;
import com.zhou.sys.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private RedisUtils redisUtils;


    @Override
    public String login(LoginRequest loginRequest) {
        SysUser sysUser = sysUserMapper.queryByUsername(loginRequest.getUsername());
        log.info("sysUser:{}", sysUser);
        if (sysUser == null) {
            throw new BusinessException(500, "用户名不存在");
        }
        if (!PasswordUtils.matches(loginRequest.getPassword(), sysUser.getPassword())) {
            throw new BusinessException(500, "密码错误！");
        }
        String token = JwtUtils.create(sysUser);

        String key = loginRequest.getUsername().concat(":token");
        redisUtils.set(key, token, 60 * 60 * 2);

        return token;
    }
}
