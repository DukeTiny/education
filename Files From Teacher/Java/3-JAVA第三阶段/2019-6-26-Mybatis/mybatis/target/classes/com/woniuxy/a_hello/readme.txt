orm: Object Relational Mapping
类到表的映射
类中的属性，与表中的列的映射
类和类之间的关联关系，到表和表之间的外键关系
orm中，不需要自己写sql语句。

从开发速度上对比：
hibernate > mybatis > jdbc

从执行效率上对比
jdbc > mybatis > hibernate  

如果说hibernate是全自动的ORM框架， 那么Mybatis就是半自动的ORM框架。

===================================================================================================

搭建mybatis环境。
1. 导入依赖
	mybatis
	mysql
	junit

2. 创建javabean
	public class User implements Serializable {
		private Integer id;
		private String name;
		private Date birthday;
		private Double money;
		
		// getter and setter ...
	}

4. 创建mybatis子配置文件：UserMapper.xml
	<?xml version="1.0" encoding="UTF-8" ?>
	<!DOCTYPE mapper
		 PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
	 	"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
	<mapper namespace="com.woniuxy.a_hello.UserMapper">
		<insert id="save" parameterType="com.woniuxy.a_hello.User">
			insert into user values(null, #{name}, #{birthday}, #{money})
		</insert>
	</mapper>

3. 创建mybatis主配置文件：mybatis-config.xml
	<?xml version="1.0" encoding="UTF-8" ?>
	<!DOCTYPE configuration
	 PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
	 "http://mybatis.org/dtd/mybatis-3-config.dtd">
	<configuration>
		<environments default="development">
			<environment id="development">
				<transactionManager type="JDBC" />
				<dataSource type="POOLED">
					<property name="driver" value="com.mysql.jdbc.Driver" />
					<property name="url" value="jdbc:mysql://localhost:3306/test" />
					<property name="username" value="root" />
					<property name="password" value="123" />
				</dataSource>
			</environment>
		</environments>
		<mappers>
			<mapper resource="com/woniuxy/a_hello/UserMapper.xml"/>
		</mappers>
	</configuration>
	
4. 编写测试代码：
	@Test
	public void test() throws Exception {
		InputStream in = AppTest.class.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		SqlSession s = sf.openSession();
		// ======================================================
		
		User user = new User();
		user.setName("黄药师");
		user.setBirthday(new Date());
		user.setMoney(888d);
		
		s.insert("com.woniuxy.a_hello.UserMapper.save", user);
		
		// ======================================================
		s.commit();
		s.close();
	}
	
