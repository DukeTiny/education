package com.cxz.dao.implement;

import com.cxz.bean.PageBean;
import com.cxz.bean.Product;
import com.cxz.dao.interFace.IProductDAO;
import com.cxz.util.BaseDao;
import com.cxz.util.GenerateObjArray;
import com.cxz.util.GenerateSQL;

import java.util.List;

public class ProductDAOImpl implements IProductDAO {

    private BaseDao<Product> bd = new BaseDao<>();
    private GenerateSQL gs = new GenerateSQL(Product.class,"product");

    @Override
    public void add(Product product) {
        String sql = gs.insert();
        Object[] objects = GenerateObjArray.insert(product);
        bd.doSomething(sql,objects);
    }

    @Override
    public void del(Integer productID) {
        String sql = gs.del();
        Object[] objects = GenerateObjArray.del(productID);
        bd.doSomething(sql,objects);
    }

    @Override
    public void update(Product product) {
        String sql = gs.update();
        Object[] objects = GenerateObjArray.update(product);
        bd.doSomething(sql,objects);
    }

    @Override
    public Product getOne(Integer productID) {
        String sql = gs.findOne();
        Object[] objects = GenerateObjArray.findOne(productID);
        List<Product> list = bd.getSomething(sql,objects,Product.class);
        return list.size()==0?null:list.get(0);
    }

    @Override
    public List<Product> findAll() {
        String sql = gs.findAll();
        Object[] objects = GenerateObjArray.findAll();
        return bd.getSomething(sql,objects,Product.class);
    }

    @Override
    public List<Product> findByPageBean(PageBean pb) {
        List<Product> products = findAll();
        int totalPages =  products.size()/pb.getEachPageRows();
        pb.setTotalPages(products.size()%pb.getEachPageRows()==0?totalPages:totalPages+1);
        pb.setTotalRows(products.size());
        String sql = "SELECT * FROM product LIMIT ?,?";
        Object[] objects = {(pb.getNowPage()-1)*pb.getEachPageRows(),pb.getEachPageRows()};
        return bd.getSomething(sql,objects,Product.class);
    }

    @Override
    public List<Product> findByStatus(String info) {
        String sql = "SELECT * FROM product WHERE productName like %?% AND onSale=1";
        Object[] objects = {info};
        return bd.getSomething(sql,objects,Product.class);
    }
}
