package com.dc.dcworld.controller;

import com.dc.dcworld.domain.User;
import com.dc.dcworld.service.UserService;
import com.dc.dcworld.utils.JwtUtil;
import com.dc.dcworld.utils.http.DcHttp;
import com.dc.dcworld.utils.http.ResultCode;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: 一块儿小饼干
 * @ProjectName: dcworld
 * @Description:
 * @date: 2021/4/18 19:51
 */
@RestController
@RequestMapping("/admin")
public class MainController {

    @Autowired
    private  UserService userService;


    /**
     * 登录
     * @param user form体
     * @return 成功或失败状态
     */
    @RequestMapping("login")
    public DcHttp<User> login(@RequestBody User user){
        Map<String, String> userMap = new HashMap<>();
        userMap.put("username",user.getUsername());
        userMap.put("password",user.getPassword());
        String token=JwtUtil.createToken(userMap);
        DcHttp<User> dcHttp=userService.login(user);
        return null;
    }

    /**
     * 注册
     * @return null
     */
    @GetMapping("/register")
    public DcHttp<User> register(@RequestBody User user){
        User newUser=userService.findByUserName(user.getUsername());
        if(newUser!=null){
            return DcHttp.failed(ResultCode.USER_HAS_EXISTED.getMessage());
        }
        return userService.save(user);
    }

    @PostMapping("/test")
    public DcHttp<User> test(String token){
        try {
            JwtUtil.verifyToken(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
