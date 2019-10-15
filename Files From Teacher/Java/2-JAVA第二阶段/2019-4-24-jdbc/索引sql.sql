#索引 index 
#作用：加快查询速度
#用空间换时间，是dml操作变慢
#可以有多个索引
#聚集索引、普通索引、唯一性索引
DROP TABLE a;
CREATE TABLE a
(
  aid INT,
  aname VARCHAR(20)
)ENGINE=INNODB;

INSERT INTO a VALUES(2,'andy');
INSERT INTO a VALUES(4,'jack');
INSERT INTO a VALUES(3,'leon');

SELECT * FROM a;

ALTER TABLE a
ADD PRIMARY KEY(aid);

CREATE INDEX index_aname
ON a(aname)

#使用
SELECT * FROM a WHERE aname='';

#体现效果：上百万条数据，加索引

#加索引的字段：经常用于查询的字段。
#建议不加索引的字段：取值较少；不经常查询的字段;大字段;

#删除索引
DROP INDEX index_aname ON a;



