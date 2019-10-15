#存储过程
#带输入参数的存储过程
DELIMITER//
CREATE PROCEDURE in_par(IN n INT)
BEGIN
  SELECT n;
  SET n=3;
  SELECT n;
END;//

SET @m=1;
CALL in_par(@m);
SELECT @m;

#带输出参数的存储过程
DELIMITER//
CREATE PROCEDURE out_par(OUT n INT)
BEGIN
  SELECT n;
  SET n = 5;
  SELECT n;
END;//

SET @m=1;
CALL out_par(@m);
SELECT @m;

#带输入输出参数
DELIMITER//
CREATE PROCEDURE inout_par(INOUT n INT)
BEGIN
  SELECT n;
  SET n=5;
  SELECT n;
END;//

SET @m=1;
CALL inout_par(@m);
SELECT @m;
