package com.dc.dcworld.service.log.impl;

import com.dc.dcworld.mapper.log.UserLog;
import com.dc.dcworld.service.log.UserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<UserLog> getAll() {
        return dao.getAll();
    }

    @Override
    public void remove(Long logId) {
        dao.remove(logId);
    }
}
