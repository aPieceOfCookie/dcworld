package com.dc.dcworld.controller;

import com.dc.dcworld.domain.User;
import com.dc.dcworld.service.UserService;
import com.dc.dcworld.utils.jwt.JwtUtil;
import com.dc.dcworld.utils.http.DcHttp;
import com.dc.dcworld.utils.http.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/login")
    public DcHttp<String> login(@RequestBody User user){
        return userService.login(user);
    }

    /**
     * 注册
     * @return null
     */
    @PostMapping("/register")
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
