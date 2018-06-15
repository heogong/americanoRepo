package com.issac.foundation.login.service;

import com.issac.foundation.user.model.User;

public interface LoginService {
	public User findUserByEmail(String email);
}
