package com.americano.foundation.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.americano.foundation.customer.domain.CustomerDomain;

@Repository("jpaRepository")
public interface CustomerRepository extends JpaRepository<CustomerDomain, Integer> {
	 
}

