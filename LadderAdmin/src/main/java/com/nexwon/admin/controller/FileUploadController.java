package com.nexwon.admin.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nexwon.admin.service.ExcelService;

import jxl.read.biff.BiffException;

@Controller
public class FileUploadController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ExcelService excelService;

	private final String UPLOADPATH = "/tmp";

	/**
	 * File Upload Page
	 * 
	 * @return
	 */
	@RequestMapping(value = "/fileupload", method = RequestMethod.GET)
	public String fileUpload() {
		return "fileupload";
	}

	/**
	 * File Save
	 * 
	 * @param uploadfile
	 * @return
	 */
	@RequestMapping(value = "/fileupload", method = RequestMethod.POST)
	public ResponseEntity<?> fileUpload(@RequestParam("uploadFile") MultipartFile uploadfile) {

		try {
			String fileNm = uploadfile.getOriginalFilename();
			String filePath = UPLOADPATH + File.separator + fileNm;

			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(uploadfile.getBytes());
			stream.close();

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		try {
			excelService.excelInsert(new File(UPLOADPATH + File.separator + uploadfile.getOriginalFilename()));
		} catch (BiffException | IOException e) {
			logger.error("FileDbInsert = {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		

		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * 
	 * @return HTTP Response
	 */
	@RequestMapping(value = "/excelParse", method = RequestMethod.POST)
	public ResponseEntity<?> excelParse() {
		
		
		return new ResponseEntity<>(HttpStatus.OK);

	}

}
