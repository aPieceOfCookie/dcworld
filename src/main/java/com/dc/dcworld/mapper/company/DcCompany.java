package com.dc.dcworld.mapper.company;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

/**
 * @author: 一块儿小饼干
 * @ProjectName: dcworld
 * @Description:
 * @date: 2021/5/6 20:28
 */
@Mapper
@Data
public class DcCompany {
    private Long companyId;
    private String companyName;
    private String address;
    private Long createId;
    private String creater;
    private Date createTime;
}
