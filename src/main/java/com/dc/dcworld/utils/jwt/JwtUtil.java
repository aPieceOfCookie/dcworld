package com.dc.dcworld.utils.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: 一块儿小饼干
 * @ProjectName: dcworld
 * @Description:  令牌工具类
 * @date: 2021/4/18 19:51
 */
public class JwtUtil {
    /**
     * 令牌
     */
    private static final String TOKEN="1!2@3#4$5%6^7&8*9(0)";

    /**
     * 生成token
     * @param map
     * @return
     */
    public static String createToken(Map<String,Object> map){
        Calendar calendar=Calendar.getInstance();
        //默认一天过期
        calendar.add(Calendar.HOUR,24);
        JWTCreator.Builder builder = JWT.create();
        map.forEach((k,v)->{
            builder.withClaim(k,v.toString());
        });
        return builder.withExpiresAt(calendar.getTime()).sign(Algorithm.HMAC256(TOKEN));
    }

    /**
     * 验证token合法性
     * @param token
     */
    public static void verifyToken(String token){
       try {
           JWT.require(Algorithm.HMAC256(TOKEN)).build().verify(token);
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    /**
     * 获取token中的信息
     * @param token
     * @return
     */
    public static DecodedJWT getTokenInfo(String token){
        return JWT.require(Algorithm.HMAC256(TOKEN)).build().verify(token);
    }

    /**
     * 测试方法
     * @param args
     */
    public static void main(String[] args) {
        Map<String, Object> testMap = new HashMap<>();
        testMap.put("userId","12");
        testMap.put("username","helloworld");
        String token=JwtUtil.createToken(testMap);
        System.out.println(token);

        DecodedJWT verify =JwtUtil.getTokenInfo(token);
        System.out.println(verify.getClaim("userId").asString());
        System.out.println(verify.getClaim("username").asString());
        /*Calendar calendar=Calendar.getInstance();
        //默认一天过期
        calendar.add(Calendar.HOUR,24);
        JWTCreator.Builder builder = JWT.create();
        String token=builder.withClaim("username","nihao")
                .withClaim("userId",12)
                .withExpiresAt(calendar.getTime())
                .sign(Algorithm.HMAC256(TOKEN));
        System.out.println(token);

        DecodedJWT verify = JWT.require(Algorithm.HMAC256(TOKEN)).build().verify(token);
        System.out.println(verify.getClaim("userId").asInt());
        System.out.println(verify.getClaim("username").asString());*/
    }
}
