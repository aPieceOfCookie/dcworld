package com.dc.dcworld.dao.base;

import com.dc.dcworld.mapper.base.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: 一块儿小饼干
 * @ProjectName: dcworld
 * @Description:
 * @date: 2021/4/18 19:51
 */
@Mapper
public interface UserDao {
    /**
     * 保存
     * @param user 新用户
     */
    @Insert("insert into user (fullname,username,password) values(#{fullname},#{username},#{password})")
    void save(User user);

    /**
     * 查询所有用户
     * @return 用户列表
     */
    @Select("select user_id,username,password from user")
    List<User> getUserList();

    /**
     *
     * @param id 主键
     * @return user
     */
    @Select("select * form user where user_id=#{id}")
    User queryByUserId(int id);

    @Select("select * from user where username=#{username}")
    User findByUserName(String username);
}
