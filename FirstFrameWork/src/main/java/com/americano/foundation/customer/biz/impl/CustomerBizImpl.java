package com.americano.foundation.customer.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.americano.foundation.customer.biz.CustomerBiz;
import com.americano.foundation.customer.domain.CustomerDomain;
import com.americano.foundation.customer.repository.CustomerRepository;

@Service
public class CustomerBizImpl implements CustomerBiz{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public void insertData() {
		// TODO Auto-generated method stub
		CustomerDomain customer = new CustomerDomain();
		
		customer.setName("TEST");
		customer.setAge(33);
		customer.setAddress("신댑아도오오옹");
		customer.setPhone("010-2012-7601");
		
		customerRepository.save(customer);
	}
	
}
