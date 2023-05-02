package com.itwillbs.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service(value = "mailService")
public class MailService {
	private static final Logger logger = LoggerFactory.getLogger(MailService.class);
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Async
	public void sendMail() {
		logger.info(mailSender+"");
		
		// 메일 전송 정보저장 객체 
		try {
			MimeMessage msg = mailSender.createMimeMessage();
			MimeMessageHelper msgHelper = new MimeMessageHelper(msg,true,"UTF-8");
			
			msgHelper.setFrom("test@itwill.com","아이티윌다빈");
			msgHelper.setSubject("메일 제목@@@");
			msgHelper.setTo("ekqls3366@naver.com");
			msgHelper.setText("안녕!@@@@@@@@@@!@!@!!@");
			
			mailSender.send(msg);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	@Async
	public void sendMail(String sendMSG) {
		logger.info(mailSender+"");
		
		// 메일 전송 정보저장 객체 
		try {
			MimeMessage msg = mailSender.createMimeMessage();
			MimeMessageHelper msgHelper = new MimeMessageHelper(msg,true,"UTF-8");
			
			msgHelper.setFrom("test@itwill.com","아이티윌다빈");
			msgHelper.setSubject("메일 제목@@@");
			msgHelper.setTo("ekqls3366@naver.com");
			// msgHelper.setText(sendMSG);
			msgHelper.setText(sendMSG,true);
			
			mailSender.send(msg);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
