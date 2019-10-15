=====================================
如何得到刚刚插入数据的id:
1:根据名字和密码重新再查一遍。
2: select max(id) from table
3: 不要用自增。用uuid字段。 Oralce没有自增，只有sequence。
4：last_insert_id()  @@Identity
	能够获取当前会话中，刚刚插入的最后一个的数据的id.
	SELECT LAST_INSERT_ID()
	SELECT @@IDENTITY

5: mybatis
	<insert id="insert" useGeneratedKeys="true" keyProperty="uid" parameterType="com.woniu.model.Userinfo">
	执行插入完毕之后，被插入的对象直接就有uid的值。

=====================================
Mysql的分页
	SELECT * FROM userinfo LIMIT 0,2

Oracle的分页：
	select * from 
	(select a.*,rownum rn from table a where rn<20) t
	where t.rn>10

mybatis的分页：

1：直接在mapper.xml中的SQl中写
	limit start,size

	缺点：参数不好处理
	      分页SQL写在xml中。不方便更换数据库。

2: 用mybatis自定的类来进行分页。
	不用更改任何xml文件，直接在接口中传入RowBounds参数，调用时直接赋值就ok拉。
	优点：不用更改xml,直接接口中传入参数，就完了。
	缺点：rowbounds实际上进行的是内存分页，而不是物理分页。


3：mybatis的运行，核心程序是由
	
=====================================
=====================================
=====================================
=====================================