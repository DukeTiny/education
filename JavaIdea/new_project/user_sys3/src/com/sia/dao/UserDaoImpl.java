package com.sia.dao;

import com.sia.bean.PageNum;
import com.sia.bean.User;
import com.sia.util.BaseDao;

import java.util.List;

public class UserDaoImpl implements IUserDao {
    BaseDao<User> bd = new BaseDao<>();
    @Override
    public void add(User user) {
        String sql = "INSERT INTO t_user VALUES(null,?,?,?,?)";
        Object[] objects = {user.getUname(),user.getUpwd(),user.getUrole(),user.getUstatus()};
        bd.doSomething(sql,objects);
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE t_user SET upwd=?,urole=?,ustatus=? WHERE uid=?";
        Object[] objects = {user.getUpwd(),user.getUrole(),user.getUstatus(),user.getUid()};
        bd.doSomething(sql,objects);
    }

    @Override
    public void del(Integer uid) {
        String sql = "DELETE FROM t_user WHERE uid=?";
        Object[] objects = {uid};
        bd.doSomething(sql,objects);
    }

    @Override
    public User login(String uname, String upwd) {
        String sql = "SELECT * FROM t_user WHERE uname=? AND upwd=?";
        Object[] objects = {uname,upwd};
        List<User> users = bd.getSomething(sql,objects,User.class);
        return users.size()==0?null:users.get(0);
    }

    @Override
    public User getOne(Integer uid) {
        String sql = "SELECT * FROM t_user WHERE uid=?";
        Object[] objects = {uid};
        List<User> users = bd.getSomething(sql,objects,User.class);
        return users.size()==0?null:users.get(0);
    }

    @Override
    public List<User> getAll(PageNum pn) {
        if( pn.getTotalPages()==-1 ) {
            String sql1 = "SELECT * FROM t_user";
            Object[] temp = {};
            List<User> list = bd.getSomething(sql1, temp, User.class);
            int num = list.size() / pn.getMaxRows();
            pn.setTotalPages(list.size() % pn.getMaxRows() == 0 ? num : num + 1);
            list.clear();
        }
        int start = (pn.getPageNum()-1)*pn.getMaxRows();
        int end = (pn.getPageNum())*pn.getMaxRows();
        String sql2 ="SELECT * FROM t_user LIMIT ?,?";
        Object[] objects ={start,end};
        List<User> users = bd.getSomething(sql2,objects,User.class);
        return users.size()==0?null:users;
    }

}
