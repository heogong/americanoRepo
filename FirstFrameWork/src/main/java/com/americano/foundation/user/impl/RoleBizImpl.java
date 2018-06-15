package com.americano.foundation.user.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.americano.foundation.user.biz.RoleBiz;
import com.americano.foundation.user.domain.RoleDomain;
import com.americano.foundation.user.repository.RoleRepository;

@Service
public class RoleBizImpl implements RoleBiz {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public RoleDomain findByRole(String role) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
