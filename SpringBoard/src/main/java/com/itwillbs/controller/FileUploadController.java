package com.itwillbs.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileUploadController {
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	
	// http://localhost:8080/fileUpload
	@RequestMapping(value = "/fileUpload", method = RequestMethod.GET)
	public void fileFormGET() throws Exception{
		logger.info("fileFormGET() 호출");
	}
	
	@RequestMapping(value = "/fileUpload",method = RequestMethod.POST)
	public void fileUploadPOST(MultipartHttpServletRequest multiRequest,
			                   HttpServletResponse response) throws Exception{
		logger.info("fileUploadPOST() 호출");
		// 한글처리
		multiRequest.setCharacterEncoding("utf-8");
		Map paramMap = new HashMap();
		// 전달정보 저장
		// 전달되는 모든 파라메터의 정보를 저장
		Enumeration enu =  multiRequest.getParameterNames(); 
		// logger.info(enu+"");
		while(enu.hasMoreElements()) {
			String name = (String)enu.nextElement();
			String value =  multiRequest.getParameter(name);
			// logger.info(name+","+value);
			// 파라메터 정보를 저장
			paramMap.put(name, value);
		}
		logger.info(paramMap.toString());
		// 파일업로드 처리
		fileProcess(multiRequest);
		// 필요한 정보 전달(결과 뷰페이지)
		
	}
	// 파일업로드 처리 (1. 파일명저장, 2. 파일업로드)
	private List<String> fileProcess(MultipartHttpServletRequest multiRequest) throws Exception{
		
		// 파일이름 저장하는 리스트
		List<String> fileList = new ArrayList<String>();
		// input-file 파라메터정보를 가져오기
		Iterator<String> fileNames = multiRequest.getFileNames();
		while(fileNames.hasNext()) {
			// input file 이름 정보를 저장
			String fileName =  fileNames.next();
			// logger.info(fileName);
			// 이름에 해당하는 실제 파일의 데이터를 저장
			MultipartFile mFile = multiRequest.getFile(fileName); // file1, file2,...
			// 파일의 이름
			String oFileName = mFile.getOriginalFilename();
			fileList.add(oFileName);
		}
		logger.info(fileList.toString());
		return null;
	}
} // C
