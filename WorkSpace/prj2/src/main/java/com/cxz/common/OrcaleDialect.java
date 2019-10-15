package com.cxz.common;

public class OrcaleDialect implements Dialect{

	public String getSql(String sql, int offset, int limit) {
		
		String newSqlString = "select * from " + 
				" (select a.*,rownum rn from ("+sql+") a where rn<"+(offset+limit)+") t" + 
				" where t.rn>"+offset;
		return newSqlString;
	}

}
