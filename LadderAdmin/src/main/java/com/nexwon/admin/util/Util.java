package com.nexwon.admin.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nexwon.admin.dao.LadderDAO;
import com.nexwon.admin.vo.LadderVO;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Util {
	static Logger logger = LoggerFactory.getLogger(Util.class);

	public static String getTodayDate() {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		Date currentTime = new Date();
		String today = formatter.format(currentTime);

		logger.debug("Today = {}", today);

		return today;

	}

	public static List<LadderVO> excelFileRead(File file) throws BiffException, IOException {
		List<LadderVO> rowList = new ArrayList<LadderVO>();
		LadderVO ladderVo = null;

		Workbook book = Workbook.getWorkbook(file);

		Sheet sheet = book.getSheet(0);

		int rowCount = sheet.getRows();

		for (int row = 0; row < rowCount; row++) {

			ladderVo = new LadderVO();

			Cell c1 = sheet.getCell(0, row); //회차
			Cell c2 = sheet.getCell(1, row); //날짜 
			Cell c3 = sheet.getCell(2, row); //시간 
			Cell c4 = sheet.getCell(3, row); //분
			Cell c5 = sheet.getCell(4, row); //시작점 (1, 2)
			Cell c6 = sheet.getCell(5, row); //사다리 개수 (3, 4)
			Cell c7 = sheet.getCell(6, row); //시작점 결과(RED, BLUE)

			String g_idx = c1.getContents();
			String g_time = c2.getContents() + " " + c3.getContents() + ":" + c4.getContents() + ":00";
			String g_info = c5.getContents() + "," + c6.getContents() + "," + c7.getContents();
			String date = c2.getContents();
			
			ladderVo.setG_idx(Integer.parseInt(g_idx));
			ladderVo.setG_time(g_time);
			ladderVo.setG_info(g_info);
			ladderVo.setDate(date);
			
			rowList.add(ladderVo);
			
		}		
		book.close();
		
		return rowList;
	}

}
