package com.cxz.bean;

public class PageBean {
    private Integer eachPageRows;
    private Integer totalPages;
    private Integer nowPage;
    private Integer totalRows;

    public PageBean() {}

    public PageBean(Integer eachPageRows, Integer totalPages, Integer nowPage, Integer totalRows) {
        this.eachPageRows = eachPageRows;
        this.totalPages = totalPages;
        this.nowPage = nowPage;
        this.totalRows = totalRows;
    }

    public Integer getEachPageRows() {
        return eachPageRows;
    }

    public void setEachPageRows(Integer eachPageRows) {
        this.eachPageRows = eachPageRows;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getNowPage() {
        return nowPage;
    }

    public void setNowPage(Integer nowPage) {
        this.nowPage = nowPage;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

}
