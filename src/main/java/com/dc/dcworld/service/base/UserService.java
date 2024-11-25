package com.dc.dcworld.service.base;


import com.dc.dcworld.mapper.base.User;
import com.dc.dcworld.utils.http.DcHttp;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author: 一块儿小饼干
 * @ProjectName: dcworld
 * @Description:
 * @date: 2021/4/18 19:51
 */
public interface UserService {

    
    List<User> getAll();

    DcHttp<User> save(User user);

    DcHttp<String> login(User user, HttpServletRequest request);

    User findByUserName(String username);

    Map<Long, User> obtainUserMap();
}
