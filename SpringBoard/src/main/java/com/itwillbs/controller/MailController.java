package com.itwillbs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.itwillbs.service.MailService;

// @EnableAsync : 비동기 방식 메서드, 호출 가능하도록 설정

@Controller
@EnableAsync
public class MailController {
	private static final Logger logger = LoggerFactory.getLogger(MailController.class);
	
	@Autowired
	private MailService service;
	
	// http://localhost:8080/sendMail
	@GetMapping("/sendMail")
	public void sendMailGET(HttpServletResponse resp) {
		logger.info("sendMailGET() 호출");
		
		// service.sendMail();
		
		String sendMSG = "";
		sendMSG += "<html><body>";
		sendMSG += "<h1>안녕하세요 아이티윌 입니다.</h1>";
		sendMSG += "<img src='\"C:\\Users\\ITWILL\\Pictures\\Screenshots\\Screenshot_1.png\"'>";
		sendMSG += "</body></html>";
		
		service.sendMail(sendMSG);
		
		try {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			
			out.print("메일 전송 완료! ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
