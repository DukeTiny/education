package com.cxz.service;

import com.cxz.bean.PageBean;
import com.cxz.bean.Product;

import java.util.List;

public interface IProductService {
    void add(Product product);
    void update(Product product);
    void del(Integer productId);
    Product getOne(Integer productID);
    List<Product> findAll();
    List<Product> findByPageNum(PageBean pb);
    List<Product> findByStatus(String info);
}
