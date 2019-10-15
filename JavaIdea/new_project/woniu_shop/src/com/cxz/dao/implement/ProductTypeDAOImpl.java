package com.cxz.dao.implement;

import com.cxz.bean.PageBean;
import com.cxz.bean.ProductType;
import com.cxz.dao.interFace.IProductTypeDAO;
import com.cxz.util.BaseDao;
import com.cxz.util.GenerateObjArray;
import com.cxz.util.GenerateSQL;

import java.util.List;

public class ProductTypeDAOImpl implements IProductTypeDAO {

    private BaseDao<ProductType> bd = new BaseDao<>();
    private GenerateSQL gs = new GenerateSQL(ProductType.class,"product_type");

    @Override
    public void add(ProductType prodType) {
        String sql = gs.insert();
        Object[] objects = GenerateObjArray.insert(prodType);
        bd.doSomething(sql,objects);
    }

    @Override
    public void del(Integer typeID) {
        String sql = gs.del();
        Object[] objects = GenerateObjArray.del(typeID);
        bd.doSomething(sql,objects);
    }

    @Override
    public void update(ProductType productType) {
        String sql = gs.update();
        Object[] objects = GenerateObjArray.update(productType);
        bd.doSomething(sql,objects);
    }

    @Override
    public ProductType getOne(Integer typeID) {
        String sql = gs.findOne();
        Object[] objects = GenerateObjArray.findOne(typeID);
        List<ProductType> list = bd.getSomething(sql,objects,ProductType.class);
        return list.size()==0?null:list.get(0);
    }

    @Override
    public List<ProductType> getAll() {
        String sql = gs.findAll();
        Object[] objects = GenerateObjArray.findAll();
        return bd.getSomething(sql,objects,ProductType.class);
    }

    @Override
    public List<ProductType> findByPageNum(PageBean pb) {
        List<ProductType> products = getAll();
        int totalPages =  products.size()/pb.getEachPageRows();
        pb.setTotalPages(products.size()%pb.getEachPageRows()==0?totalPages:totalPages+1);
        pb.setTotalRows(products.size());
        String sql = "SELECT * FROM product_type LIMIT ?,?";
        Object[] objects = {(pb.getNowPage()-1)*pb.getEachPageRows(),pb.getEachPageRows()};
        return bd.getSomething(sql,objects,ProductType.class);
    }
}
