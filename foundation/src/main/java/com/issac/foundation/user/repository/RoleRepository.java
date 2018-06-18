package com.issac.foundation.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.issac.foundation.user.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer>{
	Role findByRole(String role);

}