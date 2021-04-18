package com.dc.dcworld.service.impl;

import com.dc.dcworld.dao.MenuDcDao;
import com.dc.dcworld.domain.MenuDc;
import com.dc.dcworld.service.MenuDcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<MenuDc> getAll() {
        return dao.getAll();
    }
}
