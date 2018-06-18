package com.issac.foundation.user.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
import com.issac.foundation.user.model.Role;
import com.issac.foundation.user.model.User;
import com.issac.foundation.user.service.RoleService;
import com.issac.foundation.user.service.UserService;

@Controller
//@RequestMapping("/member")
public class UserController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
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
			userService.saveUser(user);
			
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");
			
		}
		
		return modelAndView;
	}
	
	// 사용자 리스트 
	@RequestMapping(value="/getListUser")
	@ResponseBody
	public ModelAndView getListUser(@PageableDefault(
			page = DEFAULT_PAGE_NUMBER,
			size = DEFAULT_PAGE_SIZE, 
			sort = "seq", 
			direction = Direction.DESC
			) Pageable pageable) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		Page<User> user = userService.listUser(pageable);
		
		modelAndView.addObject("user", user);
		modelAndView.setViewName("/user/listUser");
		
		return modelAndView;
	}
	
	// 사용자 조회
	@RequestMapping(value="/findUser")
	@ResponseBody
	public ModelAndView findUser(@RequestParam("seq") @NotNull Long seq) {
		ModelAndView modelAndView = new ModelAndView();
		
		Optional<User> user = userService.findUser(seq);
		Iterable<Role> role = roleService.listRole();
		
		modelAndView.addObject("user", user.get());
		modelAndView.addObject("role", role);
		
		modelAndView.setViewName("/user/editUser");
		
		return modelAndView;
	}
	
	// 사용자 수정
	@RequestMapping(value="/editUser")
	@ResponseBody
	public ModelAndView editUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		
		if (bindingResult.hasErrors()) {
			System.out.println("============== bindingResult.hasErrors() ============== ");
			System.out.println("toString : "+bindingResult.toString());
			
			modelAndView.setViewName("registration");
		} else {
			userService.editUser(user);
		}
		
		modelAndView.setViewName("/user/editUser");
		return modelAndView;
	}
	
	// 사용자 삭제
	@RequestMapping(value="/deleteUser")
	@ResponseBody
	public ModelAndView deleteUser(@RequestParam("seq") @NotNull Long seq) {
		ModelAndView modelAndView = new ModelAndView();
		
		userService.deleteUser(seq);
		
		modelAndView.setViewName("/user/editUser");
		
		return modelAndView;
	}
}
