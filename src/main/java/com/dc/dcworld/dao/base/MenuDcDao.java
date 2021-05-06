package com.dc.dcworld.dao.base;

import com.dc.dcworld.mapper.base.MenuDc;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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

    /**
     * 只查询等级为1的菜单
     * @return
     */
    @Select("select * from menu_dc where grade = 1")
    List<MenuDc> getAllOnlyFirstGrade();

    /**
     * 新增菜单
     * @param menu
     */
    @Insert("insert into menu_dc(menu_name,grade,menu_flag,parent_id,sn,create,create_id,create_date,icon_img,route) values" +
            " (#{menuName},#{grade},#{menuFlag},#{parentId},#{sn},#{create},#{createId},#{createDate},#{iconImg},#{route})")
    void saveMenuDc(MenuDc menu);

    /**
     * 获得菜单象棋
     * @param menuId
     * @return
     */
    @Select("select * from menu_dc where menu_id = #{menuId}")
    MenuDc getMenuDcInfo(Long menuId);


}
