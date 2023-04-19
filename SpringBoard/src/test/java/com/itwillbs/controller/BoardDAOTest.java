package com.itwillbs.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class BoardDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	// BoardDAO 객체 주입
	@Autowired
	private BoardDAO bdao;
	
	// @Test
	public void testDAO() {
		logger.info("디비연결 : "+bdao);
	}
	
	// 디비시간정보 조회
	@Test
	public void test_디비시간조회() {
		// 디비 연결
		logger.info("(┬┬﹏┬┬)"+bdao.getDBTime());
		// 디비 정보 조회, 출력
	}
	
	
}
