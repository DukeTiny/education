=====================================
��εõ��ող������ݵ�id:
1:�������ֺ����������ٲ�һ�顣
2: select max(id) from table
3: ��Ҫ����������uuid�ֶΡ� Oralceû��������ֻ��sequence��
4��last_insert_id()  @@Identity
	�ܹ���ȡ��ǰ�Ự�У��ող�������һ�������ݵ�id.
	SELECT LAST_INSERT_ID()
	SELECT @@IDENTITY

5: mybatis
	<insert id="insert" useGeneratedKeys="true" keyProperty="uid" parameterType="com.woniu.model.Userinfo">
	ִ�в������֮�󣬱�����Ķ���ֱ�Ӿ���uid��ֵ��

=====================================
Mysql�ķ�ҳ
	SELECT * FROM userinfo LIMIT 0,2

Oracle�ķ�ҳ��
	select * from 
	(select a.*,rownum rn from table a where rn<20) t
	where t.rn>10

mybatis�ķ�ҳ��

1��ֱ����mapper.xml�е�SQl��д
	limit start,size

	ȱ�㣺�������ô���
	      ��ҳSQLд��xml�С�������������ݿ⡣

2: ��mybatis�Զ����������з�ҳ��
	���ø����κ�xml�ļ���ֱ���ڽӿ��д���RowBounds����������ʱֱ�Ӹ�ֵ��ok����
	�ŵ㣺���ø���xml,ֱ�ӽӿ��д�������������ˡ�
	ȱ�㣺rowboundsʵ���Ͻ��е����ڴ��ҳ�������������ҳ��


3��mybatis�����У����ĳ�������
	
=====================================
=====================================
=====================================
=====================================