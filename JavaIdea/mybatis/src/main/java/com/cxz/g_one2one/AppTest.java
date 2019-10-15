package com.cxz.g_one2one;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class AppTest {

    @Test
    public void testHusband(){
        SqlSession s = MybatisUtils.openSession();
        // ===========================================================================
        HusbandMapper mapper = s.getMapper(HusbandMapper.class);

        Husband h = mapper.findOne(1);
        System.out.println(h);
        System.out.println(h.getWife());

        // ===========================================================================
        s.close();
    }


    @Test
    public void testWife(){
        SqlSession s = MybatisUtils.openSession();
        // ===========================================================================
        WifeMapper mapper = s.getMapper(WifeMapper.class);

        Wife h = mapper.findOne(1);
        System.out.println(h);
        System.out.println(h.getHusband());

        // ===========================================================================
        s.close();
    }


}
