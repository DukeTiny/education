package com.woniu.model;

public class PageBean {
	private int offset;
	
	private int page;
	private int rows;
	
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
		this.pageNow = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
		this.limit = rows;
	}
	private int limit = 10;
	private int pageNow = 1;
	private int count;
	private int pageCount;
	public int getOffset() {
		return (pageNow-1)*limit;
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
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageCount() {
		return (count+limit-1)/limit;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
}
