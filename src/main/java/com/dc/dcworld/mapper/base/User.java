package com.dc.dcworld.mapper.base;

import lombok.Data;
import lombok.ToString;

/**
 * @author: 一块儿小饼干
 * @ProjectName: dcworld
 * @Description:
 * @date: 2021/4/18 19:51
 */
@Data
@ToString
public class User {
    private Long userId;
    private String fullName;
    private String username;
    private String password;
    private Short status;
}
