找工作：
	1：无经验
		葵花宝典
	2：带经验
		葵花宝典
		必须要有一个完整的项目。
		项目：
			对方问的很细。
			业务
			技术

核心任务：
	做项目。技术点：属于锦上添花 
		分布式
		Redis
		Mq
		其他一些第三方的应用。（丰富你的简历）
			邮件
			图表
			支付
			。。。。。。
===================================================================
项目立项：
	1：无经验 你做什么项目都可以。

	2：带经验
		禁止做
		HR
		OA
		酒店管理系统（产品）
		学生管理系统
		图书馆管理系统
		某某小型电商网站
		某某网吧管理系统
===================================================================
boot+springmvc+mybatis  cloud+mq+redis+ngnix....


===================================================================
权限树：
	不加shiro能搞定不。

1：分页
2：权限

====================================================================
@Resource和@AutoWired的区别：
	
@AutoWired 直接按类型找
	是Spring提供的。
	AutowiredAnnotationBeanPostProcessor完成填充autowired的。
	先调用：
		postProcessProperties方法。
		先按照类型来装。
		判断：判断符合类型的条件有几个类。
			如果有一个，直接就按照类型进行转配了。
			如果有两个，开始按照名称装配，如果多个名称都无法装配，才报错。
			Except 1 but found 2.


@Resource按照名字找。找不到按类型找
	是java的。

====================================================================
mybatis的关联查询：

1：关联结果
	Userinfo对象中应该包含List集合,list集合就是多个role。

	<resultMap id="BaseResultMap" type="com.woniu.model.Userinfo" >
 	    <id column="uid" property="uid" jdbcType="INTEGER" />
	    <result column="uname" property="uname" jdbcType="VARCHAR" />
	    <result column="upass" property="upass" jdbcType="VARCHAR" />
	    <collection ofType="">
		<id column="rid" property="rid" jdbcType="INTEGER" />
		<result column="rname" property="rname" jdbcType="VARCHAR" />
	    </collection>
	</resultMap>

	SQL:
		做的是两表联查
		select * from a inner join b on a.id=b.id

	优点：
		SQL语句只有一条。
	缺点：
		无法实现面向对象的查询。无法递归。
		改动过于频繁。
	
2：关联嵌套
	<resultMap id="BaseResultMap" type="com.woniu.model.Userinfo" >
	    <id column="uid" property="uid" jdbcType="INTEGER" />
	    <result column="uname" property="uname" jdbcType="VARCHAR" />
	    <result column="upass" property="upass" jdbcType="VARCHAR" />
	    <collection property="roles" column="uid" select="com.woniu.mapper.RoleMapper.findByUid"></collection>
	</resultMap>

	SQL：
		做的是嵌套查询。往往会造成1+n的问题。

	优点：

	缺点：
		SQL语句会多几条。
		实现面向对象的查询。可以递归。
		


	<resultMap id="BaseResultMap" type="com.woniu.model.Tree" >
	    <id column="tid" property="uid" jdbcType="INTEGER" />
	    <result column="name" property="uname" jdbcType="VARCHAR" />
	    <result column="pid" property="upass" jdbcType="VARCHAR" />
	    <collection property="trees" column="tid" select="find"></collection>
	</resultMap>
	
	<select id="find" resultMap="BaseResultMap" parameterType="java.lang.Integer">
		select * from tree where pid=#{pid}
	</select>
=========================================================
用户管理：
	用户和角色表：
		

	CRUD用户表，得选择对应的角色。
	两张表的CRUD。



角色管理：
	添加角色的时候，得选择这个角色具有的权限