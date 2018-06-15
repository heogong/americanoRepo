package com.americano.foundation.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.americano.foundation.user.domain.RoleDomain;

/**
 * 
 * @author heogong
 * CrudRepository : �⺻ CRUD / JpaRepository : CrudRepository ����(����¡ ����)
 */
@Repository
public interface RoleRepository extends JpaRepository<RoleDomain, Integer> {
	 
}

