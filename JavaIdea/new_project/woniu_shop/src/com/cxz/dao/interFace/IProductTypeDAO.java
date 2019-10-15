package com.cxz.dao.interFace;

import com.cxz.bean.PageBean;
import com.cxz.bean.ProductType;

import java.util.List;

public interface IProductTypeDAO {
    void add(ProductType prodType);
    void del(Integer typeID);
    void update(ProductType prodType);
    ProductType getOne(Integer typeID);
    List<ProductType> getAll();
    List<ProductType> findByPageNum(PageBean pb);
}
