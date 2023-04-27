package com.itwillbs.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import net.coobird.thumbnailator.Thumbnails;

@Controller
public class FileUploadController {
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	
	// http://localhost:8080/fileUpload
	@RequestMapping(value = "/fileUpload", method = RequestMethod.GET)
	public void fileFormGET() throws Exception{
		logger.info("fileFormGET() 호출");
	}
	
	@RequestMapping(value = "/fileUpload",method = RequestMethod.POST)
	public String fileUploadPOST(MultipartHttpServletRequest multiRequest,
			                   HttpServletResponse response,Model model) throws Exception{
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
		List fileList = fileProcess(multiRequest);
		// 필요한 정보 전달(결과 뷰페이지)
		model.addAttribute("paramMap",paramMap);
		model.addAttribute("fileList",fileList);
		
		return "uploadResult";
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
			// D:\\upload  파일 업로드경로 생성
			// 파일 생성 => 파일업로드
			File file = new File("D:\\upload\\"+fileName);
			// 파일의 내용 추가
			// 업로드한 파일이 있을때
			if(mFile.getSize() != 0) {
				// 해당 경로에 파일이 없을경우
				if(!file.exists()) {
					// 해당하는 디렉토리 생성후 파일을 업로드
					if(file.getParentFile().mkdirs()) {
						file.createNewFile();
					}
				}
				// 임시로 생성(저장) MultipartFile을 실제 파일로 전송
				mFile.transferTo(new File("d:\\upload\\"+oFileName));
			}
			
		}
		logger.info(fileList.toString());
		
		return fileList;
	}
	
	@GetMapping("/download")
	public void fileDownloadGET(@RequestParam("fileName") String fileName,
			HttpServletResponse response) throws Exception{
		logger.info("fileDownloadGET() 호출");
		// http://localhost:8080/fileUpload 
		// => uploadResult.jsp 페이지 화면에 이미지 출력
		// 파일의 정보
		logger.info("fileName : "+fileName);
		// 다운로드할 파일의 위치
		String downFile = "D:\\upload\\"+fileName;
		// 다운로드할 파일 생성(선택 및 오픈)
		File file = new File(downFile);
		// 파일의 정보를 화면에 출력
		OutputStream out = response.getOutputStream();
		
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; fileName="+fileName);
		
		FileInputStream fis = new FileInputStream(file);
		
		byte[] buffer = new byte[1020 * 8];
		
		while(true) {
			int data = fis.read(buffer);
			if(data == -1) {
				break;
			}
			// 화면에 데이터(파일)출력
			out.write(buffer);
		}
		fis.close();
		out.close();
	} // get method
	
	// 다운로드와 거의 유사함
	@GetMapping("/thumb")
	public void thumbnailDownload(@RequestParam("fileName") String fileName
			,HttpServletResponse response) throws Exception{
		logger.info("thumbnailDownload() 호출");
		
		// 다운로드할 파일 정보(위치) 
		String downPath = "D:\\upload\\"+fileName;
		
		// 파일의 정보를 화면에 출력
		OutputStream out = response.getOutputStream();
		
		File imgFile = new File(downPath);
		
		// 다운로드할 원본파일명
		String oFileName = fileName.substring(0,fileName.lastIndexOf('.'));
		logger.info("oFileName : "+oFileName);
		
		// 썸네일 파일 생성
		File thumbFile = new File("D:\\upload\\thumbnail\\"+oFileName+".png");
		if(imgFile.exists()) {
			// 썸네일 폴더 생성
			// thumbFile.getParentFile().mkdirs();
			// 썸네일 파일 생성
			// Thumbnails.of(imgFile).size(50, 50).outputFormat("png").toFile(thumbFile);
			
			// 썸네일 파일 생성(x) 바로 화면에 썸네일만 출력
			Thumbnails.of(imgFile).size(50, 50).outputFormat("png").toOutputStream(out);
		}else {
			return;
		}
		
		byte[] buffer = new byte[1020 * 8];
		out.write(buffer);
		out.close();
	}

	
	
	
	
	
	
	
	
	
} // C
