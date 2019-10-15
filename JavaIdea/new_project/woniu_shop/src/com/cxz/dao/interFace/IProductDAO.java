package com.cxz.dao.interFace;

import com.cxz.bean.PageBean;
import com.cxz.bean.Product;

import java.util.List;

public interface IProductDAO {
    void add(Product product);
    void del(Integer productID);
    void update(Product product);
    Product getOne(Integer productID);
    List<Product> findAll();
    List<Product> findByPageBean(PageBean pb);
    List<Product> findByStatus(String info);
}
