package com.cxz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxz.mapper.TreeMapper;
import com.cxz.model.Tree;
import com.cxz.model.User;
import com.cxz.service.ITreeService;

@Service
public class TreeServiceImpl implements ITreeService{

	@Resource
	private TreeMapper treeMapper;
	
	@Transactional( readOnly = true )
	public List<Tree> findAll() {
		return treeMapper.selectByExample(null);
	}

	
	
}
