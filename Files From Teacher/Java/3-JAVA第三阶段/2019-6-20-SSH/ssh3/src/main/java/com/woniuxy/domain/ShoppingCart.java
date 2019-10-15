package com.woniuxy.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart {
	public ShoppingCart() {
		System.out.println("ShoppingCart()");
	}
	
	// º”»Î
	
	// «Âø’
}
