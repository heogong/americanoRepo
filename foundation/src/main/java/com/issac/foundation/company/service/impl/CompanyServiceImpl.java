package com.issac.foundation.company.service.impl;

import java.util.Date;
import java.util.List;

import com.issac.foundation.company.model.CompLevel;
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
	public void createCompany(Company company) {
		Company newComp = new Company();

		newComp.setCompNm(company.getCompNm());
		newComp.setCompOwner(company.getCompOwner());
		newComp.setCompTel(company.getCompTel());
		newComp.setCompAddr(company.getCompAddr());

		newComp.setCompLv(company.getCompLv().intValue());

		newComp.setCompFl(true);
		newComp.setInstDt(new Date());

		companyRepository.save(newComp);
	}

	@Override
	public List<Company> getListCompany() {

		return companyRepository.findByCompLvOrderByCompSeqDesc(CompLevel.CORP);
}

	@Override
	public Company viewCompany(Company company) {
		return companyRepository.findByCompSeq(company.getCompSeq());
	}

	@Override
	public void editCompany(Company company) {

		Company target = companyRepository.findByCompSeq(company.getCompSeq());

		target.setCompNm(company.getCompNm());
		target.setCompOwner(company.getCompOwner());
		target.setCompTel(company.getCompTel());
		target.setCompAddr(company.getCompAddr());
		target.setModDt(new Date());

		companyRepository.save(target);
	}
}
