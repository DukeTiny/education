/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50615
Source Host           : 127.0.0.1:3306
Source Database       : book

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2018-07-14 20:18:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bookid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET gbk NOT NULL,
  `author` varchar(20) CHARACTER SET gbk NOT NULL,
  `publish` varchar(20) CHARACTER SET gbk NOT NULL,
  `type` varchar(10) CHARACTER SET gbk NOT NULL,
  `costprice` float NOT NULL,
  `unitprice` float NOT NULL,
  `quantity` smallint(6) NOT NULL,
  PRIMARY KEY (`bookid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '这个历史挺靠谱', '袁小兵', '中国历史出版社', '文学', '51.5', '75', '10');
INSERT INTO `book` VALUES ('2', '上下五千年', '张飞', '清华大学出版社', '文学', '42.5', '66', '20');
INSERT INTO `book` VALUES ('3', '中国经济这点事', '袁腾飞', '中国历史出版社', '经济', '63.5', '85', '15');
INSERT INTO `book` VALUES ('4', 'Python从入门到精通', '张小军', '电子工业出版社', '技术', '55', '75.8', '12');
INSERT INTO `book` VALUES ('5', '旅行到宇宙边缘', '探索频道', '中国地理出版社', '地理', '21.8', '45.5', '30');
INSERT INTO `book` VALUES ('6', '明朝那点事儿', '吴日昊', '中国海外出版社', '文学', '33', '55', '20');
INSERT INTO `book` VALUES ('7', '哈佛大学的夜晚', '刘小美', '中国海外出版社', '教育', '58', '78.8', '25');
INSERT INTO `book` VALUES ('8', '自动化测试实战', '秦大强', '人民邮电出版社', '技术', '77', '99.8', '18');
INSERT INTO `book` VALUES ('9', '教育心理学实战', '', '中国教育出版社', '教育', '46', '65', '10');
INSERT INTO `book` VALUES ('10', '窗边的小豆豆', '袁飞', '中国历史出版社', '教育', '25', '39.9', '8');
INSERT INTO `book` VALUES ('11', '猫眼看世界', '李小刀', '中国经济出版社', '经济', '52.6', '71.8', '18');
INSERT INTO `book` VALUES ('12', '乌合之众', '袁世军', '中国经济出版社', '管理', '42.8', '59.8', '15');
INSERT INTO `book` VALUES ('13', 'JavaEE项目实战', '刘子胜', '电子工业出版社', '技术', '31.5', '45', '12');
INSERT INTO `book` VALUES ('14', '边走边唱', '周世友', '中国历史出版社', '文学', '23.8', '37.5', '11');
INSERT INTO `book` VALUES ('15', '职业经理人的悲哀', '欧阳高', '中国经济出版社', '管理', '38', '55', '10');

-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customerid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET gbk NOT NULL,
  `phone` varchar(20) CHARACTER SET gbk NOT NULL,
  `address` varchar(50) CHARACTER SET gbk NOT NULL,
  PRIMARY KEY (`customerid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '靳小杰', '18012332323', '上海');
