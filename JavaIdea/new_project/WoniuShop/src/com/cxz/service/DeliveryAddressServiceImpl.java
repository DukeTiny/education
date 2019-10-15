package com.cxz.service;

import com.cxz.dao.DAOFactory;
import com.cxz.po.DeliveryAddress;

import java.util.List;

public class DeliveryAddressServiceImpl implements IDeliveryAddressService {


    public void add(DeliveryAddress deliveryAddress) {
        DAOFactory.getDeliveryAddressDAOImpl().add(deliveryAddress);
    }

    public void update(DeliveryAddress deliveryAddress,String pk_name) {
        DAOFactory.getDeliveryAddressDAOImpl().update(deliveryAddress,pk_name);
    }

    public void del(Integer id) {
        DAOFactory.getDeliveryAddressDAOImpl().del(id);
    }

    public DeliveryAddress getOne(Integer id) {
        return  DAOFactory.getDeliveryAddressDAOImpl().getOne(id);
    }

    public List<DeliveryAddress> getAll() {
        return  DAOFactory.getDeliveryAddressDAOImpl().getAll();
    }
}