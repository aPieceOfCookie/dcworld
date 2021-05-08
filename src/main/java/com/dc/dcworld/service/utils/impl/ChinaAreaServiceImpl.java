package com.dc.dcworld.service.utils.impl;

import com.dc.dcworld.dao.utils.ChinaAreaDao;
import com.dc.dcworld.mapper.utils.ChinaArea;
import com.dc.dcworld.service.utils.ChinaAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 一块儿小饼干
 * @ProjectName: dcworld
 * @Description:
 * @date: 2021/5/8 22:26
 */
@Service
public class ChinaAreaServiceImpl implements ChinaAreaService {

    @Autowired
    private ChinaAreaDao dao;

    @Override
    public List<ChinaArea> getAll() {
        return dao.getAll();
    }

    @Override
    public List<ChinaArea> getLevelOne() {
        return dao.getLevelOne();
    }

    @Override
    public List<ChinaArea> getLevelTwo() {
        return dao.getLevelTwo();
    }

    @Override
    public List<ChinaArea> getLevelThree() {
        return dao.getLevelThree();
    }
}
