package com.nexwon.admin.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexwon.admin.dao.LadderDAO;
import com.nexwon.admin.vo.LadderVO;
import com.nexwon.admin.vo.ParamVO;

@Service
public class LadderService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private LadderDAO ladderDao;

	public String getDateTime() {
		String strDateTime = "";

		strDateTime = ladderDao.getCurrentDateTime();

		return strDateTime;
	}

	public ArrayList<LadderVO> getLadderList(String startDate, String endDate) {

		ParamVO paramVO = new ParamVO();

		paramVO.setStartDate(startDate);
		paramVO.setEndDate(endDate);

		ArrayList<LadderVO> ladderList = ladderDao.getLadderList(paramVO);
		return ladderList;
	}

	public int getLadderListCount(String startDate, String endDate) {

		ParamVO paramVO = new ParamVO();

		paramVO.setStartDate(startDate);
		paramVO.setEndDate(endDate);

		int ladderListCount = ladderDao.getLadderListCount(paramVO);
		return ladderListCount;
	}

}
