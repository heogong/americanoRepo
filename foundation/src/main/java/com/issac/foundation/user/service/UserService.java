package com.issac.foundation.user.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.issac.foundation.user.model.User;

public interface UserService {
	public void saveUser(User user);
	public void editUser(User user);
	public Page<User> listUser(Pageable pageable);
	public Optional<User> findUser(Long seq);
	public void deleteUser (Long Seq);
}
