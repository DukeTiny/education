package com.cxz.dao.implement;

import com.cxz.bean.UserInformation;
import com.cxz.dao.interFace.IUserInformationDAO;
import com.cxz.util.BaseDao;
import com.cxz.util.GenerateObjArray;
import com.cxz.util.GenerateSQL;

import java.util.ArrayList;
import java.util.List;

public class UserInformationDAOImpl implements IUserInformationDAO {

    private BaseDao<UserInformation> bd = new BaseDao<>();
    private GenerateSQL gs = new GenerateSQL(UserInformation.class,"user_information");

    @Override
    public void add(UserInformation ui) {
        String sql = gs.insert();
        Object[] objects = GenerateObjArray.insert(ui);
        bd.doSomething(sql,objects);
    }

    @Override
    public void del(Integer userID) {
        String sql = gs.del();
        Object[] objects = GenerateObjArray.del(userID);
        bd.doSomething(sql,objects);
    }

    @Override
    public void update(UserInformation ui) {
        String sql = gs.update();
        Object[] objects = GenerateObjArray.update(ui);
        bd.doSomething(sql,objects);
    }

    @Override
    public UserInformation getOne(Integer userID) {
        String sql = gs.findOne();
        Object[] objects= GenerateObjArray.findOne(userID);
        List<UserInformation> list = bd.getSomething(sql,objects,UserInformation.class);
        return list.size()==0?null:list.get(0);
    }

    @Override
    public List<UserInformation> getAll() {
        String sql = gs.findAll();
        Object[] objects = GenerateObjArray.findAll();
        return bd.getSomething(sql,objects,UserInformation.class);
    }

    @Override
    public UserInformation findByNameAndPWD(String username, String password) {
        String sql = "SELECT * FROM user_information WHERE username=? AND userPWD=?";
        Object[] objects = {username,password};
        List<UserInformation> list = bd.getSomething(sql,objects,UserInformation.class);
        return list.size()==0?null:list.get(0);
    }
}
