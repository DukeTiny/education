package com.cxz.service;

import com.cxz.po.DeliveryAddress;

import java.util.List;

public interface IDeliveryAddressService {
 
   void add(DeliveryAddress deliveryAddress);

    void update(DeliveryAddress deliveryAddress,String pk_name);

    void del(Integer id);

    DeliveryAddress getOne(Integer id);

    List<DeliveryAddress> getAll();
}