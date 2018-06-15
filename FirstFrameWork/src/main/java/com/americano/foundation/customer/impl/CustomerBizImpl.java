package com.americano.foundation.customer.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.americano.foundation.customer.biz.CustomerBiz;
import com.americano.foundation.customer.domain.CustomerDomain;
import com.americano.foundation.customer.repository.CustomerRepository;

@Service
@Transactional
public class CustomerBizImpl implements CustomerBiz {
	
	@Qualifier
	private CustomerRepository customerRepository;
	
	@Override
	public void insertData() {
		// TODO Auto-generated method stub
		CustomerDomain customer = new CustomerDomain();
		
		customer.setName("TEST");
		customer.setAge(33);
		customer.setAddress("11111111222222222");
		customer.setPhone("010-2012-7601");
		
		customerRepository.save(customer);
	}
	
}
