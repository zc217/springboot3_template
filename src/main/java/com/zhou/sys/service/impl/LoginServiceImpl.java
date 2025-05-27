package com.zhou.sys.service.impl;

import com.zhou.common.BusinessException;
import com.zhou.sys.mapper.SysUserMapper;
import com.zhou.sys.model.SysUser;
import com.zhou.sys.request.LoginRequest;
import com.zhou.sys.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public String login(LoginRequest loginRequest) {
        SysUser sysUser = sysUserMapper.queryByUsername(loginRequest.getUsername());
        log.info("sysUser:{}", sysUser);
        if (sysUser == null) {
            throw new BusinessException(500,"用户名不存在");
        }
        if (!sysUser.getPassword().equals(loginRequest.getPassword())) {  //todo password
            throw new BusinessException(500,"密码错误！");
        }
        return UUID.randomUUID().toString(); //todo JWT
    }
}
