package com.americano.foundation.login.service.Impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.americano.foundation.login.dao.UserDAO;
import com.americano.foundation.login.service.UserService;
import com.americano.foundation.user.domain.UserDomain;

@Service("LOGIN")
@Transactional
public class UserServiceImpl implements UserService {
     
    @Autowired
    private UserDAO userDAO;
 
    public UserDomain getUser(String userId) {
        return userDAO.getUser(userId);
    }
 
}