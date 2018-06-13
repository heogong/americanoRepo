package com.americano.foundation.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.americano.foundation.user.domain.UserDomain;

/**
 * 
 * @author heogong
 * CrudRepository : 기본 CRUD / JpaRepository : CrudRepository 포함(페이징 지원)
 */
@Repository
public interface UserRepository extends CrudRepository<UserDomain, Integer> {

	UserDomain findByUserId(String userId);
}

