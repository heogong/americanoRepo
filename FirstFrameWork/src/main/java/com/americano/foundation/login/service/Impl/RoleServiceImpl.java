package com.americano.foundation.login.service.Impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.americano.foundation.login.dao.RoleDAO;
import com.americano.foundation.login.service.RoleService;
import com.americano.foundation.user.domain.RoleDomain;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
     
	@Autowired
    private RoleDAO roleDAO;
 
    public RoleDomain getRole(int id) {
        return roleDAO.getRole(id);
    }
 
}