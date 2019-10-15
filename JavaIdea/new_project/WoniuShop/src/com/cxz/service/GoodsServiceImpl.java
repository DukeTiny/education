package com.cxz.service;

import com.cxz.dao.DAOFactory;
import com.cxz.po.Goods;

import java.util.List;

public class GoodsServiceImpl implements IGoodsService {


    public void add(Goods goods) {
        DAOFactory.getGoodsDAOImpl().add(goods);
    }

    public void update(Goods goods,String pk_name) {
        DAOFactory.getGoodsDAOImpl().update(goods,pk_name);
    }

    public void del(Integer id) {
        DAOFactory.getGoodsDAOImpl().del(id);
    }

    public Goods getOne(Integer id) {
        return  DAOFactory.getGoodsDAOImpl().getOne(id);
    }

    public List<Goods> getAll() {
        return  DAOFactory.getGoodsDAOImpl().getAll();
    }
}