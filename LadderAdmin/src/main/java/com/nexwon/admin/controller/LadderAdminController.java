package com.nexwon.admin.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nexwon.admin.service.LadderService;
import com.nexwon.admin.util.Util;
import com.nexwon.admin.vo.LadderVO;

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
	
	@RequestMapping("/admin/index")
	public String gameIndexList(Model model, @RequestParam(defaultValue = "", required = false) String searchDate) {
		
		String today = Util.getTodayDate();
		
		if ( !"".equals(searchDate) ) {
			today = searchDate.trim();
		}
		
		ArrayList<LadderVO> ladderList = service.getLadderList(today, today);		
		model.addAttribute("ladderList", ladderList);
		model.addAttribute("searchDate", today);
		
		
		for (int i=0; i<ladderList.size(); i++) {
			LadderVO  ladder = ladderList.get(i);
			
			logger.debug("gidx = {}", ladder.getIdx());
			logger.debug("g_idx = {}", ladder.getG_idx());
			logger.debug("g_info = {}", ladder.getG_info());
			logger.debug("g_time = {}", ladder.getG_time());
			
		}
		
		return "admin/index";
		
	}
	
	
	
	
}
