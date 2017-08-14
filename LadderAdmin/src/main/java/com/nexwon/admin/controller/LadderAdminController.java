package com.nexwon.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexwon.admin.service.LadderService;

@Controller
public class LadderAdminController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LadderService service;
	
	@RequestMapping("/")
	public String index(Model model) {
		
		model.addAttribute("name", "SpringBlog from Millky Database 현재 시간은 : " + service.getDateTime());
		return "index";
		
	}
	
	
	

}
