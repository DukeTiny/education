package com.cxz.service;

import com.cxz.domain.Userinfo;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface IUserService {
    void save(Userinfo userinfo);
    void delete(Integer uid);
    void update(Userinfo userinfo);
    List<Userinfo> find();
}
