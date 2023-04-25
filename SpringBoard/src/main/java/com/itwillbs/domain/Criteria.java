package com.itwillbs.domain;

// 페이징 처리 정보 저장 객체
public class Criteria {

	private int page;		// 페이지 정보
	private int pageSize;	// 한번에 조회하는 글 개수
	
	public Criteria() { // 페이징처리 기본값 설정 1페이지,10개씩
		this.page = 1;
		this.pageSize = 10;
	}
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", pageSize=" + pageSize + "]";
	}
	
	
	public int getPage() {
		return page;
	}
	public int getPageSize() {
		return pageSize;
	}
	// pageStart => mapper에서만 사용되는 값 #{pageStart}
	// 페이징 시작번호(인덱스) => (page-1) * pageSize
	public int getPageStart() {
		return (this.page-1) * pageSize;
	}
	
	
	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
			return;
		}
		
		this.page = page;
	}
	public void setPageSize(int pageSize) {
		if(pageSize <= 0 || pageSize > 100) {
			 this.pageSize = 10;
			 return;
		}
		this.pageSize = pageSize;
	}
	
	
	
}
