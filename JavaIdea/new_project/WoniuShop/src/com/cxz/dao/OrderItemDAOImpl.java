package com.cxz.dao;

import com.cxz.po.OrderItem;
import com.cxz.util.BaseDao;
import com.cxz.util.GenerateObjArray;
import com.cxz.util.GenerateSQL;

import java.util.List;

public class OrderItemDAOImpl implements IOrderItemDAO {

    private GenerateSQL gs = new GenerateSQL(OrderItem.class,"orderItem");
    private BaseDao<OrderItem> bd = new BaseDao<>();

    public void add(OrderItem orderItem) {
        String sql = gs.insert();
        Object[] objs = GenerateObjArray.insert(orderItem);
        bd.doSomething(sql,objs);
    }
    public void update(OrderItem orderItem,String pk_name) {
        String sql = gs.update(pk_name);
        Object[] objs = GenerateObjArray.update(orderItem,pk_name);
        bd.doSomething(sql,objs);
    }
    public void del(Integer id) {
        String sql = gs.del();
        Object[] objs = GenerateObjArray.del(id);
        bd.doSomething(sql,objs);
    }
    public OrderItem getOne(Integer id) {
        String sql = gs.findOne();
        Object[] objs = GenerateObjArray.findOne(id);
        List<OrderItem> orderItems = bd.getSomething(sql,objs,OrderItem.class);
        return orderItems.size() == 0?null:orderItems.get(0);
    }
    public List<OrderItem> getAll() {
        String sql = gs.findAll();
        Object[] objs = GenerateObjArray.findAll();
        return bd.getSomething(sql,objs,OrderItem.class);
    }
}