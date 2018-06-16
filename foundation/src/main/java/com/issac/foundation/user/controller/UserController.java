package com.issac.foundation.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.issac.foundation.login.service.LoginService;
import com.issac.foundation.user.model.User;
import com.issac.foundation.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UserService UserService;
	
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = loginService.findUserByUserId(user.getUserId());
		if (userExists != null) {
			System.out.println("============== userExists ============== ");
			bindingResult
					.rejectValue("ID", "error.user",
							"There is already a user registered with the ID provided");
		}
		if (bindingResult.hasErrors()) {
			System.out.println("============== bindingResult.hasErrors() ============== ");
			System.out.println("toString : "+bindingResult.toString());
			System.out.println("errorCount : "+bindingResult.getErrorCount());
			System.out.println("objectName : "+bindingResult.getObjectName());
			
			modelAndView.setViewName("registration");
		} else {
			System.out.println("============== pass! ============== ");
			UserService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");
			
		}
		return modelAndView;
	}
}