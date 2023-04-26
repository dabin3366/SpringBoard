package com.itwillbs.domain;

// 페이징처리 (하단부 작업)
public class PageDTO {
	
	private int totalCount;			 // 총 글 개수
	private int startPage;			 // 페이지 블럭 시작번호
	private int endPage;			 // 페이지 블럭 끝번호
	private boolean prev;			 // 이전
	private boolean next;			 // 다음
	
	private int displayPageNum = 10; // 페이지 블럭의 개수
	
//	private int page;
//	private int pageSize;
	private Criteria cri;

	// get
	public int getTotalCount() {
		return totalCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public Criteria getCri() {
		return cri;
	}
	
	// set
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		System.out.println(" 게시판 글의 총 개수 ");
		System.out.println(" 페이징처리 (하단 페이지 블럭) 계산 ");
		calcData();
	}
	
	private void calcData() {
		System.out.println(" calcData() : 페이징처리 (하단 페이지 블럭) 계산 ");
		// endPage
		endPage = (int)Math.ceil(cri.getPage()/(double)displayPageNum) * displayPageNum;
		// tmpEndPage : 실제 사용되는 마지막 페이지 번호
		int tmpEndPage = (int)Math.ceil(totalCount / (double)cri.getPageSize());
		
		if(endPage > tmpEndPage) {
			endPage = tmpEndPage;
		}
		// startPage
		startPage = (endPage - displayPageNum) + 1;
		// prev
		prev = startPage != 1;
		// next
		next = endPage * cri.getPageSize() >= totalCount? false:true;
		System.out.println(" 페이징처리 (하단 페이지 블럭) 계산 끝 ");
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	@Override
	public String toString() {
		return "PageDTO [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
	}

	
	
	
}