INSERT INTO `customer` VALUES ('2', '刘小畅', '13112345678', '西安');
INSERT INTO `customer` VALUES ('3', '姜小泊', '13212345678', '咸阳');
INSERT INTO `customer` VALUES ('4', '毛小东', '13312345678', '汉中');
INSERT INTO `customer` VALUES ('5', '王小鹏', '15112345678', '成都');
INSERT INTO `customer` VALUES ('6', '文小玉', '15212345678', '重庆');
INSERT INTO `customer` VALUES ('7', '周小钊', '18012345678', '大庆');
INSERT INTO `customer` VALUES ('8', '王小杰', '18112345678', '哈尔滨');
INSERT INTO `customer` VALUES ('9', '何小松', '18212345678', '西安');
INSERT INTO `customer` VALUES ('10', '赵小龙', '18612345678', '成都');
INSERT INTO `customer` VALUES ('11', '张小西', '13512345678', '北京');
INSERT INTO `customer` VALUES ('12', '李小胖', '13812345678', '福州');
INSERT INTO `customer` VALUES ('13', '李大胖', '13522345678', '拉萨');
INSERT INTO `customer` VALUES ('14', '杨小宁', '13033225677', '绵阳');
INSERT INTO `customer` VALUES ('15', '吴大朋', '18812345678', '郑州');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `bookid` int(11) NOT NULL,
  `customerid` int(11) NOT NULL,
  `sellprice` float NOT NULL,
  `sellquantity` smallint(6) NOT NULL,
  `ordertime` datetime DEFAULT NULL,
  PRIMARY KEY (`orderid`),
  KEY `bookid` (`bookid`),
  KEY `customerid` (`customerid`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`customerid`) REFERENCES `customer` (`customerid`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`bookid`) REFERENCES `book` (`bookid`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '1', '2', '65.8', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('2', '2', '9', '55.3', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('3', '3', '4', '75.8', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('4', '4', '2', '65.2', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('5', '5', '9', '39', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('6', '6', '3', '45.5', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('7', '6', '3', '45.8', '1', '2018-04-19 21:22:25');
INSERT INTO `orders` VALUES ('8', '4', '4', '65.8', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('9', '5', '6', '39.8', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('10', '6', '8', '45.9', '1', '2018-05-26 21:22:25');
INSERT INTO `orders` VALUES ('11', '9', '2', '55.2', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('12', '10', '7', '35', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('13', '12', '11', '55.8', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('14', '12', '11', '55.8', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('15', '2', '8', '55.8', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('16', '2', '5', '55.2', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('17', '5', '6', '37', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('18', '6', '7', '43.8', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('19', '1', '7', '63', '1', '2018-03-02 21:22:25');
INSERT INTO `orders` VALUES ('20', '6', '2', '43.8', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('21', '8', '6', '85.3', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('22', '6', '5', '45', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('23', '3', '9', '75.8', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('24', '5', '7', '36', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('25', '12', '8', '52.8', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('26', '1', '9', '65.8', '1', '2018-04-02 21:22:25');
INSERT INTO `orders` VALUES ('27', '2', '11', '55.7', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('28', '3', '12', '69.8', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('29', '4', '10', '65.2', '1', '2018-01-18 21:22:25');
INSERT INTO `orders` VALUES ('30', '5', '7', '39', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('31', '6', '3', '42.8', '1', '2018-01-02 21:22:25');

-- 1.查询销售情况最好的前三类图书及对应的销售金额

SELECT b.type,sum(o.sellquantity) selltotal,format(sum(o.sellprice*o.sellquantity),2) sumprice
FROM book b,orders o
WHERE b.bookid=o.bookid
GROUP BY b.type
ORDER BY selltotal DESC
LIMIT 0,3;

-- 2.查询在本店消费金额最多的前10名客户的姓名和电话

SELECT o.customerid,FLOOR(sum(o.sellprice*o.sellquantity)) sumprice,c.username,c.phone
FROM customer c,orders o
WHERE c.customerid=o.customerid
GROUP BY o.customerid
ORDER BY sumprice DESC
LIMIT 10;

-- 3.查询2018年一季度的毛利润

SELECT format(sum((o.sellprice-b.costprice)*o.sellquantity),2) as 2018年一季度毛利润
FROM orders o,book b
WHERE o.bookid=b.bookid AND ordertime BETWEEN '2018-01-01' AND '2018-03-31';


-- 统计目前每一本图书的进货总量，库存数量和销售数量

SELECT DISTINCT bookid
FROM orders;

SELECT b.bookid,b.title,b.quantity 进货量,(b.quantity-sum(o.sellquantity)) 库存数量,sum(o.sellquantity) 销售数量
FROM book b LEFT JOIN orders o
ON b.bookid=o.bookid
GROUP BY b.bookid;

-- 查找没有卖过的书
SELECT bookid
FROM book 
WHERE bookid not in(
	SELECT DISTINCT bookid
	from orders
);

-- 计算平均每本书的毛利润

SELECT b.bookid,format((sum(o.sellprice*o.sellquantity)-b.costprice*sum(o.sellquantity))/sum(o.sellquantity),2) AS avgprofit
FROM book b,orders o
WHERE b.bookid=o.bookid
GROUP BY o.bookid;

SELECT b.bookid,format(avg(o.sellprice-b.costprice),2) AS avgprofit
FROM book b,orders o
WHERE b.bookid=o.bookid
GROUP BY o.bookid;


-- --------------------

-- 用户变量

set @sname='张三丰';

SELECT @sname;

-- 查看全局系统变量
show GLOBAL VARIABLES;

-- 查看会话系统变量
show session variables;

-- 创建存储过程

CREATE PROCEDURE pro_test01()
BEGIN
	DECLARE sname varchar(20);   -- 声明局部变量：declare 变量名 数据类型;
	SET sname='张三丰';   
	SELECT sname;
END


-- 调用存储过程
CALL pro_test01();


SELECT quantity from book where bookid=2;

CREATE PROCEDURE pro_book01()
BEGIN
	DECLARE book_quantity int;
	-- 通过表的查询结果给变量赋值。不能将多个值赋值给1个变量
	SELECT quantity INTO book_quantity FROM book WHERE bookid=2;
	SELECT book_quantity;
END

-- 删除存储过程
DROP PROCEDURE pro_book01;

CALL pro_book01;

-- 通过存储过程查询6这本书的库存

DROP procedure pro_store;
CREATE PROCEDURE pro_store(bid int)
BEGIN
	DECLARE book_quantity int;
	DECLARE book_sell int;
	DECLARE book_store int;
	
	SELECT quantity into book_quantity from book where bookid=bid;
	SELECT sum(sellquantity) INTO book_sell from orders WHERE bookid=bid;
	IF book_sell IS NULL THEN
		SET book_sell = 0;
	END IF;
	SET book_store = book_quantity - book_sell;
	SELECT book_store;
end

CALL pro_store(7);

SELECT title from book where bookid=10;

DROP PROCEDURE pro_bookname;
CREATE PROCEDURE pro_bookname(bid int)
BEGIN
	DECLARE bname varchar(20);
	CASE bid 
		WHEN 1 THEN set bname="这个历史挺靠谱";
		WHEN 2 THEN set bname="上下五千年";
		WHEN 3 THEN set bname="中国经济这点事";
	else
		BEGIN
			SET bname="没有这本书";
		END;
	END CASE;
	SELECT bname;
END

CALL pro_bookname(20);

-- repeat循环
CREATE PROCEDURE pro_repeat(in num int)
BEGIN
	DECLARE i int default 0;
	REPEAT
		SET i= i+1;
		UNTIL i>num
	END REPEAT;
	SELECT i;
END

CALL pro_repeat(5);

create PROCEDURE testITERATE(p int)
BEGIN
  outw:while(true) DO
    set p=p+1;
    if(p=5) THEN
      ITERATE outw;
      ELSEIF (p=10) THEN
          LEAVE outw;
    END IF;
    SELECT p;
  end WHILE outw;
END

CALL testITERATE(1);

CREATE PROCEDURE pro_outtest(OUT ot int)
BEGIN
	SELECT max(unitprice) INTO ot FROM book;
END

DROP PROCEDURE pro_outtest;
SET @ot=0;
call pro_outtest(@ot);
SELECT @ot;

SELECT count(*) from book;

CREATE FUNCTION fun_add(a int,b int)
RETURNS INT   -- 返回值的返回类型
BEGIN
	DECLARE c int;
	SET c = a + b;
	return c;
END

SELECT fun_add(3,5) AS 和;

-- 通过函数求x的y次方；

DROP FUNCTION fun_power;
CREATE FUNCTION fun_power(x int, y int)
RETURNS FLOAT
BEGIN
	DECLARE result FLOAT default 1;
	
	-- 指数如果小于0
	if y<0 THEN
		set y = 0-y;  -- 变成正数
		WHILE y>0 DO
			SET result = result*x;
			SET y = y - 1;
		END WHILE;
		set result = 1/result;	
	ELSE
		WHILE y>0 DO
			SET result = result*x;
			SET y = y - 1;
		END WHILE;
	END IF;
	RETURN result; -- 返回最终结果
END

SELECT fun_power(2,-3);

SELECT concat("hello","world");

SELECT CONCAT_WS("_","I","am","好人");


SELECT trim("   admin   ");

SELECT *,uuid() from book;

-- 仅复制表结构
CREATE table book_bak LIKE book;

CREATE TRIGGER tri_book
BEFORE DELETE ON book for EACH ROW
BEGIN
	INSERT INTO book_bak values(old.bookid,old.title,old.author,old.publish,old.type,old.costprice,old.unitprice,old.quantity);
END

DELETE from book WHERE bookid=16;

-- 异常处理

CREATE PROCEDURE exp_pro_demo(IN bid int)
BEGIN
	DECLARE vtitle VARCHAR(20) DEFAULT "java开发";  
  DECLARE EXIT HANDLER FOR NOT FOUND SET @info='没有这本书';
	SELECT title INTO vtitle from book where bookid = bid;
  SELECT vtitle;
END

DROP PROCEDURE exp_pro_demo;
CALL exp_pro_demo(20);
SELECT @info;

-- 游标

CREATE PROCEDURE pro_book2(bid int)
BEGIN
	DECLARE v_var varchar(20);
	declare
	SELECT * into v_var from book where bookid=bid;
END

-- 通过游标显示所有的图书的名称

SELECT title FROM book 

CREATE PROCEDURE pro_cur_book()
BEGIN
	DECLARE vtitle varchar(20);
	DECLARE break INT DEFAULT FALSE;
	-- 声明游标
	DECLARE cur_title CURSOR FOR SELECT title FROM book; 
	DECLARE CONTINUE HANDLER FOR NOT Found set break=true;
	
	-- 打开游标
	OPEN cur_title;
	
	outwhile: WHILE TRUE DO
-- 将游标中存储的数据提取到变量中
		FETCH cur_title INTO vtitle;
		IF break THEN
			LEAVE outwhile;
		ELSE
			SELECT vtitle;
		END IF;
	END WHILE outwhile;
	-- 关闭游标
	CLOSE cur_title;
END

CALL pro_cur_book;

-- 将quantity大于等于20的记录存放在book_more,小于20的存放在book_less表中

ALTER TABLE book MODIFY COLUMN title varchar(30) UNIQUE;

SELECT * from book;

DROP PROCEDURE pro_book3
CREATE PROCEDURE pro_book3()
BEGIN
	INSERT INTO book values('55', '测试d', '秦大强', '人民邮电出版社', '技术', '77', '99.8', '18');
	commit;
	SAVEPOINT mysave;
	INSERT INTO book values('56', '测试d', '秦大强', '人民邮电出版社', '技术', '77', '99.8', '18');
	INSERT INTO book values('56', '测试d', '秦大强', '人民邮电出版社', '技术', '77', '99.8', '18');
	ROLLBACK to mysave;
	RELEASE SAVEPOINT mysave;
	commit;
END

SET @@AUTOCOMMIT=OFF;
CALL pro_book3;

-- -----------------------

-- 视图

SELECT bookid from orders;

SELECT publish,count(quantity) from book
WHERE bookid in(
	SELECT bookid from orders
)
GROUP BY publish
;

-- 通过对表的查询获得结果集，起一个表的名字，在此基础上的查询可以提高查询效率。视图

CREATE view view_book01 AS SELECT title,costprice,quantity FROM book;

-- 将视图当做表来使用

-- 对视图的查询与普通表没有任何区别；
SELECT * from view_book01;
SELECT costprice from view_book01;

-- 添加一条视图的记录
INSERT INTO view_book01 values('西游记',80,20);

-- 删除一条视图的记录

DELETE FROM view_book01 where title='这个历史挺靠谱';

-- 在视图之上创建新的视图

create view view_test AS SELECT title FROM view_book01;

-- 关联查询的结果做为视图

CREATE view view_books AS
SELECT b.title,b.author,o.sellprice,o.ordertime,c.username
FROM book b,orders o,customer c
WHERE b.bookid=o.bookid AND o.customerid=c.customerid
order by o.sellprice;

SELECT *
FROM orders
order BY sellprice desc;

-- 索引

SELECT * from book;

ALTER TABLE orders ADD INDEX ind_sellprice(sellprice);












