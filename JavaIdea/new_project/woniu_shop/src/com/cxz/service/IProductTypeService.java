package com.cxz.service;

import com.cxz.bean.PageBean;
import com.cxz.bean.ProductType;

import java.util.List;

public interface IProductTypeService {
    void add(ProductType pt);
    void update(ProductType pt);
    void del(Integer productId);
    ProductType getOne(Integer productID);
    List<ProductType> findAll();
    List<ProductType> findByPageNum(PageBean pb);
    List<ProductType> findByStatus(String info);
}
