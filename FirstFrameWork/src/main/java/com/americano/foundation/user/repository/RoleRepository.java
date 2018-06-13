package com.americano.foundation.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.americano.foundation.user.domain.RoleDomain;

/**
 * 
 * @author heogong
 * CrudRepository : 기본 CRUD / JpaRepository : CrudRepository 포함(페이징 지원)
 */
@Repository
public interface RoleRepository extends JpaRepository<RoleDomain, Integer> {
	 
}

