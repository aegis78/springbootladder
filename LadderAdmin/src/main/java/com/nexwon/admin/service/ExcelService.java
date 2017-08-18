package com.nexwon.admin.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexwon.admin.dao.LadderDAO;
import com.nexwon.admin.util.Util;
import com.nexwon.admin.vo.LadderVO;
import com.nexwon.admin.vo.ParamVO;

import jxl.read.biff.BiffException;

@Service
public class ExcelService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LadderDAO ladderDao;
	
	public int excelInsert(File file) throws BiffException, IOException {
		
		int resultCount = 0;
		List<LadderVO> excelFileRead = Util.excelFileRead(file);
		LadderVO ladderVo = null;
		
		logger.debug("ExcelCount = {}", excelFileRead.size());
		for ( int i=0; i<excelFileRead.size(); i++ ) {
			ladderVo = new LadderVO();
			ladderVo = excelFileRead.get(i);
			logger.debug("Excel g_idx = {}", ladderVo.getG_idx());
			logger.debug("Excel g_info = {}", ladderVo.getG_info());
			logger.debug("Excel g_time = {}", ladderVo.getG_time());
			logger.debug("Excel date = {}", ladderVo.getDate());
			
			resultCount += ladderDao.insertLadder(ladderVo);	
			
			
		}
		
		return resultCount;
		
				
	}
	
	public int deleteData(String date) {
		int resultCount = 0;
		
		ParamVO paramVo = new ParamVO();
		
		paramVo.setStartDate(date);
		resultCount = ladderDao.deleteData(paramVo);
		
		return resultCount;
	}
	
	public int updateData(int idx, String gInfo) {
		int resultCount = 0;
		
		LadderVO ladderVo = new LadderVO();
		
		ladderVo.setIdx(idx);
		ladderVo.setG_info(gInfo);
		
		resultCount = ladderDao.updateData(ladderVo);
		
		return resultCount;
	}

}
