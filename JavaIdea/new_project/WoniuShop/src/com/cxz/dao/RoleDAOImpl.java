package com.cxz.dao;

import com.cxz.po.Role;
import com.cxz.util.BaseDao;
import com.cxz.util.GenerateObjArray;
import com.cxz.util.GenerateSQL;

import java.util.List;

public class RoleDAOImpl implements IRoleDAO {

    private GenerateSQL gs = new GenerateSQL(Role.class,"role");

    private BaseDao<Role> bd = new BaseDao<>();

    public void add(Role role) {
        String sql = gs.insert();
        Object[] objs = GenerateObjArray.insert(role);
        bd.doSomething(sql,objs);
    }
    public void update(Role role,String pk_name) {
        String sql = gs.update(pk_name);
        Object[] objs = GenerateObjArray.update(role,pk_name);
        bd.doSomething(sql,objs);
    }
    public void del(Integer id) {
        String sql = gs.del();
        Object[] objs = GenerateObjArray.del(id);
        bd.doSomething(sql,objs);
    }
    public Role getOne(Integer id) {
        String sql = gs.findOne();
        Object[] objs = GenerateObjArray.findOne(id);
        List<Role> roles = bd.getSomething(sql,objs,Role.class);
        return roles.size() == 0?null:roles.get(0);
    }
    public List<Role> getAll() {
        String sql = gs.findAll();
        Object[] objs = GenerateObjArray.findAll();
        return bd.getSomething(sql,objs,Role.class);
    }
}