package com.americano.foundation.login.service;

import com.americano.foundation.user.domain.UserDomain;

public interface UserService {
	public UserDomain getUser(String userId);
}
