package com.woniu.bean;

public class PageBean {
	private Integer pageNum; //当前页面
	private Integer pageRow; //每页行数
	private Integer countRow; //总行数
	private Integer countPage; //总页数
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageRow() {
		return pageRow;
	}
	public void setPageRow(Integer pageRow) {
		this.pageRow = pageRow;
	}
	public Integer getCountRow() {
		return countRow;
	}
	public void setCountRow(Integer countRow) {
		this.countRow = countRow;
	}
	public Integer getCountPage() {
		return countPage;
	}
	public void setCountPage(Integer countPage) {
		this.countPage = countPage;
	}
	
}
