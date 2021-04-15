package com.dc.dcworld.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @author Dell
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
