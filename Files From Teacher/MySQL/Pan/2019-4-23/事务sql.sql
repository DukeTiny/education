#事务
#事务的特性ACID 原子性，一致性，隔离性，持久性
#开始事务
START TRANSACTION
#提交事务
COMMIT;
#回滚事务
ROLLBACK;
SELECT * FROM card;

#编写一个转账的存储过程。
DELIMITER//
CREATE PROCEDURE proc_trans(IN mycno INT,IN othercno INT,IN m DECIMAL(20,2))
BEGIN
  DECLARE n DECIMAL(20,2) DEFAULT 0;
  START TRANSACTION;
  #将转账金额修改给对方账户
  UPDATE card SET cmoney=cmoney+m WHERE cno=othercno;
  SELECT cmoney FROM card WHERE cno=mycno INTO n;
  #将转账金额从自己的账户减去
  UPDATE card SET cmoney=cmoney-m WHERE cno=mycno;
  #账户金额》=转账金额提交，否则回滚
  IF n>=m THEN COMMIT;
  ELSE ROLLBACK;
  END IF;
END;//

CALL proc_trans(1001,1002,1000);