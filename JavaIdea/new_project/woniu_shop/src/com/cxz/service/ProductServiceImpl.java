package com.cxz.service;

import com.cxz.bean.PageBean;
import com.cxz.bean.Product;
import com.cxz.dao.DAOFactory;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    public void add(Product product){
        DAOFactory.getProductDAO().add(product);
    }

    @Override
    public void update(Product product) {
        DAOFactory.getProductDAO().update(product);
    }

    @Override
    public void del(Integer productId) {
        DAOFactory.getProductDAO().del(productId);
    }

    @Override
    public Product getOne(Integer productID) {
        return DAOFactory.getProductDAO().getOne(productID);
    }
    @Override
    public List<Product> findAll(){
        return DAOFactory.getProductDAO().findAll();
    }

    @Override
    public List<Product> findByPageNum(PageBean pb) {
        return DAOFactory.getProductDAO().findByPageBean(pb);
    }

    @Override
    public List<Product> findByStatus(String info) {
        return DAOFactory.getProductDAO().findByStatus(info);
    }
}
