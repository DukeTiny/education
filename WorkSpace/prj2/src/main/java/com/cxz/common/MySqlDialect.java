package com.cxz.common;

public class MySqlDialect implements Dialect {

	public String getSql(String sql, int offset, int limit) {
		return sql + " limit " + offset + "," + limit;
	}

}
