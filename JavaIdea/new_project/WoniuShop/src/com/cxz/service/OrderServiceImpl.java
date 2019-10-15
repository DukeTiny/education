package com.cxz.service;

import com.cxz.dao.DAOFactory;
import com.cxz.po.Order;

import java.util.List;

public class OrderServiceImpl implements IOrderService {


    public void add(Order order) {
        DAOFactory.getOrderDAOImpl().add(order);
    }

    public void update(Order order,String pk_name) {
        DAOFactory.getOrderDAOImpl().update(order,pk_name);
    }

    public void del(Integer id) {
        DAOFactory.getOrderDAOImpl().del(id);
    }

    public Order getOne(Integer id) {
        return  DAOFactory.getOrderDAOImpl().getOne(id);
    }

    public List<Order> getAll() {
        return  DAOFactory.getOrderDAOImpl().getAll();
    }
}