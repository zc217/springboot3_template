package com.zhou.common.utils;

import com.zhou.common.exception.BusinessException;
import com.zhou.sys.model.SysUser;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JwtUtils {
    private static final String SECRET_KEY = "zhou";
    
    public static String create(SysUser sysUser) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("uuid", UUIDUtils.uuid());
        claims.put("username", sysUser.getUsername());
        claims.put("realName", sysUser.getRealName());
        claims.put("userid", sysUser.getId());
        
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                //.setExpiration(new Date())
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
                .compact();
    }
    
    public static Claims parse (String token){
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException |
                 IllegalArgumentException e) {
            log.error("token非法",e);
            throw new BusinessException(2000,"token非法");
        }

        return claims;
    }
}
