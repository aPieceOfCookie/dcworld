package com.dc.dcworld.controller;

import com.dc.dcworld.domain.User;
import com.dc.dcworld.service.UserService;
import com.dc.dcworld.utils.http.DcHttp;
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
     * 测试
     * @return
     */
    @GetMapping("/user/login")
    public List<String> login(){
        List<String> demoList = new ArrayList<>();
        demoList.add("success");
        return demoList;
    }

    /**
     * 注册
     * @return
     */
    @GetMapping("/register")
    @ResponseBody
    public DcHttp<User> register(@RequestBody User user){
        return userService.save(user);
    }

    @RequestMapping("/hello")
    public void hello(){
        System.out.println("hello world");
    }

    @GetMapping("/user/userList")
    @ResponseBody
    public List<User> getUserList(){
        return userService.getAll();
    }

    @GetMapping("/page")
    @ResponseBody
    public PageInfo<User> getUserL(){
        List<User> userList=userService.getAll();
        return new PageInfo<>(userList);
    }
}
