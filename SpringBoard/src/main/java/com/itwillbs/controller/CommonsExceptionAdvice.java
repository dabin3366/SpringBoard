package com.itwillbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// @ControllerAdvice : 컨트롤러에서 발생하는 모든 예외를 처리하는 클래스

@ControllerAdvice
public class CommonsExceptionAdvice {
	// 예외처리를 수행하는 공통 객체 (AOP)
	private static final Logger logger = LoggerFactory.getLogger(CommonsExceptionAdvice.class);
	
	// @ExceptionHandler(Exception.class) 
	// => 메서드가 예외처리

//	@ExceptionHandler(NullPointerException.class)
//	public String commons() {
//		
//		return "";
//	}

	@ExceptionHandler(Exception.class)
	public String commons(Exception e,Model model) {
		logger.info("CommonsExceptionAdvice_commons() ");
		
		logger.info(e.toString());
		model.addAttribute("err",e.toString());
		return "commonsException";
	}
	
//	@ExceptionHandler(Exception.class)
//	public ModelAndView commons(Exception e) {
//		logger.info("CommonsExceptionAdvice_commons() ");
//		
//		logger.info(e.toString());
//		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/commonsException");
//		mav.addObject(e.toString());
//		
//		return mav;
//	}
	
}
