package com.dc.dcworld.service.impl;

import com.dc.dcworld.dao.log.UserLogDao;
import com.dc.dcworld.domain.log.UserLog;
import com.dc.dcworld.service.UserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: 一块儿小饼干
 * @ProjectName: dcworld
 * @Description:
 * @date: 2021/4/20 22:00
 */
@Service
public class UserLogServiceImpl implements UserLogService {
    @Autowired
    private com.dc.dcworld.dao.log.UserLogDao dao;
    @Override
    public void save(UserLog log) {
        dao.save(log);
    }
}
