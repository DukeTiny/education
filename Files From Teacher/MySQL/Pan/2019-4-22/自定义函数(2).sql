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


#声明变量并赋值
DELIMITER//
CREATE FUNCTION max1(a INT,b INT) RETURNS INT
BEGIN
  DECLARE m INT;
  IF a>b THEN SET m=a;
  ELSE SET m=b;
  END IF;
  RETURN m;
END;//

SELECT max1(5,8);

DELIMITER//
CREATE FUNCTION max2(a INT,b INT) RETURNS INT
BEGIN
  DECLARE m INT;
  CASE
	WHEN a>b THEN SET m=a;
 	ELSE SET m=b;
  END CASE;
  RETURN m;
END;//

SELECT max2(5,8);

DELIMITER//
CREATE FUNCTION sum1() RETURNS INT
BEGIN
  DECLARE n INT;
  DECLARE i INT;
  SET n = 0;
  SET i = 1;
  myloop:LOOP
    SET n=n+i;
    SET i=i+1;
    IF i=11 THEN LEAVE myloop;
    END IF;
  END LOOP;
  RETURN n;
END;//

SELECT sum1();

DELIMITER//
CREATE FUNCTION sum2() RETURNS INT
BEGIN
  DECLARE s INT;
  DECLARE i INT;
  SET s=0;
  SET i=1;
  WHILE i<=10 DO
    SET s=s+i;
    SET i=i+1;
  END WHILE;
  RETURN s;
END;//

SELECT sum2();

DELIMITER//
CREATE PROCEDURE avgdegree(IN n VARCHAR(20),OUT avg1 FLOAT)
BEGIN
  SELECT AVG(degree) FROM score WHERE sno=n;
  SELECT avg1;
END;//

CALL avgdegree('103',@avg1);
SELECT @avg1;