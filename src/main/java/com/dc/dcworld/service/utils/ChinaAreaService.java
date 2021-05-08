package com.dc.dcworld.service.utils;

import com.dc.dcworld.mapper.utils.ChinaArea;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: 一块儿小饼干
 * @ProjectName: dcworld
 * @Description:
 * @date: 2021/5/8 22:26
 */
public interface ChinaAreaService {
    /**
     * 获取所有省市区数据
     * @return
     */
    public List<ChinaArea> getAll();

    /**
     * 只获取省
     * @return
     */
    public List<ChinaArea> getLevelOne();

    /**
     * 只获取市
     * @return
     */
    public List<ChinaArea> getLevelTwo();

    /**
     * 只获取区
     * @return
     */
    public List<ChinaArea> getLevelThree();
}
