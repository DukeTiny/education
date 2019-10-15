SELECT * FROM card;

#求出银行卡表中，所有的卡的金额和
DELIMITER//
CREATE PROCEDURE test_cursor2()
BEGIN
  #每行记录中金额存储变量
  DECLARE m DECIMAL(20,2) DEFAULT 0;
  #求和变量
  DECLARE sum1 DECIMAL(20,2) DEFAULT 0;
  #获取状态的变量
  DECLARE state1 DECIMAL(20,2) DEFAULT 0;
  #声明游标
  DECLARE cmoney_cursor CURSOR FOR SELECT cmoney FROM card;
  #声明异常出现后状态变量的操作
  DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET state1=-1;
  #打开游标
  OPEN cmoney_cursor;
  #使用游标：向下移动游标，并将每行记录的数据存储到变量中
  FETCH cmoney_cursor INTO m;
  #循环 条件为游标没有运行到最后一行之后
  WHILE state1!=-1 DO
    #将每行记录的金额累加到变量中
    SET sum1=sum1+m;
    #使用游标：向下移动游标，并将每行记录的数据存储到变量中
    FETCH cmoney_cursor INTO m;
  END WHILE;
  #关闭游标
  CLOSE cmoney_cursor;
  #输出求和变量
  SELECT sum1;
END;//

CALL test_cursor2();