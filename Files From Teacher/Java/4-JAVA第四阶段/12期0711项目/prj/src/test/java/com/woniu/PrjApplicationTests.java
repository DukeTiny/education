package com.woniu;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniu.mapper.UserinfoMapper;
import com.woniu.model.Userinfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrjApplicationTests {
	@Resource
	private UserinfoMapper userinfoMapper;
	@Test
	public void contextLoads() {
	}
	
	
}
