package com.americano.foundation.login.service;

import com.americano.foundation.user.domain.RoleDomain;
import com.americano.foundation.user.domain.UserDomain;

public interface LoginService {
	public UserDomain getUser(String userId);
	public RoleDomain getRole(int id);
}
