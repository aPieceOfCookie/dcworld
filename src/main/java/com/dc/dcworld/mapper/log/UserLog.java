package com.dc.dcworld.mapper.log;

import lombok.Data;

import java.util.Date;

/**
 * @author: 一块儿小饼干
 * @ProjectName: dcworld
 * @Description:
 * @date: 2021/4/20 21:01
 */
@Data
public class UserLog {
    private Long logId;
    private String address;
    private String ip;
    private Date loginTime;
}
