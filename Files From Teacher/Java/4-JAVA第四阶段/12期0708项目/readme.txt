�ҹ�����
	1���޾���
		��������
	2��������
		��������
		����Ҫ��һ����������Ŀ��
		��Ŀ��
			�Է��ʵĺ�ϸ��
			ҵ��
			����

��������
	����Ŀ�������㣺���ڽ����� 
		�ֲ�ʽ
		Redis
		Mq
		����һЩ��������Ӧ�á����ḻ��ļ�����
			�ʼ�
			ͼ��
			֧��
			������������
===================================================================
��Ŀ���
	1���޾��� ����ʲô��Ŀ�����ԡ�

	2��������
		��ֹ��
		HR
		OA
		�Ƶ����ϵͳ����Ʒ��
		ѧ������ϵͳ
		ͼ��ݹ���ϵͳ
		ĳĳС�͵�����վ
		ĳĳ���ɹ���ϵͳ
===================================================================
boot+springmvc+mybatis  cloud+mq+redis+ngnix....


===================================================================
Ȩ������
	����shiro�ܸ㶨����

1����ҳ
2��Ȩ��

====================================================================
@Resource��@AutoWired������
	
@AutoWired ֱ�Ӱ�������
	��Spring�ṩ�ġ�
	AutowiredAnnotationBeanPostProcessor������autowired�ġ�
	�ȵ��ã�
		postProcessProperties������
		�Ȱ���������װ��
		�жϣ��жϷ������͵������м����ࡣ
			�����һ����ֱ�ӾͰ������ͽ���ת���ˡ�
			�������������ʼ��������װ�䣬���������ƶ��޷�װ�䣬�ű���
			Except 1 but found 2.


@Resource���������ҡ��Ҳ�����������
	��java�ġ�

====================================================================
mybatis�Ĺ�����ѯ��

1���������
	Userinfo������Ӧ�ð���List����,list���Ͼ��Ƕ��role��

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
		��������������
		select * from a inner join b on a.id=b.id

	�ŵ㣺
		SQL���ֻ��һ����
	ȱ�㣺
		�޷�ʵ���������Ĳ�ѯ���޷��ݹ顣
		�Ķ�����Ƶ����
	
2������Ƕ��
	<resultMap id="BaseResultMap" type="com.woniu.model.Userinfo" >
	    <id column="uid" property="uid" jdbcType="INTEGER" />
	    <result column="uname" property="uname" jdbcType="VARCHAR" />
	    <result column="upass" property="upass" jdbcType="VARCHAR" />
	    <collection property="roles" column="uid" select="com.woniu.mapper.RoleMapper.findByUid"></collection>
	</resultMap>

	SQL��
		������Ƕ�ײ�ѯ�����������1+n�����⡣

	�ŵ㣺

	ȱ�㣺
		SQL����༸����
		ʵ���������Ĳ�ѯ�����Եݹ顣
		


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
�û�����
	�û��ͽ�ɫ��
		

	CRUD�û�����ѡ���Ӧ�Ľ�ɫ��
	���ű��CRUD��



��ɫ����
	��ӽ�ɫ��ʱ�򣬵�ѡ�������ɫ���е�Ȩ��