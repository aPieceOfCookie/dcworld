package com.dc.dcworld.service.impl;

import com.dc.dcworld.dao.UserDao;
import com.dc.dcworld.domain.User;
import com.dc.dcworld.service.UserService;
import com.dc.dcworld.utils.http.DcHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dell
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
}
