package com.dc.dcworld.controller;

import com.dc.dcworld.domain.User;
import com.dc.dcworld.service.UserService;
import com.dc.dcworld.utils.http.DcHttp;
import com.dc.dcworld.utils.http.ResultCode;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dell
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
        return userService.login(user);
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
}
