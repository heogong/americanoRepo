package com.americano.foundation.login.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.americano.foundation.login.dao.UserDAO;
import com.americano.foundation.user.domain.UserDomain;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public UserDomain getUser(String userId) {
		List<UserDomain> userList = new ArrayList<UserDomain>();
        Query query = openSession().createQuery("FROM TB_USER U WHERE U.USER_ID = :userId");
        query.setParameter("userId", userId);
        userList = query.list();
        
        if (userList.size() > 0)
            return userList.get(0);
        else
            return null;    
	}
}
