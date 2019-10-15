package com.cxz.service.impl;

import com.cxz.domain.Userinfo;
import com.cxz.domain.UserinforoleKey;
import com.cxz.mapper.UserinfoMapper;
import com.cxz.mapper.UserinforoleMapper;
import com.cxz.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Resource
    private UserinfoMapper userinfoMapper;

    @Resource
    private UserinforoleMapper userinforoleMapper;

    @Override
    public void save(Userinfo userinfo) {
        System.out.println(userinfoMapper.getClass());
        userinfoMapper.insert(userinfo);
        Integer id = userinfoMapper.findId(userinfo.getUname());
//        List<String> roles = userinfo.getRoles();
        UserinforoleKey uk = new UserinforoleKey();
        uk.setUid(id);
//        for ( String r : roles ) {
//            Integer rid = userinforoleMapper.findIdByName(r);
//            uk.setRid(rid);
//            userinforoleMapper.insert(uk);
//        }
    }

    @Override
    public void delete(Integer uid) {

    }

    @Override
    public void update(Userinfo userinfo) {

    }

    @Override
    public List<Userinfo> find() {
        return null;
    }
}
