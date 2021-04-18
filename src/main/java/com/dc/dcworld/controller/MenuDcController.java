package com.dc.dcworld.controller;

import com.dc.dcworld.domain.MenuDc;
import com.dc.dcworld.service.MenuDcService;
import com.dc.dcworld.utils.http.DcHttp;
import com.dc.dcworld.utils.http.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        List<MenuDc> menuList = menuDcService.getAll();
        return DcHttp.success(menuList);
    }
}
