package com.americano.foundation.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.americano.foundation.customer.domain.CustomerDomain;

/**
 * 
 * @author heogong
 * CrudRepository :  CRUD / JpaRepository : CrudRepository
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerDomain, Integer> {
	 
}

