package com.americano.foundation.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.americano.foundation.user.biz.UserBiz;
import com.americano.foundation.user.domain.UserDomain;
import com.americano.foundation.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserBiz userBiz;
	
	@Override
	public UserDomain findUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertUser(UserDomain user) {
		// TODO Auto-generated method stub
		userBiz.insertUser(user);
	}

	@Override
	public UserDomain findUser2() {
		// TODO Auto-generated method stub
		return userBiz.findUser2();
	}


}
