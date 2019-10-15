package com.cxz.service;

import com.cxz.po.Order;

import java.util.List;

public interface IOrderService {
 
   void add(Order order);

    void update(Order order,String pk_name);

    void del(Integer id);

    Order getOne(Integer id);

    List<Order> getAll();
}