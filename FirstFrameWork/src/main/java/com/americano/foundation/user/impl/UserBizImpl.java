package com.americano.foundation.user.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.americano.foundation.user.biz.UserBiz;
import com.americano.foundation.user.domain.UserDomain;
import com.americano.foundation.user.repository.UserRepository;

@Service
public class UserBizImpl implements UserBiz {
	
	@Qualifier
	private UserRepository userRepository;
	
	//@Autowired
	//private BCryptPasswordEncoder bCryptPasswordEncoder;

	
	@Override
	public void insertUser(UserDomain user) {
		// TODO Auto-generated method stub
		
		//user.setUserPasswd(bCryptPasswordEncoder.encode(user.getUserPasswd()));
		user.setUserFl(1);
		user.setUserSt(1000);
		user.setInstDt(new Date());
		
		userRepository.save(user);
		
	}

	@Override
	public UserDomain findUser(String id) {
		// TODO Auto-generated method stub
		
		
		return userRepository.findByUserId(id);
	}

	@Override
	@Transactional
	public UserDomain findUser2() {
		// TODO Auto-generated method stub
		return userRepository.findOne(1);
	}
	
}
