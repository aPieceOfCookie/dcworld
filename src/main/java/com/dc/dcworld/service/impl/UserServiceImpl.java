package com.dc.dcworld.service.impl;

import com.dc.dcworld.dao.UserDao;
import com.dc.dcworld.domain.User;
import com.dc.dcworld.service.UserService;
import com.dc.dcworld.utils.http.DcHttp;
import com.dc.dcworld.utils.http.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public DcHttp<User> login(User user) {
        User oldUser=dao.findByUserName(user.getUsername());
        if(user.getPassword()!=null&&oldUser.getPassword()!=null){
            if(user.getPassword().equals(oldUser.getPassword())){
                return DcHttp.success();
            }else{
                return DcHttp.failed("帐号或密码错误");
            }
        }else{
            return DcHttp.failed(ResultCode.DATA_NOT_FOUND_EXCEPTION);
        }
    }

    @Override
    public User findByUserName(String username) {
        return dao.findByUserName(username);
    }
}
