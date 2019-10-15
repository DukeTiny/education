package com.woniuxy.web.action;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.woniuxy.service.IUserService;

@Component
public class Manager {
	
	@Autowired
	private IUserService service;
	
	@Transactional
	public void batchTransfer(int from, int[] tos, int money) {
		for (int to : tos) {
			service.transfer(from, to, money);
		}
	}
	
}
