package com.zhou.sys.model;

import lombok.Data;

@Data
public class SysUser {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String sex;
    private Long deptId;
    private Long postId;
    private String realName;
}
