package com.dc.dcworld.service;


import com.dc.dcworld.domain.User;
import com.dc.dcworld.utils.http.DcHttp;

import java.util.List;

/**
 * @author: 一块儿小饼干
 * @ProjectName: dcworld
 * @Description:
 * @date: 2021/4/18 19:51
 */
public interface UserService {

    
    List<User> getAll();

    DcHttp<User> save(User user);

    DcHttp<String> login(User user);

    User findByUserName(String username);
}
