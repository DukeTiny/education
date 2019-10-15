#触发器
#当给学员表添加数据时，给班级表人数+1.
DELIMITER//
CREATE PROCEDURE classnum(IN i INT,IN n VARCHAR(20),IN j INT)
BEGIN
  INSERT INTO stu VALUES(i,n,j);
  UPDATE class SET cnum=cnum+1 WHERE cid=j;
END;//

DROP PROCEDURE classnum;

CREATE TABLE stu
(
  sid INT PRIMARY KEY,
  sname VARCHAR(20),
  cid INT
)ENGINE=INNODB;

CREATE TABLE class
(
  cid INT PRIMARY KEY,
  cname VARCHAR(20),
  cnum INT DEFAULT 0
)ENGINE=INNODB;

INSERT INTO class VALUES(2,'蜗牛班',DEFAULT);
SELECT * FROM class;
DELETE FROM class;
DELETE FROM stu;
SELECT * FROM stu;
CALL classnum(2,'leon',1);

INSERT INTO stu VALUES(4,'jack2',1);

#触发器版 new 新增的数据都存在new中 old删除的数据都存在old中
DROP TRIGGER trigger_classnum;
DELIMITER//
CREATE TRIGGER trigger_classnum
BEFORE INSERT #在插入语句前
ON stu 
FOR EACH ROW #行级触发器
BEGIN
  UPDATE class SET cnum=cnum+1 WHERE cid=new.cid;
END;//

#删除学员的时候，修改班级人数-1
DELIMITER//
CREATE TRIGGER trigger_classnum2
BEFORE DELETE #在删除语句前
ON stu 
FOR EACH ROW #行级触发器
BEGIN
  UPDATE class SET cnum=cnum-1 WHERE cid=old.cid;
END;//

DELETE FROM stu WHERE sid=4;

#当学员转班，对原班级人数-1，新班级人数+1
DELIMITER//
CREATE TRIGGER trigger_classnum3
BEFORE UPDATE #在修改语句前
ON stu 
FOR EACH ROW #行级触发器
BEGIN
  UPDATE class SET cnum=cnum-1 WHERE cid=old.cid;
  UPDATE class SET cnum=cnum+1 WHERE cid=new.cid;
END;//

UPDATE stu SET cid=2 WHERE sid=1;

#用户表
CREATE TABLE `userss` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) DEFAULT NULL,
  `add_time` INT(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB;
#日志表
CREATE TABLE `logs` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `log` VARCHAR(255),
  PRIMARY KEY (`Id`)
) ENGINE=INNODB;

#当用户表中新增一个用户，则在日志表添加用户被创建的信息。
DELIMITER//
CREATE TRIGGER trig_logs
BEFORE INSERT
ON userss
FOR EACH ROW
BEGIN
  INSERT INTO LOGS VALUES(NULL,CONCAT(new.name,'is created'));
END;//

INSERT INTO userss VALUES(NULL,'admin',DEFAULT);

SELECT * FROM userss;
SELECT * FROM LOGS;

SHOW TRIGGERS;

#注意 当触发器不使用的时候，就删掉

#before和after的区别:before,可以对新增的数据进行修改，after不行。

SELECT * FROM stu;

SELECT * FROM class;

SHOW TRIGGERS;

DROP TRIGGER trigger_classnum3

DELETE FROM stu

UPDATE class SET cnum=0;

#当添加的学员人数超出班级人数，则将学员添加到临时班
DROP TRIGGER trig_classnum2;
DELIMITER//
CREATE TRIGGER trig_classnum2
BEFORE INSERT
ON stu
FOR EACH ROW
BEGIN
  #获得学员插入的班级人数
  DECLARE n INT DEFAULT 0;
  #判断是否超出，如果超出，设置学员的班级号为临时班的班级号
  SELECT cnum FROM class WHERE cid=new.cid INTO n;
  IF n=2 THEN SET new.cid=3;
  END IF;
  #增加班级人数
  UPDATE class SET cnum=cnum+1 WHERE cid=new.cid;
END;//

INSERT INTO stu VALUES(1,'jack1',1);
INSERT INTO stu VALUES(2,'jack2',1);
INSERT INTO stu VALUES(3,'jack3',1);


