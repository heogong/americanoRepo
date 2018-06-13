package com.americano.foundation.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.americano.foundation.user.domain.UserDomain;

/**
 * 
 * @author heogong
 * CrudRepository : �⺻ CRUD / JpaRepository : CrudRepository ����(����¡ ����)
 */
@Repository
public interface UserRepository extends CrudRepository<UserDomain, Integer> {

	UserDomain findByUserId(String userId);
}

