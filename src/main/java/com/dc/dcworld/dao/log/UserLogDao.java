package com.dc.dcworld.dao.log;

import com.dc.dcworld.domain.log.UserLog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: 一块儿小饼干
 * @ProjectName: dcworld
 * @Description:
 * @date: 2021/4/20 22:02
 */
@Mapper
public interface UserLogDao {

    /**
     * 保存登录日志
     * @param log
     */
    @Insert("insert into user_log(address,ip,login_time) values (#{address},#{ip},#{loginTime})")
    public void save(UserLog log);

    /**
     * 获取所有登录信息
     * @return
     */
    @Select("select * from user_log")
    List<UserLog> getAll();

    /**
     * 删除日志信息
     * @param logId
     */
    @Delete("delete from user_log where log_id=#{logId}")
    void remove(Long logId);
}
