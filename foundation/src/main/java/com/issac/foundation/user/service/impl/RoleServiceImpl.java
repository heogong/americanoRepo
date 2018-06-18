package com.issac.foundation.user.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.issac.foundation.user.model.Role;
import com.issac.foundation.user.repository.RoleRepository;
import com.issac.foundation.user.service.RoleService;

@Transactional
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
    private RoleRepository roleRepository;
	
	@Override
	public Iterable<Role> listRole() {
		return roleRepository.findAll();
	}

}
