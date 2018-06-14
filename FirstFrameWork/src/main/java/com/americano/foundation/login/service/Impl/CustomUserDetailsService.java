package com.americano.foundation.login.service.Impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.americano.foundation.login.dao.LoginDAO;
import com.americano.foundation.user.domain.UserDomain;


@Service
@Transactional(readOnly=true)
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private LoginDAO loginDAO;
	
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		System.out.println("userId : "+userId);
		System.out.println("userId : "+userId);
		System.out.println("userId : "+userId);
		System.out.println("userId : "+userId);
		
		
		UserDomain user = loginDAO.getUser(userId);
		
		boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
 
        return new User(
        		user.getUserId(), 
        		user.getUserPasswd(), 
                enabled, 
                accountNonExpired, 
                credentialsNonExpired, 
                accountNonLocked,
                getAuthorities(user.getRole().getId())
        );
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities(Integer id) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(id));
		return authList;
	}
	
	public List<String> getRoles(Integer role) {
		 
        List<String> roles = new ArrayList<String>();
 
        if (role.intValue() == 1) {
            roles.add("ROLE_SYSTEM");
            roles.add("ROLE_ADMIN");
        } else if (role.intValue() == 2) {
            roles.add("ROLE_ADMIN");
        }
        return roles;
    }
     
    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
    	List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
         
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
