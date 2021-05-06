package com.dc.dcworld.dao.utils;

import com.dc.dcworld.mapper.utils.ChinaArea;

import java.util.List;

/**
 * @author: 一块儿小饼干
 * @ProjectName: dcworld
 * @Description:
 * @date: 2021/5/6 23:29
 */
public interface ChinaAreaDao {
    public List<ChinaArea> getAll();
    public List<ChinaArea> getLevelOne();
    public List<ChinaArea> getLevelTwo();
    public List<ChinaArea> getLevelThree();
}
