#视图 view
#视图的创建
CREATE OR REPLACE VIEW scview
AS
SELECT s.`sname`,c.`cname`,sc.`degree` 
FROM student s,course c,score sc 
WHERE s.`sno`=sc.sno AND c.`cno`=sc.`cno`;

#视图的使用
SELECT * FROM scview WHERE degree>=85;

#查看创建视图的代码
SHOW CREATE VIEW scview;

#查看数据库中视图的信息
SELECT * FROM information_schema.views WHERE table_schema='demo';

#有些条件下，不能对视图进行dml操作。

#删除视图
DROP VIEW stuview;
