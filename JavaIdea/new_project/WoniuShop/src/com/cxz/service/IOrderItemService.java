package com.cxz.service;

import com.cxz.po.OrderItem;

import java.util.List;

public interface IOrderItemService {
 
   void add(OrderItem orderItem);

    void update(OrderItem orderItem,String pk_name);

    void del(Integer id);

    OrderItem getOne(Integer id);

    List<OrderItem> getAll();
}