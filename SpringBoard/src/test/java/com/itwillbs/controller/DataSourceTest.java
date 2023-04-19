package com.itwillbs.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// junit 4.12사용 (미적용시 Maven 업데이트)

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class DataSourceTest {
	// 디비연결 테스트(DataSource)
	
	// 디비연결정보를 저장하는 객체 - DataSource
	// => 디비연결 객체가 필요하다.(의존하고있다) => 의존관계주입
	@Inject
	private DataSource ds;
	
	private static final Logger logger = LoggerFactory.getLogger(DataSourceTest.class);
	
	// @Test : Junit 사용해서 실행 가능한 형태의 메서드
	@Test
	public void testConnection() {
		logger.info("testConnection() 실행 - 디비연결 정보 출력 ");
		
		logger.info("주입 객체 정보 : "+ ds);
		try {
			Connection con = ds.getConnection();
			
			logger.info("디비 연결정보 : "+con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
