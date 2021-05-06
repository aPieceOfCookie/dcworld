package com.dc.dcworld.mapper.utils;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: 一块儿小饼干
 * @ProjectName: dcworld
 * @Description: 省市区
 * @date: 2021/5/6 23:26
 */
@Data
@Mapper
public class ChinaArea {
    private Integer id;
    private String name;
    private Integer pId;
    private String sName;
    private Integer level;
    private String cityCode;
    private String yzCode;
    private String merName;
    private Float lng;
    private Float lat;
    private String pinYin;
}
