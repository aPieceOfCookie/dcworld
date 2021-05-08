package com.dc.dcworld.dao.company;

import com.dc.dcworld.mapper.company.DcCompany;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: 一块儿小饼干
 * @ProjectName: dcworld
 * @Description:
 * @date: 2021/5/6 20:37
 */
@Mapper
public interface DcCompanyDao {

    /**
     * 查询所有公司
     * @return
     */
    @Select("select *  from dc_company")
    public List<DcCompany> getAll();

    /**
     * 保存一个公司信息
     * @param company
     * @return
     */
    @Insert("insert into dc_company(company_name , address , creater , create_time ) values (#{companyName},#{address},#{creater},#{createTime})")
    public void save(DcCompany company);

    /**
     * 获取一个公司信息
     * @param companyId
     * @return
     */
    @Select("select * from dc_company a where a.company_id = #{companyId}")
    public DcCompany get(Long companyId);

    @Delete("delete from dc_company a where a.company_id = #{companyId}")
    public void  remove(Long companyId);
}
