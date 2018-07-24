package com.issac.foundation.company.service;

import java.util.List;

import com.issac.foundation.company.model.Company;

public interface CompanyService {
    List<Company> getListCompany();
    void createCompany(Company company);
}
