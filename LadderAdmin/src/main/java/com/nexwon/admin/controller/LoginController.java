package com.nexwon.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@RequestMapping("/login")
	public String login(Model model) {
		
		return "login/login";
		
	}

}
