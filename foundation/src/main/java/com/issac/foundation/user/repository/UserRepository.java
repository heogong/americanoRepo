package com.issac.foundation.user.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.issac.foundation.user.model.User;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserId(String userId);
	Page<User> findByUserFlAndUserIdLike(int userFl, Pageable pageable, String search);
}
