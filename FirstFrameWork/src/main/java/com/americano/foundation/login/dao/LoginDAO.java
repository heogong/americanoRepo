package com.americano.foundation.login.dao;

import com.americano.foundation.user.domain.RoleDomain;
import com.americano.foundation.user.domain.UserDomain;

public interface LoginDAO {
	public UserDomain getUser(String login);
	public RoleDomain getRole(int id);
}