package com.nexwon.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexwon.admin.dao.LadderDAO;

@Service
public class LadderService {
	
	@Autowired
	private LadderDAO ladderDao;
	
	
	public String getDateTime() {
		String strDateTime = "";
		
		strDateTime = ladderDao.getCurrentDateTime();
		
		return strDateTime;
	}
	

}
