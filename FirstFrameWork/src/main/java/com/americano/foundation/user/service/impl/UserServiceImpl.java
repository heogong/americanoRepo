package com.americano.foundation.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.americano.foundation.user.biz.UserBiz;
import com.americano.foundation.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserBiz userBiz;
	
	@Override
	public void insertData() {
		// TODO Auto-generated method stub
		userBiz.insertData();
	}

}
