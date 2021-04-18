package com.dc.dcworld.domain;

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
    private Integer userId;
    private String fullname;
    private String username;
    private String password;
    private Short status;
}
