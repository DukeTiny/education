package com.cxz.model;

public class Page {
	
	private int offset;
	private int limit = 10;
	private int nowPage = 1;
	private int rowCount;
	private int pageCount;
	
	public int getOffset() {
		return (nowPage-1)*limit;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getPageCount() {
		return (int)(Math.ceil(rowCount*1.0/limit));
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public String toString() {
		return "Page [offset=" + offset + ", limit=" + limit + ", nowPage=" + nowPage + ", rowCount=" + rowCount
				+ ", pageCount=" + pageCount + "]";
	}
	
}
