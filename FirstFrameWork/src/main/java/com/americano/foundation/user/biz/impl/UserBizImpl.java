package com.americano.foundation.user.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.americano.foundation.user.biz.UserBiz;
import com.americano.foundation.user.domain.UserDomain;
import com.americano.foundation.user.repository.UserRepository;

@Service
public class UserBizImpl implements UserBiz {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void insertData() {
		// TODO Auto-generated method stub
		UserDomain user = new UserDomain();
		
		user.setName("ев╫╨ем");
		user.setAge(33);
		user.setTel("010-000-0000");
		
		userRepository.save(user);
	}
	
}
