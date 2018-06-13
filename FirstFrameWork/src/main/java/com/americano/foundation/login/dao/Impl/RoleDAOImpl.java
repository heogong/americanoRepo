package com.americano.foundation.login.dao.Impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.americano.foundation.login.dao.RoleDAO;
import com.americano.foundation.user.domain.RoleDomain;

@Repository
public class RoleDAOImpl implements RoleDAO {
	
	@Autowired
    private SessionFactory sessionFactory;
     
    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

	public RoleDomain getRole(int rolesPk) {
		RoleDomain role = (RoleDomain) getCurrentSession().load(RoleDomain.class, rolesPk);
        return role;
	}
}