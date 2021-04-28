package com.dc.dcworld.controller;

import com.dc.dcworld.domain.log.UserLog;
import com.dc.dcworld.service.UserLogService;
import com.dc.dcworld.utils.http.DcHttp;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @DeleteMapping("/delOne")
    public DcHttp delUserLog(@PathVariable("logId") Long logId){
        System.out.println(logId);
        //userLogService.remove(logId);
        return DcHttp.success();
    }
}
