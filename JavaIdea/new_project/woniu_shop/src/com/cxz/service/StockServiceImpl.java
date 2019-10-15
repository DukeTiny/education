package com.cxz.service;

import com.cxz.bean.PageBean;
import com.cxz.bean.Stock;
import com.cxz.dao.DAOFactory;

import java.util.List;

public class StockServiceImpl implements IStockService {


    @Override
    public void add(Stock stock) {
        DAOFactory.getStockDAO().add(stock);
    }

    @Override
    public void update(Stock stock) {
        DAOFactory.getStockDAO().update(stock);
    }

    @Override
    public void del(Integer purchaseID) {
        DAOFactory.getStockDAO().del(purchaseID);
    }

    @Override
    public Stock getOne(Integer purchaseID) {
        return DAOFactory.getStockDAO().getOne(purchaseID);
    }

    @Override
    public List<Stock> findAll() {
        return DAOFactory.getStockDAO().getAll();
    }

    @Override
    public List<Stock> findByPageNum(PageBean pb) {
        return DAOFactory.getStockDAO().findByPageNum(pb);
    }

    @Override
    public List<Stock> findByStatus(String info) {
        return null;
    }


}
