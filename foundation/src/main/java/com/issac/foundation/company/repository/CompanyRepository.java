package com.issac.foundation.company.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.issac.foundation.company.model.Company;

public interface CompanyRepository extends CrudRepository<Company, Integer> {
	List<Company> findByCompSeq(Long compSeq);
	List<Company> findByOrderByCompSeqDesc();
}
