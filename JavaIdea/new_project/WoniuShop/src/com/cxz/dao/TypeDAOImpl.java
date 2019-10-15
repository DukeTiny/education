package com.cxz.dao;

import com.cxz.po.Type;
import com.cxz.util.BaseDao;
import com.cxz.util.GenerateObjArray;
import com.cxz.util.GenerateSQL;

import java.util.List;

public class TypeDAOImpl implements ITypeDAO {

    private GenerateSQL gs = new GenerateSQL(Type.class,"type");

    private BaseDao<Type> bd = new BaseDao<>();

    public void add(Type type) {
        String sql = gs.insert();        Object[] objs = GenerateObjArray.insert(type);
        bd.doSomething(sql,objs);
    }
    public void update(Type type,String pk_name) {
        String sql = gs.update(pk_name);
        Object[] objs = GenerateObjArray.update(type,pk_name);
        bd.doSomething(sql,objs);
    }
    public void del(Integer id) {
        String sql = gs.del();
        Object[] objs = GenerateObjArray.del(id);
        bd.doSomething(sql,objs);
    }
    public Type getOne(Integer id) {
        String sql = gs.findOne();
        Object[] objs = GenerateObjArray.findOne(id);
        List<Type> types = bd.getSomething(sql,objs,Type.class);
        return types.size() == 0?null:types.get(0);
    }
    public List<Type> getAll() {
        String sql = gs.findAll();
        Object[] objs = GenerateObjArray.findAll();
        return bd.getSomething(sql,objs,Type.class);
    }
}