package com.dc.dcworld.service.base;

import com.dc.dcworld.mapper.base.MenuDc;
import com.dc.dcworld.utils.http.DcHttp;

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
    DcHttp<List<MenuDc>> getAll();
}
