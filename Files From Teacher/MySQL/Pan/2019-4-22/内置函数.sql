#mysql内置函数
#字符串
LENGTH() 计算字符串的长度
SELECT LENGTH('你好');
TRIM()   去左右空格
SELECT CONCAT(TRIM('  ab  c   '),'aa');
SELECT CONCAT(LTRIM('   abc   '),'**');
SELECT CONCAT(RTRIM('   abc   '),'**');

UPPER() LOWER() 转大写，小写字母
SELECT UPPER('abc');
SELECT LOWER('ABC');
注意，数据库中，拼接字符串不是用”+”, 而是用一个函数：
CONCAT()
SUBSTRING() 截取字符串  
有3个参数
1参数，被截取的字符串
2参数，从哪开始（下标从1开始）
3参数，表示截取几位（而不是像java一样，表示截取到哪一位）。
SELECT SUBSTRING('abcdef',4,2);
SELECT SUBSTRING('你好么',1,3);
LEFT() 
SELECT LEFT('张三',3);
RIGHT()
SELECT RIGHT('张三',3);

#数学
ABS() 绝对值
ROUND() 四舍五入. 如果只传一个参数，默认进到整数，如果传第二个参数，第二个参数指明保留几位小数。
RAND () 随机数函数， [0,1)
FLOOR() 向下取整
CEIL() 向上取整
POW() 计算几的几次方

SELECT ABS(-5);
SELECT ROUND(3.85,1); //ROUND(X) 四舍五入到整数位  ROUND(X,d)四舍五入x数到小数点后第d位
SELECT RAND(); //RAND()取大于等于0，小于1的小数。 RAND(X)按照x作为种子随机一个数字
SELECT FLOOR(3.4);
SELECT CEIL(3.4);
SELECT POW(2,3);
 
#日期
NOW() 获取当前系统时间
SELECT NOW();	获得了年月日小时分钟秒
SELECT CURTIME();	获得了小时分钟秒
SELECT CURDATE();	获得年月日
提取年月日小时分秒
YEAR() MONTH() DAY() HOUR() MINUTE() SECOND().
SELECT YEAR(NOW());
SELECT MONTH(NOW());
SELECT DAY(NOW());
SELECT HOUR(NOW());
SELECT MINUTE(NOW());
SELECT SECOND(NOW());
日期差:
DATEDIFF() 
SELECT DATEDIFF('2016-4-22','2018-4-20');
增加日期 ：
DATE_ADD()
SELECT DATE_ADD('2019-4-22',INTERVAL 1 YEAR);