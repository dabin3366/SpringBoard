package com.itwillbs.domain;

// 페이징처리 (하단부 작업)
public class PageMaker {
	
	private int totalCount;			 // 총 글 개수
	private int startPage;			 // 페이지 블럭 시작번호
	private int endPage;			 // 페이지 블럭 끝번호
	private boolean prev;			 // 이전
	private boolean next;			 // 다음
	
	private int displayPageNum = 10; // 페이지 블럭의 개수
	
	private int page;
	private int pageSize;
}
