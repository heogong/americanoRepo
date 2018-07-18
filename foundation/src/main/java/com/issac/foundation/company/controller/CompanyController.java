package com.issac.foundation.company.controller;

import com.issac.foundation.company.model.Company;
import com.issac.foundation.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/comp")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    // 회사 리스트
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/getListCompany")
    @ResponseBody
    public List<Company> getListCompany() {

        ModelAndView modelAndView = new ModelAndView();

        List<Company> comp = companyService.getListCompany();

        return comp;
    }
}
