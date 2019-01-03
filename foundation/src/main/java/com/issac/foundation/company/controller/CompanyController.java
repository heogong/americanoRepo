package com.issac.foundation.company.controller;

import com.issac.foundation.company.model.Company;
import com.issac.foundation.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/comp")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    // 회사 등록
    @CrossOrigin(origins ="*")
    @RequestMapping(value="/createCompany")
    @ResponseBody
    public void createCompany(@ModelAttribute Company company, BindingResult bindingResult) {

        // 클라이언트 회사 레벨 전송 코드 추가 해야 함 (법인 : 1, 학원 : 2)

        companyService.createCompany(company);
    }

    // 회사 리스트
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/getListCompany")
    @ResponseBody
    public List<Company> getListCompany() {

        return companyService.getListCompany();
    }

    // 회사 조회
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/viewCompany")
    @ResponseBody
    public Company viewCompany(@ModelAttribute Company company) {

        return companyService.viewCompany(company);
    }

    // 회사 수정
    @CrossOrigin(origins ="*")
    @RequestMapping(value="/editCompany")
    @ResponseBody
    public void editCompany(@ModelAttribute Company company) {

        companyService.editCompany(company);
    }
}
