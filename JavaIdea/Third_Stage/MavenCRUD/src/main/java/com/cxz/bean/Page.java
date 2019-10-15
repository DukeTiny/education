package com.cxz.bean;

import java.util.List;

public class Page<T> {
    private int p;              // 当前页
    private int rowCount;       // 总行数
    private int size;           // 每页显示行数
    private int maxPage;        // 总页数
    private int prev;           // 前一页
    private int next;           // 下一页
    private int startLine;      // 起始行
    private int startPage;      // 跳转起始页
    private int endPage;        // 跳转结束页
    private List<T> list;       // 分页数据

    public Page() {}

    public Page(int p, int rowCount, int size ) {
        this.p = p;
        this.rowCount = rowCount;
        this.size = size;

        maxPage = (int)(Math.ceil(this.rowCount*1.0/this.size));
        if( p>maxPage ) p = maxPage;
        if( p<1 ) p = 1;
        prev = p-1;
        next = p+1;
        startLine = (p-1)*size;
        if( maxPage<10 ){
            startPage = 1;
            endPage = maxPage;
        }
        else{
            startPage = p-5;
            endPage = p+4;
            if( startPage<1 ){
                startPage = 1;
                endPage = 10;
            }
        }
    }



    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

    public int getPrev() {
        return prev;
    }

    public void setPrev(int prev) {
        this.prev = prev;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public int getStartLine() {
        return startLine;
    }

    public void setStartLine(int startLine) {
        this.startLine = startLine;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
