package com.americano.foundation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.americano.foundation.biz.CustomerBiz;
import com.americano.foundation.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerBiz customerBiz;
	
	@Override
	public void insertData() {
		// TODO Auto-generated method stub
		customerBiz.insertData();
	}

}
