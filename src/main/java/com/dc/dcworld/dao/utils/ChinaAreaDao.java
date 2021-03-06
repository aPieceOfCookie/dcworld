package com.dc.dcworld.dao.utils;

import com.dc.dcworld.mapper.utils.ChinaArea;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: 一块儿小饼干
 * @ProjectName: dcworld
 * @Description:
 * @date: 2021/5/6 23:29
 */
@Mapper
public interface ChinaAreaDao {
    /**
     * 获取所有省市区数据
     * @return
     */
    @Select("select * from china_area")
    public List<ChinaArea> getAll();

    /**
     * 只获取省
     * @return
     */
    @Select("select * from china_area where level = 1")
    public List<ChinaArea> getLevelOne();

    /**
     * 只获取市
     * @return
     */
    @Select("select * from china_area where level = 2")
    public List<ChinaArea> getLevelTwo();

    /**
     * 只获取区
     * @return
     */
    @Select("select * from china_area where level = 3")
    public List<ChinaArea> getLevelThree();
}
