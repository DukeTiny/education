package com.sia.dao;

import com.sia.bean.User;
import com.sia.util.BaseDao;

import java.util.List;

public class UserDaoImpl implements IUserDao{
    BaseDao<User> bd = new BaseDao<>();
    @Override
    public void add(User user) {
        String sql = "INSERT INTO t_user VALUES(NULL,?,?,?,?)";
        Object[] objects = {user.getUname(),user.getUpwd(),user.getUrole(),user.getUstatus()};
        bd.doSomething(sql,objects);
    }

    @Override
    public void del(Integer uid) {
        String sql = "DELETE FROM t_user WHERE uid=?";
        Object[] objects = {uid};
        bd.doSomething(sql,objects);
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE t_user SET uname=?,upwd=?,urole=?,ustatus=? WHERE uid=?";
        Object[] objects = {user.getUname(),user.getUpwd(),user.getUrole(),user.getUstatus(),user.getUid()};
        bd.doSomething(sql,objects);
    }

    @Override
    public User getLoginUser(String uname,String upwd) {
        String sql = "SELECT * FROM t_user WHERE uname=? AND upwd=?";
        Object[] objects = {uname,upwd};
        List<User> list = bd.getSomething(sql,objects,User.class);
        return list.size()==0?null:list.get(0);
    }

    @Override
    public List<User> getAll() {
        String sql = "SELECT * FROM t_user WHERE urole!='管理员'";
        Object[] objects = {};
        return bd.getSomething(sql,objects,User.class);
    }
}
