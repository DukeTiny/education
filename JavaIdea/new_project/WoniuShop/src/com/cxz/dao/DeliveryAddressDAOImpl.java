package com.cxz.dao;

import com.cxz.po.DeliveryAddress;
import com.cxz.util.BaseDao;
import com.cxz.util.GenerateObjArray;
import com.cxz.util.GenerateSQL;

import java.util.List;

public class DeliveryAddressDAOImpl implements IDeliveryAddressDAO {

    private GenerateSQL gs = new GenerateSQL(DeliveryAddress.class,"deliveryAddress");
    private BaseDao<DeliveryAddress> bd = new BaseDao<>();

    public void add(DeliveryAddress deliveryAddress) {
        String sql = gs.insert();
        Object[] objs = GenerateObjArray.insert(deliveryAddress);
        bd.doSomething(sql,objs);
    }
    public void update(DeliveryAddress deliveryAddress,String pk_name) {
        String sql = gs.update(pk_name);
        Object[] objs = GenerateObjArray.update(deliveryAddress,"id");
        bd.doSomething(sql,objs);
    }
    public void del(Integer id) {
        String sql = gs.del();
        Object[] objs = GenerateObjArray.del(id);
        bd.doSomething(sql,objs);
    }
    public DeliveryAddress getOne(Integer id) {
        String sql = gs.findOne();
        Object[] objs = GenerateObjArray.findOne(id);
        List<DeliveryAddress> deliveryAddresss = bd.getSomething(sql,objs,DeliveryAddress.class);
        return deliveryAddresss.size() == 0?null:deliveryAddresss.get(0);
    }
    public List<DeliveryAddress> getAll() {
        String sql = gs.findAll();
        Object[] objs = GenerateObjArray.findAll();
        return bd.getSomething(sql,objs,DeliveryAddress.class);
    }
}