package com.dc.dcworld.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author: 一块儿小饼干
 * @ProjectName: dcworld
 * @Description:
 * @date: 2021/4/18 21:45
 */
@Data
public class MenuDc {
    private Long menuId;
    private String menuName;
    private String menuFlag;
    private Short grade;
    private Long parentId;
    private String create;
    private Long createId;
    private Date createDate;
}
