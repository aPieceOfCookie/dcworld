package com.dc.dcworld.service;

import com.dc.dcworld.domain.log.UserLog;

import java.util.List;

/**
 * @author: 一块儿小饼干
 * @ProjectName: dcworld
 * @Description:
 * @date: 2021/4/20 22:00
 */
public interface UserLogService {
    /**
     * 保存登录日志
     * @param log
     */
    void save(UserLog log);

    /**
     * 查询所有日志信息
     * @return
     */
    List<UserLog> getAll();

    /**
     * 删除日志信息
     * @param logId
     */
    void remove(Long logId);
}
