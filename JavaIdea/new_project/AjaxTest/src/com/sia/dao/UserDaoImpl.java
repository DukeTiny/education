package com.sia.dao;

import com.sia.bean.User;
import com.sia.util.BaseDao;

import java.util.List;

public class UserDaoImpl implements IUserDao {

    BaseDao<User> bd = new BaseDao<>();

    @Override
    public void add(User user) {
        String sql = "INSERT INTO t_user VALUES(?,?,?,?,?)";
        Object[] objects = { user.getUid(),user.getuName(),user.getuPwd(),user.getuRole(),user.getuStatus() };
        bd.doSomething(sql,objects);
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE t_user SET uname=?,upwd=?,urole=?,ustatus=? WHERE uid=?";
        Object[] objects = { user.getuName(),user.getuPwd(),user.getuRole(),user.getuStatus(),user.getUid() };
        bd.doSomething(sql,objects);
    }

    @Override
    public void del(Integer uid) {
        String sql = "DELETE FROM t_user WHERE uid=?";
        Object[] objects = {uid};
        bd.doSomething(sql,objects);
    }

    @Override
    public User getOne(Integer uid) {
        String sql = "SELECT * FROM t_user WHERE uid=?";
        Object[] objects = {uid};
        List<User> users = bd.getSomething(sql,objects,User.class);
        return users.size()==0?null:users.get(0);
    }

    @Override
    public List<User> getAll() {
        String sql = "SELECT * FROM t_user";
        Object[] objects = {};
        return bd.getSomething(sql,objects,User.class);
    }

    @Override
    public User getOneByName(String uname) {
        String sql = "SELECT * FROM t_user WHERE uname=?";
        Object[] objects = {};
        List<User> users = bd.getSomething(sql,objects,User.class);
        return users.size()==0?null:users.get(0);
    }
}
