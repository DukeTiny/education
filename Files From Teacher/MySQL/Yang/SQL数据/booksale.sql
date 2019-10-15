DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bookid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `author` varchar(50) NOT NULL,
  `publish` varchar(50) NOT NULL,
  `type` varchar(30) NOT NULL,
  `costprice` float NOT NULL,
  `unitprice` float NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`bookid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '这个历史挺靠谱', '袁小兵', '中国历史出版社', '文学', '51.5', '75', '10');
INSERT INTO `book` VALUES ('2', '上下五千年', '张飞', '清华大学出版社', '文学', '42.5', '66', '20');
INSERT INTO `book` VALUES ('3', '中国经济这点事', '袁腾飞', '中国历史出版社', '经济', '63.5', '85', '15');
INSERT INTO `book` VALUES ('4', 'Python从入门到精通', '张小军', '电子工业出版社', '技术', '55', '75.8', '12');
INSERT INTO `book` VALUES ('5', '旅行到宇宙边缘', '探索频道', '中国地理出版社', '地理', '21.8', '45.5', '30');
INSERT INTO `book` VALUES ('6', '明朝那点事', '吴日昊', '中国海外出版社', '文学', '33', '55', '20');
INSERT INTO `book` VALUES ('7', '哈佛大学的夜晚', '刘小美', '中国海外出版社', '文学', '58', '78.5', '12');
INSERT INTO `book` VALUES ('8', '自动化测试实战', '秦大强', '人民邮电出版社', '技术', '77', '99.8', '18');
INSERT INTO `book` VALUES ('9', '教育心理学实战', '', '中国教育出版社', '教育', '46', '65', '10');
INSERT INTO `book` VALUES ('10', '窗边的小豆豆', '袁飞', '中国历史出版社', '教育', '25', '39.9', '8');
INSERT INTO `book` VALUES ('11', '猫眼看世界', '李小刀', '中国经济出版社', '经济', '52.6', '71.8', '18');
INSERT INTO `book` VALUES ('12', '乌合之众', '袁世军', '中国经济出版社', '管理', '42.8', '59.8', '15');
INSERT INTO `book` VALUES ('13', 'javaEE项目实战', '刘子胜', '电子工业出版社', '技术', '31.5', '45', '12');
INSERT INTO `book` VALUES ('14', '边走边唱', '周世友', '中国历史出版社', '文学', '23.8', '37.5', '11');
INSERT INTO `book` VALUES ('15', '职业经理人的悲哀', '欧阳高', '中国经济出版社', '管理', '38', '55', '10');
INSERT INTO `book` VALUES ('16', '上下', '吴承恩', '人民文学出版社', '文学', '60', '95', null);

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customerid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `address` varchar(50) NOT NULL,
  PRIMARY KEY (`customerid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

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
INSERT INTO `customer` VALUES ('15', '吴大鹏', '18812345678', '郑州');
INSERT INTO `customer` VALUES ('16', '小王', '1111123131', '郑州');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `bookid` int(11) NOT NULL,
  `customerid` int(11) NOT NULL,
  `sellprice` float NOT NULL,
  `sellquantity` float NOT NULL,
  `ordertime` datetime DEFAULT NULL,
  PRIMARY KEY (`orderid`),
  KEY `bookid` (`bookid`),
  KEY `customerid` (`customerid`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`bookid`) REFERENCES `book` (`bookid`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`customerid`) REFERENCES `customer` (`customerid`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('32', '1', '2', '65.8', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('33', '2', '9', '55.3', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('34', '3', '4', '75.8', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('35', '4', '2', '62.5', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('36', '5', '9', '39', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('37', '6', '3', '45.5', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('38', '6', '3', '45.8', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('39', '4', '4', '65.8', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('40', '5', '6', '39.8', '1', '2017-11-02 21:22:25');
INSERT INTO `orders` VALUES ('41', '6', '8', '45.9', '1', '2018-05-02 21:22:25');
INSERT INTO `orders` VALUES ('42', '9', '2', '55.2', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('43', '10', '7', '35', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('44', '12', '11', '55.8', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('45', '12', '11', '55.8', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('46', '2', '8', '55.8', '1', '2018-06-02 21:22:25');
INSERT INTO `orders` VALUES ('47', '2', '5', '55.2', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('48', '5', '6', '37', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('49', '6', '7', '43.8', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('50', '1', '7', '63', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('51', '6', '2', '43.8', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('52', '8', '6', '85.3', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('53', '6', '5', '45', '11', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('54', '3', '9', '75.8', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('55', '5', '7', '36', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('56', '12', '8', '52.8', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('57', '1', '9', '65.8', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('58', '2', '11', '55.7', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('59', '3', '12', '69.8', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('60', '4', '10', '65.2', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('61', '5', '7', '39', '1', '2018-01-02 21:22:25');
INSERT INTO `orders` VALUES ('62', '6', '3', '42.8', '1', '2018-01-02 21:22:25');

-- ----------------------------
-- View structure for view_user
-- ----------------------------
DROP VIEW IF EXISTS `view_user`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `view_user` AS SELECT username,phone
FROM customer 
LIMIT 0,5 ;


-- 查询销售情况最好的前三类图书及对应的销售金额
SELECT book.bookid,type 图书类型,FORMAT(sellprice*sellquantity,2) 销售金额
FROM book,orders
WHERE book.bookid=orders.bookid 
ORDER BY sellprice*sellquantity DESC
Limit 0,3;

-- 查询在本店消费金额最多的前10名客户的姓名和电话
SELECT `username` 用户名,`phone` 电话
FROM `customer`INNER JOIN `orders`
ON customer.customerid=orders.customerid
GROUP BY orders.customerid -- 不可以跟聚合函数
ORDER BY SUM(sellprice*sellquantity) DESC
LIMIT 0,10;

-- 查询2018年第一季度的总的毛利润

SELECT FORMAT(SUM((sellprice-costprice)*sellquantity),2) 毛利润
FROM book,orders
WHERE book.bookid=orders.bookid
AND ordertime between '2018-01-01' AND '2018-03-31';

-- 统计目前每一本图书的进货总量，库存总量和销售总量

SELECT quantity AS 进货总量,(quantity-sellquantity) AS 库存总量,sellquantity AS 销售总量
FROM book,orders
WHERE book.bookid=orders.bookid
ORDER BY sellquantity,库存总量;


-- 请计算平均每本书的毛利润额

SELECT book.bookid,title,FORMAT((sellprice-costprice)*sellquantity,2) 每本书毛利润额
FROM book,orders
WHERE book.bookid=orders.bookid;


SELECT book.bookid,title,FORMAT(SUM((sellprice-costprice)*sellquantity),2) 每本书毛利润额
FROM book,orders
WHERE book.bookid=orders.bookid
GROUP BY book.bookid;











