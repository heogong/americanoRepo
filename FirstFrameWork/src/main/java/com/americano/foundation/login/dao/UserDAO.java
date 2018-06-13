package com.americano.foundation.login.dao;

import com.americano.foundation.user.domain.UserDomain;

public interface UserDAO {
	public UserDomain getUser(String login);
}
