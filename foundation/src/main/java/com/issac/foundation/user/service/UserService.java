package com.issac.foundation.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.issac.foundation.user.model.User;

public interface UserService {
	public Optional<User> findUser(Long seq);
	public User findUserByUserId(String userId);
	public User saveUser(User user);
	public User editUser(User user);
	public Page<User> listUser(Pageable pageable, String search);
	public void deleteUser (Long Seq);
    List<User> companyUser(Long compSeq);
}
