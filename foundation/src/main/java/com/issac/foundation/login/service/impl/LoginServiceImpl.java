package com.issac.foundation.login.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.issac.foundation.login.service.LoginService;
import com.issac.foundation.user.model.User;
import com.issac.foundation.user.repository.UserRepository;

@Transactional
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public User findUserByUserId(String userId) {
		return userRepository.findByUserId(userId);
	}
}
