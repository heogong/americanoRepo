package com.issac.foundation.company.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.issac.foundation.company.model.Company;
import com.issac.foundation.user.model.User;

public interface CompanyService {
    List<Company> getListCompany();
}
