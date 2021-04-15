package com.dc.dcworld.service;


import com.dc.dcworld.domain.User;
import com.dc.dcworld.utils.http.DcHttp;

import java.util.List;

/**
 * @author Dell
 */

public interface UserService {

    List<User> getAll();

    DcHttp<User> save(User user);
}
