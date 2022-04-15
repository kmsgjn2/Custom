package com.custom.paging;

public class BoardPagingVo {

	// 페이지당 게시물 수
	private int pageListCnt;
	// 페이지당 버튼 수
	private int paginationCnt;
	// 현재 페이지 번호
	private int currentPage;
	// 이전 버튼의 페이지 번호
	private int prevPage;
	// 다음 버튼의 페이지 번호
	private int nextPage;
	// 전체 페이지 수
	private int totalPage;
	// 현재 페이지버튼 시작 번호
	private int paginationStart;
	// 현재 페이지버튼 끝 번호
	private int paginationEnd;
	// DB Start
	private int pageStart;
	// DB End
	private int pageEnd;
	// 검색어
	private String searchWord;

	public BoardPagingVo(int currentPage, int boardCount, String searchWord) {
		this.pageListCnt = 10;
		this.paginationCnt = 5;
		this.currentPage = currentPage;
		this.searchWord = searchWord;

		totalPage = boardCount / pageListCnt;

		if (boardCount % pageListCnt > 0) {
			totalPage++;
		}

		paginationStart = ((currentPage - 1) / paginationCnt * paginationCnt + 1);
		paginationEnd = paginationStart + paginationCnt - 1;

		if (paginationEnd > totalPage) {
			paginationEnd = totalPage;
		}

		prevPage = paginationStart - 1;
		nextPage = paginationEnd + 1;

		if (nextPage > totalPage) {
			nextPage = totalPage;
		}

		// 기존 ORACLE 로직
//		pageStart = ((currentPage - 1) * pageListCnt + 1);
//		pageEnd = (pageStart + pageListCnt - 1); 
		
		// My SQL 로직
		pageStart = ((currentPage - 1) * pageListCnt);
		pageEnd = pageListCnt; 
	}

	public int getPageListCnt() {
		return pageListCnt;
	}

	public void setPageListCnt(int pageListCnt) {
		this.pageListCnt = pageListCnt;
	}

	public int getPaginationCnt() {
		return paginationCnt;
	}

	public void setPaginationCnt(int paginationCnt) {
		this.paginationCnt = paginationCnt;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPaginationStart() {
		return paginationStart;
	}

	public void setPaginationStart(int paginationStart) {
		this.paginationStart = paginationStart;
	}

	public int getPaginationEnd() {
		return paginationEnd;
	}

	public void setPaginationEnd(int paginationEnd) {
		this.paginationEnd = paginationEnd;
	}

	public int getPageStart() {
		return pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public int getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

}