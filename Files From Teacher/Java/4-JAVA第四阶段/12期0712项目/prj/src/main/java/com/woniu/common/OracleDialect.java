package com.woniu.common;

public class OracleDialect implements Dialect {

	@Override
	public String getLimitSql(String sql, int offset, int limit) {
		// TODO Auto-generated method stub
		String newSqlString = "select * from " + 
				"	(select a.*,rownum rn from ("+sql+") a where rn<"+(offset+limit)+") t" + 
				"	where t.rn>"+offset;
		return newSqlString;
	}

	


}
