package com.issac.foundation.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.issac.foundation.login.service.LoginService;
import com.issac.foundation.user.model.User;
import com.issac.foundation.user.service.UserService;

@Controller
//@RequestMapping("/member")
public class UserController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UserService UserService;
	
	private static final int DEFAULT_PAGE_NUMBER = 0;
    private static final int DEFAULT_PAGE_SIZE = 2;
	
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
			UserService.saveUser(user);
			
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");
			
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value="/getListUser")
	@ResponseBody
	public ModelAndView getListUser(@PageableDefault(
			page = DEFAULT_PAGE_NUMBER,
			size = DEFAULT_PAGE_SIZE, 
			sort = "seq", 
			direction = Direction.DESC
			) Pageable pageable) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		Page<User> user = UserService.listUser(pageable);
		
		modelAndView.addObject("user", user);
		modelAndView.setViewName("/user/listUser");
		
		return modelAndView;
	}
}
