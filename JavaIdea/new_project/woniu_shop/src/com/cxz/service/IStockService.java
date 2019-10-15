package com.cxz.service;

import com.cxz.bean.PageBean;
import com.cxz.bean.Stock;

import java.util.List;

public interface IStockService {
    void add(Stock stock);
    void update(Stock stock);
    void del(Integer purchaseID);
    Stock getOne(Integer purchaseID);
    List<Stock> findAll();
    List<Stock> findByPageNum(PageBean pb);
    List<Stock> findByStatus(String info);
}
