package com.cxz.service;

import com.cxz.bean.PageBean;
import com.cxz.bean.Product;
import com.cxz.bean.ProductType;
import com.cxz.dao.DAOFactory;

import java.util.List;

public class ProductTypeServiceImpl implements IProductTypeService{
    @Override
    public void add(ProductType pt) {
        DAOFactory.getProductTypeDAO().add(pt);
    }

    @Override
    public void update(ProductType pt) {
        DAOFactory.getProductTypeDAO().update(pt);
    }

    @Override
    public void del(Integer productId) {
        DAOFactory.getProductTypeDAO().del(productId);
    }

    @Override
    public ProductType getOne(Integer productID) {
        return DAOFactory.getProductTypeDAO().getOne(productID);
    }

    @Override
    public List<ProductType> findAll() {
        return DAOFactory.getProductTypeDAO().getAll();
    }

    @Override
    public List<ProductType> findByPageNum(PageBean pb) {
        return DAOFactory.getProductTypeDAO().findByPageNum(pb);
    }

    @Override
    public List<ProductType> findByStatus(String info) {
        return null;
    }
}
