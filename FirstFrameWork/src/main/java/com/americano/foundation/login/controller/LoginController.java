package com.americano.foundation.login.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.americano.foundation.HomeController;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView loginForm(Locale locale) {
		
		logger.info("=================================== LOGIN =================================== ", locale);
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/error-login", method=RequestMethod.GET)
	public ModelAndView invalidLogin(Locale locale) {
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("error", true);
		
		logger.info("=================================== error-login =================================== ", locale);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/success-login", method=RequestMethod.GET)
	public ModelAndView successLogin(Locale locale) {
		logger.info("=================================== success-login =================================== ", locale);
		
		return new ModelAndView("success-login");
	}

}
