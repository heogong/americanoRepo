package com.issac.foundation.company.service;

import java.util.List;

import com.issac.foundation.company.model.Company;

public interface CompanyService {
    List<Company> getListCompany();

    void createCompany(Company company);

    Company viewCompany(Company company);

    void editCompany(Company company);
}
