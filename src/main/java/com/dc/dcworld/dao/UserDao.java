package com.dc.dcworld.dao;

import com.dc.dcworld.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Dell
 */
@Mapper
public interface UserDao {
    /**
     * 保存
     * @param user
     */
    @Insert("insert into user (fullname,username,passowrd) values(#{fullname},#{username}#{password})")
    void save(User user);

    /**
     * 查询所有用户
     * @return
     */
    @Select("select user_id,username,password from user")
    List<User> getUserList();

    /**
     *
     * @param id
     * @return
     */
    @Select("select * form user where user_id=#{id}")
    User queryByUserId(int id);
}
