package com.cxz.dao.implement;

import com.cxz.bean.PageBean;
import com.cxz.bean.Stock;
import com.cxz.dao.interFace.IStockDAO;
import com.cxz.util.BaseDao;
import com.cxz.util.GenerateObjArray;
import com.cxz.util.GenerateSQL;

import java.util.List;

public class StockDAOImpl implements IStockDAO {

    private BaseDao<Stock> bd = new BaseDao<>();
    private GenerateSQL gs = new GenerateSQL(Stock.class,"stock");

    @Override
    public void add(Stock stock) {
        String sql = gs.insert();
        Object[] objects = GenerateObjArray.insert(stock);
        bd.doSomething(sql,objects);
    }

    @Override
    public void del(Integer purchaseID) {
        String sql = gs.del();
        Object[] objects = GenerateObjArray.del(purchaseID);
        bd.doSomething(sql,objects);
    }

    @Override
    public void update(Stock stock) {
        String sql = gs.update();
        Object[] objects = GenerateObjArray.update(stock);
        bd.doSomething(sql,objects);
    }

    @Override
    public Stock getOne(Integer purchaseID) {
        String sql = gs.findOne();
        Object[] objects = GenerateObjArray.findOne(purchaseID);
        List<Stock> list = bd.getSomething(sql,objects,Stock.class);
        return list.size()==0?null:list.get(0);
    }

    @Override
    public List<Stock> getAll() {
        String sql = gs.findAll();
        Object[] objects = GenerateObjArray.findAll();
        return bd.getSomething(sql,objects,Stock.class);
    }

    @Override
    public List<Stock> findByPageNum(PageBean pb) {
        List<Stock> products = getAll();
        int totalPages =  products.size()/pb.getEachPageRows();
        pb.setTotalPages(products.size()%pb.getEachPageRows()==0?totalPages:totalPages+1);
        pb.setTotalRows(products.size());
        String sql = "SELECT * FROM stock LIMIT ?,?";
        Object[] objects = {(pb.getNowPage()-1)*pb.getEachPageRows(),pb.getEachPageRows()};
        return bd.getSomething(sql,objects,Stock.class);
    }

    public static void main(String[] args) {
        StockDAOImpl sd = new StockDAOImpl();

    }

}
