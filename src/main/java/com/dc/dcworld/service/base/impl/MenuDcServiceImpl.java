package com.dc.dcworld.service.base.impl;

import com.dc.dcworld.dao.base.MenuDcDao;
import com.dc.dcworld.mapper.base.MenuDc;
import com.dc.dcworld.service.base.MenuDcService;
import com.dc.dcworld.utils.http.DcHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 一块儿小饼干
 * @ProjectName: dcworld
 * @Description:
 * @date: 2021/4/18 21:48
 */
@Service
public class MenuDcServiceImpl implements MenuDcService {
    @Autowired
    private MenuDcDao dao;

    @Override
    public DcHttp<List<MenuDc>> getAll() {
        List<MenuDc> menuList=dao.getAllOnlyFirstGrade();
        List<MenuDc> allMenuList=dao.getAll();
        List<MenuDc> helpList = new ArrayList<>();
        for (MenuDc dc: allMenuList) {
            if(dc.getParentId()!=null){
                helpList.add(dc);
            }
        }
        for (MenuDc dc :menuList) {
            List<MenuDc> childList=new ArrayList<>();
            for (MenuDc df : helpList) {
                if((df.getParentId()+"").equals(dc.getMenuId()+"")){
                    childList.add(df);
                }
            }
            dc.setChildList(childList);
        }
        return DcHttp.success(menuList);
    }
}
