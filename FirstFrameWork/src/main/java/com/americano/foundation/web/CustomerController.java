package com.americano.foundation.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.americano.foundation.biz.CustomerBiz;
import com.americano.foundation.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/insert")
	public void insertData() {
		customerService.insertData();
	}
}
