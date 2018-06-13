package com.americano.foundation.login.service.Impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.americano.foundation.login.dao.LoginDAO;
import com.americano.foundation.login.service.LoginService;
import com.americano.foundation.user.domain.RoleDomain;
import com.americano.foundation.user.domain.UserDomain;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
     
    @Autowired
    private LoginDAO loginDAO;
    
    public UserDomain getUser(String userId) {
        return loginDAO.getUser(userId);
    }
    
    public RoleDomain getRole(int id) {
        return loginDAO.getRole(id);
    }
 
}