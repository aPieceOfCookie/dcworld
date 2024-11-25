package com.dc.dcworld.service.base.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dc.dcworld.dao.base.UserDao;
import com.dc.dcworld.dao.log.UserLogDao;
import com.dc.dcworld.mapper.base.User;
import com.dc.dcworld.mapper.log.UserLog;
import com.dc.dcworld.service.base.UserService;
import com.dc.dcworld.utils.http.DcHttp;
import com.dc.dcworld.utils.http.ResultCode;
import com.dc.dcworld.utils.ip.IpUtil;
import com.dc.dcworld.utils.jwt.JwtUtil;
import com.dc.dcworld.utils.log.IpLogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: 一块儿小饼干
 * @ProjectName: dcworld
 * @Description:
 * @date: 2021/4/18 19:51
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Resource
    private UserLogDao userLogDao;

    @Override
    public List<User> getAll() {
        return dao.getUserList();
    }

    @Override
    public DcHttp<User> save(User user) {
        dao.save(user);
        return DcHttp.success();
    }

    @Override
    public DcHttp<String> login(User user, HttpServletRequest request) {
        // 记录登录日志
        saveLog(request);
        User oldUser=dao.findByUserName(user.getUsername());
        if(user.getPassword()!=null&&oldUser.getPassword()!=null){
            if(user.getPassword().equals(oldUser.getPassword())){
                Map<String, Object> jwtMap = new HashMap<>();
                jwtMap.put("userId",oldUser.getUserId());
                Map<String,String> tokenMap=new HashMap<>();
                tokenMap.put("token",JwtUtil.createToken(jwtMap));
                String json=JSON.toJSONString(tokenMap);
                System.out.println(json);
                return DcHttp.success(json);
            }else{
                return DcHttp.failed("帐号或密码错误");
            }
        }else{
            return DcHttp.failed(ResultCode.DATA_NOT_FOUND_EXCEPTION);
        }
    }

    @Async
    void saveLog(HttpServletRequest request) {
        UserLog log=new UserLog();
        String ip= IpUtil.getIpAdrress(request);
        String baseIp=request.getHeader("x-forwarded-for");
        if("127.0.0.1".equals(baseIp)){
            log.setAddress("");
        }else{
            String address= IpLogUtil.getCityInfo(ip);
            log.setAddress(address);
        }
        log.setIp(baseIp);
        log.setLoginTime(new Date().toString());
        userLogDao.save(log);
    }

    @Override
    public User findByUserName(String username) {
        return dao.findByUserName(username);
    }

    @Override
    public Map<Long, User> obtainUserMap() {
        return dao.getUserMap();
    }
}
