
package com.itwillbs.controller;

import java.lang.annotation.Inherited;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private BoardService service;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	// http://localhost:8080/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	// 시간정보 조회
	// http://localhost:8080/time
	@RequestMapping(value = "/time",method = RequestMethod.GET)
	public String TimeGET(Model model) {
		logger.info("timeGET() 실행!");
		String time = service.itwillbs_getTime();
		
		model.addAttribute("time", time);
		model.addAttribute(time);
		return "time";
	}
	
}
