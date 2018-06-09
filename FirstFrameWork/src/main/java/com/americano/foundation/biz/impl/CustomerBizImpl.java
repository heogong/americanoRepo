package com.americano.foundation.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.americano.foundation.biz.CustomerBiz;
import com.americano.foundation.domain.CustomerDomain;
import com.americano.foundation.repository.CustomerRepository;

@Service
public class CustomerBizImpl implements CustomerBiz{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public void insertData() {
		// TODO Auto-generated method stub
		CustomerDomain customer = new CustomerDomain();
		
		customer.setName("TEST ���̹�����Ʈ");
		customer.setAge(33);
		customer.setAddress("�Ŵ�浿");
		customer.setPhone("010-2012-7601");
		
		customerRepository.save(customer);
	}
	
}
