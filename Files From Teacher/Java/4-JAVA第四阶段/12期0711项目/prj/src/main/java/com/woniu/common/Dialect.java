package com.woniu.common;

public interface Dialect {
	public String getLimitSql(String sql,int offset,int limit);
}
