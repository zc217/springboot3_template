package com.zhou.common.utils;

import com.zhou.sys.model.SysUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JwtUtils {
    private static final String SECRET_KEY = "zhou";
    
    public static String create(SysUser sysUser) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("uuid", UUIDUtils.uuid());
        claims.put("username", sysUser.getUsername());
        claims.put("userid", sysUser.getId());
        
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                //.setExpiration(new Date())
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
                .compact();
    }
    
    public static Claims parse (String token){
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJwt(token)
                .getBody();
        
        return claims;
    }
}
