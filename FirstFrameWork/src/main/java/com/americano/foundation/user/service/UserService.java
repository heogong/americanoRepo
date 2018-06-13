package com.americano.foundation.user.service;


import org.springframework.transaction.annotation.Transactional;

import com.americano.foundation.user.domain.UserDomain;

@Transactional(readOnly=true, noRollbackFor=Exception.class)
public interface UserService {
	public UserDomain findUser(String id);
	public UserDomain findUser2();
	public void insertUser(UserDomain user);
}
