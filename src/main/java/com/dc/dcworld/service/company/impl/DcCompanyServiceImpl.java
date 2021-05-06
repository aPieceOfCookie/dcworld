package com.dc.dcworld.service.company.impl;

import com.dc.dcworld.dao.company.DcCompanyDao;
import com.dc.dcworld.mapper.company.DcCompany;
import com.dc.dcworld.service.company.DcCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 一块儿小饼干
 * @ProjectName: dcworld
 * @Description:
 * @date: 2021/5/6 20:39
 */
@Service
public class DcCompanyServiceImpl implements DcCompanyService {
    @Autowired
    private DcCompanyDao dao;
    @Override
    public List<DcCompany> getAll() {
        return dao.getAll();
    }

    @Override
    public void save(DcCompany company) {
        dao.save(company);
    }
}
