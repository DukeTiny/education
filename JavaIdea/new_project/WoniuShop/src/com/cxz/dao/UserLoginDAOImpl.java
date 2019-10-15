package com.cxz.dao;

import com.cxz.po.UserLogin;
import com.cxz.util.BaseDao;
import com.cxz.util.GenerateObjArray;
import com.cxz.util.GenerateSQL;

import java.util.List;

public class UserLoginDAOImpl implements IUserLoginDAO {

    private GenerateSQL gs = new GenerateSQL(UserLogin.class,"userLogin");

    private BaseDao<UserLogin> bd = new BaseDao<>();

    public void add(UserLogin userLogin) {
        String sql = gs.insert();
        Object[] objs = GenerateObjArray.insert(userLogin);
        bd.doSomething(sql,objs);
    }
    public void update(UserLogin userLogin,String pk_name) {
        String sql = gs.update(pk_name);
        Object[] objs = GenerateObjArray.update(userLogin,pk_name);
        bd.doSomething(sql,objs);
    }
    public void del(Integer id) {
        String sql = gs.del();
        Object[] objs = GenerateObjArray.del(id);
        bd.doSomething(sql,objs);
    }
    public UserLogin getOne(Integer id) {
        String sql = gs.findOne();
        Object[] objs = GenerateObjArray.findOne(id);
        List<UserLogin> userLogins = bd.getSomething(sql,objs,UserLogin.class);
        return userLogins.size() == 0?null:userLogins.get(0);
    }
    public List<UserLogin> getAll() {
        String sql = gs.findAll();
        Object[] objs = GenerateObjArray.findAll();
        return bd.getSomething(sql,objs,UserLogin.class);
    }
}