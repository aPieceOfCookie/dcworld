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
    /**
     * 获取企业列表
     * @return
     */
    List<DcCompany> getAll();

    /**
     * 保存企业
     * @param company
     */
    void save(DcCompany company);

    /**
     * 删除企业
     * @param companyId
     */
    void remove(Long companyId);
}
