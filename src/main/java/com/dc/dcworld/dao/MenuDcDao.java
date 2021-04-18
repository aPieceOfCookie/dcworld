package com.dc.dcworld.dao;

import com.dc.dcworld.domain.MenuDc;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: 一块儿小饼干
 * @ProjectName: dcworld
 * @Description:
 * @date: 2021/4/18 21:46
 */
@Mapper
public interface MenuDcDao {

    /**
     * 菜单列表
     * @return
     */
    @Select("select * from menu_dc")
    public List<MenuDc> getAll();
}
