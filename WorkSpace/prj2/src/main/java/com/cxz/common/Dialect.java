package com.cxz.common;

public interface Dialect {
	
	String getSql(String sql,int offset,int limit);
	
}
