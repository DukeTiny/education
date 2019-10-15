orm: Object Relational Mapping
�ൽ���ӳ��
���е����ԣ�����е��е�ӳ��
�����֮��Ĺ�����ϵ������ͱ�֮��������ϵ
orm�У�����Ҫ�Լ�дsql��䡣

�ӿ����ٶ��϶Աȣ�
hibernate > mybatis > jdbc

��ִ��Ч���϶Ա�
jdbc > mybatis > hibernate  

���˵hibernate��ȫ�Զ���ORM��ܣ� ��ôMybatis���ǰ��Զ���ORM��ܡ�

===================================================================================================

�mybatis������
1. ��������
	mybatis
	mysql
	junit

2. ����javabean
	public class User implements Serializable {
		private Integer id;
		private String name;
		private Date birthday;
		private Double money;
		
		// getter and setter ...
	}

4. ����mybatis�������ļ���UserMapper.xml
	<?xml version="1.0" encoding="UTF-8" ?>
	<!DOCTYPE mapper
		 PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
	 	"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
	<mapper namespace="com.woniuxy.a_hello.UserMapper">
		<insert id="save" parameterType="com.woniuxy.a_hello.User">
			insert into user values(null, #{name}, #{birthday}, #{money})
		</insert>
	</mapper>

3. ����mybatis�������ļ���mybatis-config.xml
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
	
4. ��д���Դ��룺
	@Test
	public void test() throws Exception {
		InputStream in = AppTest.class.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		SqlSession s = sf.openSession();
		// ======================================================
		
		User user = new User();
		user.setName("��ҩʦ");
		user.setBirthday(new Date());
		user.setMoney(888d);
		
		s.insert("com.woniuxy.a_hello.UserMapper.save", user);
		
		// ======================================================
		s.commit();
		s.close();
	}
	
