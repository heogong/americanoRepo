package com.americano.foundation.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.americano.foundation.user.domain.UserDomain;
import com.americano.foundation.user.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/insertUser")
	public void insertData() {
		
	}
	
	@RequestMapping("/findUser")
	public void findUser() {
		
		UserDomain user = userService.findUser("SYSTEM");
		
		System.out.println("id : "+user.getUserId());
		System.out.println("age : "+user.getUserAge());
		System.out.println("name : "+user.getUserNm());
		
	}
	
	@RequestMapping("/findUser2")
	public void findUser2() {
		
		UserDomain user = userService.findUser2();
		
		System.out.println("userId : "+user.getUserId());
		
	}
}
