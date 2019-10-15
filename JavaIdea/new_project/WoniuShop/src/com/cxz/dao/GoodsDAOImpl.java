package com.cxz.dao;

import com.cxz.po.Goods;
import com.cxz.util.BaseDao;
import com.cxz.util.GenerateObjArray;
import com.cxz.util.GenerateSQL;

import java.util.List;

public class GoodsDAOImpl implements IGoodsDAO {

    private GenerateSQL gs = new GenerateSQL(Goods.class,"goods");
    private BaseDao<Goods> bd = new BaseDao<>();

    public void add(Goods goods) {
        String sql = gs.insert();
        Object[] objs = GenerateObjArray.insert(goods);
        bd.doSomething(sql,objs);
    }
    public void update(Goods goods,String pk_name) {
        String sql = gs.update(pk_name);
        Object[] objs = GenerateObjArray.update(goods,pk_name);
        bd.doSomething(sql,objs);
    }
    public void del(Integer id) {
        String sql = gs.del();
        Object[] objs = GenerateObjArray.del(id);
        bd.doSomething(sql,objs);
    }
    public Goods getOne(Integer id) {
        String sql = gs.findOne();
        Object[] objs = GenerateObjArray.findOne(id);
        List<Goods> goodss = bd.getSomething(sql,objs,Goods.class);
        return goodss.size() == 0?null:goodss.get(0);
    }
    public List<Goods> getAll() {
        String sql = gs.findAll();
        Object[] objs = GenerateObjArray.findAll();
        return bd.getSomething(sql,objs,Goods.class);
    }
}