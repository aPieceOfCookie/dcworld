package com.dc.dcworld.mapper.base;

import lombok.Data;

import java.util.Date;
import java.util.List;

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
    private String iconImg;
    /**
     * 路由
     */
    private String route;
    private Long childId;
    private Integer sn;
    private List<MenuDc> childList;
}
