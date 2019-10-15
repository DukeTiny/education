package com.cxz.service;

import com.cxz.dao.DAOFactory;
import com.cxz.po.OrderItem;

import java.util.List;

public class OrderItemServiceImpl implements IOrderItemService {


    public void add(OrderItem orderItem) {
        DAOFactory.getOrderItemDAOImpl().add(orderItem);
    }

    public void update(OrderItem orderItem,String pk_name) {
        DAOFactory.getOrderItemDAOImpl().update(orderItem,pk_name);
    }

    public void del(Integer id) {
        DAOFactory.getOrderItemDAOImpl().del(id);
    }

    public OrderItem getOne(Integer id) {
        return  DAOFactory.getOrderItemDAOImpl().getOne(id);
    }

    public List<OrderItem> getAll() {
        return  DAOFactory.getOrderItemDAOImpl().getAll();
    }
}