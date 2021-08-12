package com.dc.dcworld.controller.company;

import com.dc.dcworld.mapper.company.DcCompany;
import com.dc.dcworld.service.company.DcCompanyService;
import com.dc.dcworld.utils.http.DcHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author: 一块儿小饼干
 * @ProjectName: dcworld
 * @Description:
 * @date: 2021/5/6 20:35
 */
@RestController
@RequestMapping("/company")
public class DcCompanyController {
    @Autowired
    private DcCompanyService dcCompanyService;

    @GetMapping("/getAll")
    public DcHttp<List<DcCompany>> getAll(){
        List<DcCompany> companyList = dcCompanyService.getAll();
        return DcHttp.success(companyList);
    }

    @PostMapping("/saveCompany")
    public DcHttp<Void> saveCompany(@RequestBody DcCompany company){
        company.setCreater("张三");
        company.setCreateTime(new Date());
        dcCompanyService.save(company);
        return DcHttp.success();
    }

    @DeleteMapping("/removeCompany/{companyId}")
    public DcHttp<Void> removeCompany(@PathVariable("companyId") Long companyId){
        dcCompanyService.remove(companyId);
        return DcHttp.success();
    }
}
