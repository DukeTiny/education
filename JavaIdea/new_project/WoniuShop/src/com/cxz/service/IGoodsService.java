package com.cxz.service;

import com.cxz.po.Goods;

import java.util.List;

public interface IGoodsService {
 
   void add(Goods goods);

    void update(Goods goods,String pk_name);

    void del(Integer id);

    Goods getOne(Integer id);

    List<Goods> getAll();
}