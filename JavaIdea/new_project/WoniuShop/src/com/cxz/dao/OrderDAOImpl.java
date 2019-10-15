package com.cxz.dao;

import com.cxz.po.Order;
import com.cxz.util.BaseDao;
import com.cxz.util.GenerateObjArray;
import com.cxz.util.GenerateSQL;

import java.util.List;

public class OrderDAOImpl implements IOrderDAO {

    private GenerateSQL gs = new GenerateSQL(Order.class,"order");

    private BaseDao<Order> bd = new BaseDao<>();

    public void add(Order order) {
        String sql = gs.insert();
        Object[] objs = GenerateObjArray.insert(order);
        bd.doSomething(sql,objs);
    }
    public void update(Order order,String pk_name) {
        String sql = gs.update(pk_name);
        Object[] objs = GenerateObjArray.update(order,pk_name);
        bd.doSomething(sql,objs);
    }
    public void del(Integer id) {
        String sql = gs.del();
        Object[] objs = GenerateObjArray.del(id);
        bd.doSomething(sql,objs);
    }
    public Order getOne(Integer id) {
        String sql = gs.findOne();
        Object[] objs = GenerateObjArray.findOne(id);
        List<Order> orders = bd.getSomething(sql,objs,Order.class);
        return orders.size() == 0?null:orders.get(0);
    }
    public List<Order> getAll() {
        String sql = gs.findAll();
        Object[] objs = GenerateObjArray.findAll();
        return bd.getSomething(sql,objs,Order.class);
    }
}