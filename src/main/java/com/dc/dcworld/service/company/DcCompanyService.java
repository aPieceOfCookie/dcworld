package com.dc.dcworld.service.company;

import com.dc.dcworld.mapper.company.DcCompany;

import java.util.List;

/**
 * @author: 一块儿小饼干
 * @ProjectName: dcworld
 * @Description:
 * @date: 2021/5/6 20:38
 */
public interface DcCompanyService {
    List<DcCompany> getAll();

    void save(DcCompany company);
}
