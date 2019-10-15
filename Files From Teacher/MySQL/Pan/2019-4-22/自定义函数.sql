#建学生信息表student
CREATE TABLE student
(
sno VARCHAR(20) NOT NULL PRIMARY KEY,
sname VARCHAR(20) NOT NULL,
ssex VARCHAR(20) NOT NULL,
sbirthday DATETIME,
class VARCHAR(20)

);
#建立教师表
CREATE TABLE teacher
(
tno VARCHAR(20) NOT NULL PRIMARY KEY,
tname VARCHAR(20) NOT NULL,
tsex VARCHAR(20) NOT NULL,
tbirthday DATETIME,
prof VARCHAR(20),
depart VARCHAR(20) NOT NULL

);
#建立课程表course
CREATE TABLE course
(
cno VARCHAR(20) NOT NULL PRIMARY KEY,
cname VARCHAR(20) NOT NULL,
tno VARCHAR(20) NOT NULL,
FOREIGN KEY(tno) REFERENCES teacher(tno)

);
#建立成绩表
CREATE TABLE score
(
sno VARCHAR(20) NOT NULL PRIMARY KEY,
FOREIGN KEY(sno) REFERENCES student(sno),
cno VARCHAR(20) NOT NULL,
FOREIGN KEY(cno) REFERENCES course(cno),
degree DECIMAL

);

#添加学生信息
INSERT INTO student VALUES('108','曾华','男','1977-09-01','95033');
INSERT INTO student VALUES('105','匡明','男','1975-10-02','95031');
INSERT INTO student VALUES('107','王丽','女','1976-01-23','95033');
INSERT INTO student VALUES('101','李军','男','1976-02-20','95033');
INSERT INTO student VALUES('109','王芳','女','1975-02-10','95031');
INSERT INTO student VALUES('103','陆君','男','1974-06-03','95031');




#添加教师表
INSERT INTO teacher VALUES('804','李诚','男','1958-12-02','副教授','计算机系');
INSERT INTO teacher VALUES('856','张旭','男','1969-03-12','讲师','电子工程系');
INSERT INTO teacher VALUES('825','王萍','女','1972-05-05','助教','计算机系');
INSERT INTO teacher VALUES('831','刘冰','女','1977-08-14','助教','电子工程系');

#添加课程表
INSERT INTO course VALUES('3-105','计算机导论','825');
INSERT INTO course VALUES('3-245','操作系统','804');
INSERT INTO course VALUES('6-166','数字电路','856');
INSERT INTO course VALUES('9-888','高等数学','831');
#添加成绩表

INSERT INTO score VALUES('103','3-245','86');
INSERT INTO score VALUES('105','3-245','75');
INSERT INTO score VALUES('109','3-245','68');
INSERT INTO score VALUES('103','3-105','92');
INSERT INTO score VALUES('105','3-105','88');
INSERT INTO score VALUES('108','3-105','76');
INSERT INTO score VALUES('103','9-888','64');
INSERT INTO score VALUES('101','9-888','91');
INSERT INTO score VALUES('109','9-888','78');
INSERT INTO score VALUES('103','6-166','85');
INSERT INTO score VALUES('105','6-166','79');
INSERT INTO score VALUES('109','6-166','81');

SELECT * FROM student;

#函数 已经写好的工具

DELIMITER $$

CREATE
    /*[DEFINER = { user | CURRENT_USER }]*/
    FUNCTION `demo`.`abc`()
    RETURNS VARCHAR(20)
    /*LANGUAGE SQL
    | [NOT] DETERMINISTIC
    | { CONTAINS SQL | NO SQL | READS SQL DATA | MODIFIES SQL DATA }
    | SQL SECURITY { DEFINER | INVOKER }
    | COMMENT 'string'*/
    BEGIN
	#sql语句
    END$$

DELIMITER ;

#创建一个无参的函数
DELIMITER $$
CREATE FUNCTION nopar() RETURNS VARCHAR(100)
BEGIN
	RETURN 'hello mysql function world!';
END$$
DELIMITER ;

DROP FUNCTION nopar;

SELECT nopar();
DROP FUNCTION getSnameBysid;

DELIMITER//
CREATE FUNCTION getSnameBySid() RETURNS VARCHAR(120)
BEGIN
  DECLARE c VARCHAR(120);
  SELECT sname FROM student WHERE sno='101' INTO c;
  RETURN c;
END;//

SELECT getSnameBySid();

DELIMITER//
CREATE FUNCTION getbirth() RETURNS DATETIME
BEGIN
	DECLARE d DATETIME;
	SELECT sbirthday FROM student WHERE sname='李军' INTO d;
	RETURN d;
END;//

SELECT getbirth();

DELIMITER//
CREATE FUNCTION getbirth2(NAME VARCHAR(20)) RETURNS DATETIME
BEGIN
	DECLARE d DATETIME;
	SELECT sbirthday FROM student WHERE sname=NAME INTO d;
	RETURN d;
END;//

SELECT getbirth2('陆君');

SHOW CREATE FUNCTION getbirth2;

FUNCTION	sql_mode	
CREATE FUNCTION getbirth2		
CREATE DEFINER=`root`@`localhost` FUNCTION `getbirth2`(NAME VARCHAR(20)) RETURNS DATETIME
BEGIN
	DECLARE d DATETIME;
	SELECT sbirthday FROM student WHERE sname=NAME INTO d;
	RETURN d;
END


DELIMITER//
CREATE FUNCTION funName([parName TYPE(LENGTH)],) RETURNS TYPE(LENGTH)
BEGIN
  [DECLARE varName TYPE(LENGTH)];
  [SQL]
  RETURN varName;
END;//








