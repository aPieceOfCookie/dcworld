package com.dc.dcworld.controller.log;

import com.dc.dcworld.mapper.log.UserLog;
import com.dc.dcworld.service.log.UserLogService;
import com.dc.dcworld.utils.http.DcHttp;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    @Resource
    private UserLogService userLogService;

    /**
     * 获取所有登录日志信息
     * @return 结果
     */
    @RequestMapping("/getAll")
    public DcHttp<List<UserLog>> getAll(){
        List<UserLog> userLogList=userLogService.getAll();
        return DcHttp.success(userLogList);
    }

    @DeleteMapping("/delOne")
    public DcHttp<Void> delUserLog(Long logId){
        userLogService.remove(logId);
        return DcHttp.success();
    }
}
