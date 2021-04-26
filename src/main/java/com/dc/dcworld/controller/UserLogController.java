package com.dc.dcworld.controller;

import com.dc.dcworld.domain.log.UserLog;
import com.dc.dcworld.service.UserLogService;
import com.dc.dcworld.utils.http.DcHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: 一块儿小饼干
 * @ProjectName: dcworld
 * @Description:
 * @date: 2021/4/26 22:13
 */
@RestController
@RequestMapping("/userLog")
public class UserLogController {
    @Autowired
    private UserLogService userLogService;

    /**
     * 获取所有登录日志信息
     * @return
     */
    @RequestMapping("/getAll")
    public DcHttp<List<UserLog>> getAll(){
        List<UserLog> userLogList=userLogService.getAll();
        return DcHttp.success(userLogList);
    }
}
