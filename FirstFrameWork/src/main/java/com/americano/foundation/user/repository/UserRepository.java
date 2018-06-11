package com.americano.foundation.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.americano.foundation.user.domain.UserDomain;

@Repository
public interface UserRepository extends JpaRepository<UserDomain, Integer> {
	 
}

