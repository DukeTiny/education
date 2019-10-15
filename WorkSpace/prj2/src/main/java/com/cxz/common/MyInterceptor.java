package com.cxz.common;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;


@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args= {Connection.class,Integer.class})})
public class MyInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object object = null;
		StatementHandler target = (StatementHandler)invocation.getTarget(); 
		MetaObject meta = MetaObject.forObject(target, new DefaultObjectFactory(),new DefaultObjectWrapperFactory(),new DefaultReflectorFactory());
		RowBounds rb = (RowBounds)meta.getValue("delegate.rowBounds");
		if( rb==null || rb==RowBounds.DEFAULT ) {
			object = invocation.proceed();
		} else {
			int offset = rb.getOffset();
			int limit = rb.getLimit();
			String sql = (String) meta.getValue("delegate.boundSql.sql");
            System.out.println(sql);
			Configuration configuration = (Configuration) meta.getValue("delegate.configuration");
			String database = configuration.getVariables().getProperty("dialect");
			sql = getDialect(database).getSql(sql, offset, limit);
			meta.setValue("delegate.boundSql.sql", sql);
			meta.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
			meta.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);
			object = invocation.proceed();
		}
		return object;
	}

	private Dialect getDialect( String database ) {
		if( "mysql".equalsIgnoreCase(database) ) {
			return new MySqlDialect();
		} else if( "oracle".equalsIgnoreCase(database) ) {
			return new OrcaleDialect();
		} else {
			throw new RuntimeException("No Database Dialect");
		}
	}
	
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
		
	}

}
