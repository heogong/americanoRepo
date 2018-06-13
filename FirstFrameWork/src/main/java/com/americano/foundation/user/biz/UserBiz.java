package com.americano.foundation.user.biz;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import com.americano.foundation.user.domain.UserDomain;

public interface UserBiz {
	public void insertUser(UserDomain user);
	public UserDomain findUser(String id);
	public UserDomain findUser2();
}
