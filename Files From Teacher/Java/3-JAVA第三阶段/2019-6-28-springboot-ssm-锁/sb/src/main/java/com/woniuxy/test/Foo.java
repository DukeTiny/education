package com.woniuxy.test;

import java.util.Date;

import org.springframework.context.annotation.Bean;


public class Foo {

	@Bean
	public Date dd() {
		return new Date();
	}
	
	@Bean
	public Date dd2() {
		return new Date();
	}
}
