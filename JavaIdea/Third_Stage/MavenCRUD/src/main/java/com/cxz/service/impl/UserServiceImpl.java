package com.cxz.service.impl;

import com.cxz.bean.Page;
import com.cxz.bean.User;
import com.cxz.dao.IUserDAO;
import com.cxz.dao.UserDAOImpl;
import com.cxz.service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {

    private IUserDAO dao = new UserDAOImpl();

    public void save(User user) {
        dao.save(user);
    }

    public void update(User user) {
        dao.update(user);
    }

    public void delete(Integer id) {
        dao.delete(id);
    }

    public List<User> find() {
        return dao.find();
    }

    public User find(Integer id) {
        return dao.find(id);
    }

    @Override
    public Page findPageData(int p, int size) {
        int rowCount = dao.getRowCount();
        Page<User> page = new Page<>(p,rowCount,size);
        List<User> list = dao.find(page.getStartLine(),size);
        page.setList(list);
        return page;
    }
}
