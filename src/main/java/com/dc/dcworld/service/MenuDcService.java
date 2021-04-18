package com.dc.dcworld.service;

import com.dc.dcworld.domain.MenuDc;

import java.util.List;

/**
 * @author: 一块儿小饼干
 * @ProjectName: dcworld
 * @Description:
 * @date: 2021/4/18 21:47
 */
public interface MenuDcService {
    /**
     * 获得所有菜单列表
     * @return
     */
    List<MenuDc> getAll();
}
