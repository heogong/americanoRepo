package com.issac.foundation.company.service.impl;

import java.util.Date;
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

	@Override
	public Company createCompany(Company company) {
		Company newComp = new Company();

		newComp.setCompNm(company.getCompNm());
		newComp.setCompOwner(company.getCompOwner());
		newComp.setCompTel(company.getCompTel());
		newComp.setCompFl(1);
		newComp.setInstDt(new Date());

		//companyRepository.save(newComp);

		return companyRepository.save(newComp);
	}
}
