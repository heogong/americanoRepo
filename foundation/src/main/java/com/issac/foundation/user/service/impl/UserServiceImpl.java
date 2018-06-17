package com.issac.foundation.user.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.issac.foundation.user.model.Role;
import com.issac.foundation.user.model.User;
import com.issac.foundation.user.repository.RoleRepository;
import com.issac.foundation.user.repository.UserRepository;
import com.issac.foundation.user.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private RoleRepository roleRepository;
	
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


	@Override
	public void saveUser(User user) {
		user.setUserPasswd(bCryptPasswordEncoder.encode(user.getUserPasswd()));
        user.setUserFl(1);
        user.setUserSt(1000);
        user.setInstDt(new Date());
        
        user.setUserLv(2);
        user.setUserAge(0);
        user.setUserTel("010-1111-1111");
        
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        
		userRepository.save(user);
	}


	@Override
	public Page<User> listUser(Pageable pageable) {
		
		return userRepository.findByUserFl(1, pageable);
	}
}