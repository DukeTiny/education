package com.cxz.quickstart;

import org.springframework.stereotype.Service;

@Service
public class CalcImpl /* implements ICalc */ {

	public void add(int a, int b) {
		System.out.println("CalcImpl.add()");
	}

}
