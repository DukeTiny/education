package com.cxz.dao.interFace;

import com.cxz.bean.PageBean;
import com.cxz.bean.Stock;

import java.util.List;

public interface IStockDAO {
    void add(Stock stock);
    void del(Integer purchaseID);
    void update(Stock stock);
    Stock getOne(Integer purchaseID);
    List<Stock> getAll();
    List<Stock> findByPageNum(PageBean pb);
}
