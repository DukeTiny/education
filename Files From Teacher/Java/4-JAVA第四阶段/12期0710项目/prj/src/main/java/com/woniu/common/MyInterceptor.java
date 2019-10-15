package com.woniu.common;

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

/**   
 * @ClassName:  MyInterceptor   
 * @Description:TODO(拦截StatementHandler对象的prepare方法进行分页行为)   
 * @author: 蜗牛学院老韩
 * @date:   2019年7月9日 下午2:50:45   
 *     
 * @Copyright: 2019 www.woniu.com Inc. All rights reserved. 
 */  
//声明拦截器拦截StatementHandler类的prepare方法，同时参数为Connection
@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args= {Connection.class,Integer.class})})
public class MyInterceptor implements Interceptor{

	@Override
	public Object intercept(Invocation arg0) throws Throwable {
		// TODO Auto-generated method stub
		
		//得到被代理的对象
		StatementHandler statementHandler = (StatementHandler)arg0.getTarget();
		//得到元对象  源对象中存在了执行的SQL和各种条件
		MetaObject metaObject = MetaObject.forObject(statementHandler,new DefaultObjectFactory(),new DefaultObjectWrapperFactory(),new DefaultReflectorFactory());
		
		RowBounds rb = (RowBounds)metaObject.getValue("delegate.rowBounds");
		
		if(rb==null||rb==RowBounds.DEFAULT) {
			System.out.println("不分页");
			Object obj = arg0.proceed();//继续执行  放行
			return obj;
		}else {
			System.out.println("分页");
			
			//得到原始的SQL语句
			String orinialSql = (String)metaObject.getValue("delegate.boundSql.sql");
			//取出你们的start
			int offset = rb.getOffset();
			//取出你们的size
			int limit = rb.getLimit();
			
			//读取配置文件
			Configuration configuration = (Configuration)metaObject.getValue("delegate.configuration");
			
			//得到选中的方言
			String type = configuration.getVariables().getProperty("dialect");
			
			Dialect dialect = createDialect(type);
			
			//构建我们分页的SQL语句
			String finalSql = dialect.getLimitSql(orinialSql, offset, limit);
			
			//把构建的SQL重新再放入metaObject中去
			metaObject.setValue("delegate.boundSql.sql",finalSql);
			
			//对RowBounds进行重置
			metaObject.setValue("delegate.rowBounds.offset",RowBounds.NO_ROW_OFFSET);
			metaObject.setValue("delegate.rowBounds.limit",RowBounds.NO_ROW_LIMIT);
			
			Object obj = arg0.proceed();//继续执行  放行
			return obj;
		}
		
		
	}
	
	public Dialect createDialect(String type) {
		if("mysql".equalsIgnoreCase(type)) {
			return new MySqlDialect();
		}
		else if("oracle".equalsIgnoreCase(type)) {
			return new OracleDialect();
		}else {
			throw new RuntimeException("你要干什么?");
		}
	}

	@Override
	//装载插件
	public Object plugin(Object target) {
		// TODO Auto-generated method stub
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties arg0) {
		// TODO Auto-generated method stub
		
	}

}
