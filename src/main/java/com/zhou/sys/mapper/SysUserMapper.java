package com.zhou.sys.mapper;

import com.zhou.sys.model.SysUser;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {

    SysUser queryByUsername(@Param("username") String username);
}
