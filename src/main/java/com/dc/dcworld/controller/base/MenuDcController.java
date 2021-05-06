package com.dc.dcworld.controller.base;

import com.dc.dcworld.mapper.base.MenuDc;
import com.dc.dcworld.service.base.MenuDcService;
import com.dc.dcworld.utils.http.DcHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: 一块儿小饼干
 * @ProjectName: dcworld
 * @Description:
 * @date: 2021/4/18 21:48
 */
@RestController
@RequestMapping(value = "/menu")
public class MenuDcController {
    @Autowired
    private MenuDcService menuDcService;

    @GetMapping("/getMenuList")
    public DcHttp<List<MenuDc>> getMenuList(){
        return menuDcService.getAll();
    }
}
