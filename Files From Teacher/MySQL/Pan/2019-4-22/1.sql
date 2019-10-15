

SELECT * FROM vip WHERE
EXISTS (SELECT * FROM vip WHERE 1>2);

#EXISTS 子查询中，如果有结果集，则返回真.
#如果子查询返回 empty set，则返回假。

#查询有喜欢类型的会员。
SELECT * FROM vip WHERE EXISTS
(SELECT vid FROM likes WHERE likes.vid=vip.vid);

#连接查询
#内连接
	交叉连接
		将两个记录进行全排，笛卡尔积
	等值连接
	, INNER JOIN
		WHERE
			SELECT * FROM vip,likes WHERE vip.`vid`=likes.`vid`;
		ON
			SELECT * FROM vip INNER JOIN likes ON vip.`vid`=likes.`vid`; 
		USING(两个表的关联列必须同名)
			SELECT * FROM vip INNER JOIN likes USING(vid)
#外链接
	左外连接
		保持左表的所有数据，右表没有对应数据的填null
	右外连接
		保持右表的所有数据，左表没有对应数据的填null
	全外连接(mysql中暂无)
		
#自然连接

SELECT * FROM vip;

SELECT * FROM film;
SELECT * FROM TYPES;

#查询所有电影的名字及类型名
SELECT fname,tname FROM film,TYPES WHERE film.`tid`=types.`tid`
SELECT fname,f.tid,tname FROM film f INNER JOIN TYPES t ON f.`tid`=t.`tid`
SELECT fname,tname FROM film f INNER JOIN TYPES t USING(tid)

SELECT * FROM vip LEFT JOIN likes ON vip.vid=likes.`vid`;

INSERT INTO film VALUES(NULL,'妇联4','钢铁侠','李安',200,NULL)
INSERT INTO film VALUES(NULL,'妇联5','钢铁侠','李安',200,NULL)
#显示所有电影及对应类型
SELECT * FROM film LEFT JOIN TYPES ON film.tid= types.`tid`;
#显示所有类型及对应的电影
SELECT * FROM film RIGHT JOIN TYPES ON film.`tid`=types.`tid`;
#显示所有的电影和类型。 变通全外连接 union
SELECT * FROM film LEFT JOIN TYPES ON film.tid= types.`tid`
UNION
SELECT * FROM film RIGHT JOIN TYPES ON film.`tid`=types.`tid`
#自然连接 等同于内连接的等值连接
SELECT * FROM film NATURAL JOIN TYPES

SELECT * FROM film,TYPES WHERE film.`tid`=types.`tid`;

#连接查询 两表 可以是任意个表
SELECT * FROM vip;
SELECT * FROM TYPES;
SELECT * FROM likes;
#显示所有喜好表中的会员姓名和类型名
SELECT * FROM vip v,likes l,TYPES t WHERE v.`vid`=l.`vid` AND l.`tid`=t.`tid`;

SELECT * FROM vip LEFT JOIN likes ON vip.vid=likes.`vid` LEFT JOIN TYPES ON likes.`tid`=types.tid;