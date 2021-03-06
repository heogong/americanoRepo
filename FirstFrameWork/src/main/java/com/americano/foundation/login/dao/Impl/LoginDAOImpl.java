package com.americano.foundation.login.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.americano.foundation.login.dao.LoginDAO;
import com.americano.foundation.user.domain.RoleDomain;
import com.americano.foundation.user.domain.UserDomain;

@Repository
public class LoginDAOImpl implements LoginDAO {
	
/*	@Autowired
	private SessionFactory sessionFactory;*/
	
	@Qualifier
	EntityManager entityManager;
	
/*	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}*/
	
	private Session getSession() {
		Session session = entityManager.unwrap(Session.class);
		
		return session;
	}
	
	public UserDomain getUser(String userId) {
		List<UserDomain> userList = new ArrayList<UserDomain>();
        Query query = getSession().createQuery("FROM TB_USER U WHERE U.USER_ID = :userId");
        query.setParameter("userId", userId);
        userList = query.list();
        
        if (userList.size() > 0)
            return userList.get(0);
        else
            return null;    
	}

	public RoleDomain getRole(int id) {
		RoleDomain role = (RoleDomain) getSession().load(RoleDomain.class, id);
        return role;
	}
}
