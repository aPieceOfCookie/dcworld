package com.dc.dcworld.controller.base;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dc.dcworld.mapper.base.User;
import com.dc.dcworld.mapper.log.UserLog;
import com.dc.dcworld.service.log.UserLogService;
import com.dc.dcworld.service.base.UserService;
import com.dc.dcworld.utils.ip.IpUtil;
import com.dc.dcworld.utils.jwt.JwtUtil;
import com.dc.dcworld.utils.http.DcHttp;
import com.dc.dcworld.utils.http.ResultCode;
import com.dc.dcworld.utils.log.IpLogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    private UserLogService userLogService;

    /**
     * 登录
     * @param user form体
     * @return 成功或失败状态
     */
    @PostMapping("/login")
    public DcHttp<String> login(@RequestBody User user, HttpServletRequest request){
        //重新开辟线程
        new Thread(()->{
            String ip=IpUtil.getIpAdrress(request);
            String baseIp=request.getHeader("x-forwarded-for");
            if("127.0.0.1".equals(baseIp)){
                UserLog log=new UserLog();
                log.setIp("127.0.0.1");
                log.setLoginTime(new Date());
                log.setAddress("");
                userLogService.save(log);
            }else{
                String address=IpLogUtil.getCityInfo(ip);
            }
        });
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

    @PostMapping("/userMap")
    public ResponseEntity<Map<Long,User>> obtainUserMap(){
        Map<Long,User> userMap=userService.obtainUserMap();
        return ResponseEntity.ok(userMap);
    }

   /* public ResponseEntity<User> listUser(){
        User user = new User();
        return new ResponseEntity<User>(user,HttpStatus.ACCEPTED);
    }*/

}
