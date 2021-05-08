package com.dc.dcworld.controller.utils;

import com.dc.dcworld.mapper.utils.ChinaArea;
import com.dc.dcworld.service.utils.ChinaAreaService;
import com.dc.dcworld.utils.http.DcHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: 一块儿小饼干
 * @ProjectName: dcworld
 * @Description:
 * @date: 2021/5/8 22:28
 */
@RestController
@RequestMapping("/area")
public class ChinaAreaController {
    @Autowired
    private ChinaAreaService chinaAreaService;

    public DcHttp<List<ChinaArea>> getAll(){
        List<ChinaArea> areaList=chinaAreaService.getAll();
        return DcHttp.success(areaList);
    }
}
