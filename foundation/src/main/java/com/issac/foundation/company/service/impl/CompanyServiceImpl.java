package com.issac.foundation.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.issac.foundation.company.model.Company;
import com.issac.foundation.company.repository.CompanyRepository;
import com.issac.foundation.company.service.CompanyService;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
    private CompanyRepository companyRepository;

	@Override
	public List<Company> getListCompany() {

		return companyRepository.findByOrderByCompSeqDesc();
	}
}
