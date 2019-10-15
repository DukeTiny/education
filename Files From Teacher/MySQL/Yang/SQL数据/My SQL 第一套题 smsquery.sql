-- 创建学生表
CREATE TABLE student(
	sno varchar(20) PRIMARY KEY, -- 学号
	sname varchar(20) NOT NULL, -- 学生姓名
	ssex varchar(20) NOT NULL, -- 学生性别
	sbirthday datetime, -- 出生日期
	class varchar(20) -- 所在班级
);

-- 创建教师表
CREATE TABLE teacher(
	tno varchar(20) PRIMARY KEY, -- 教师标号
	tname varchar(20) NOT NULL, -- 教师姓名
	tsex varchar(20) NOT NULL, -- 教师性别
	tbirthday datetime, -- 教师出生日期
	prof varchar(20), -- 职称
	depart varchar(20) -- 教师所在部门
);

-- 课程表

CREATE TABLE course(
	cno varchar(20) PRIMARY key, -- 课程编号
	cname varchar(20) NOT NULL,  -- 课程名称
	tno varchar(20) NOT NULL -- 教师编号
	-- FOREIGN key(tno) REFERENCES teacher(tno)
);

-- 添加外键约束

ALTER TABLE course 
ADD CONSTRAINT fk_tno FOREIGN KEY(tno)
REFERENCES teacher(tno);

-- 创建成绩表

CREATE TABLE `score`(
	sno varchar(20) NOT NULL,  -- 学生编号
	cno varchar(20) NOT NULL,  -- 课程编号
	degree DECIMAL(4,1)  -- 成绩
);

-- 添加外键约束

ALTER TABLE `score` 
ADD CONSTRAINT fk_sno FOREIGN KEY(sno)
REFERENCES student(sno);

ALTER TABLE `score`
ADD CONSTRAINT fk_cno FOREIGN key(cno)
REFERENCES course(cno);

-- -------------------------------

-- 向各表中添加数据

-- 向学生表添加数据
INSERT INTO student values('108','曾华','男','1977-09-01','95033');

INSERT INTO student values('105','匡明','男','1975-10-02','95031');
INSERT INTO student values('107','王丽','女','1976-01-23','95033');
INSERT INTO student values('101','李军','男','1976-02-20','95033');
INSERT INTO student values('109','王芳','女','1975-02-10','95031');
INSERT INTO student values('103','陆君','男','1974-06-03','95031');


-- 向教师表添加数据

INSERT INTO teacher values('804','李诚','男','1958-12-02','副教授','计算机系');
INSERT INTO teacher values('856','张旭','男','1969-03-12','讲师','电子工程系');
INSERT INTO teacher values('825','王萍','女','1972-05-05','助教','计算机系');
INSERT INTO teacher values('831','刘冰','女','1977-08-14','助教','电子工程系');

-- 向课程表中添加数据

INSERT INTO course values('3-105','计算机导论','825');
INSERT INTO course values('3-245','操作系统','804');
INSERT INTO course values('6-166','数字电路','856');
INSERT INTO course values('9-888','高等数学','831');

-- 向成绩表中添加数据

INSERT INTO `score` values('103','3-245',86);
INSERT INTO `score` values('105','3-245',75);
INSERT INTO `score` values('109','3-245',68);
INSERT INTO `score` values('103','3-105',92);
INSERT INTO `score` values('105','3-105',88);
INSERT INTO `score` values('109','3-105',76);
INSERT INTO `score` values('101','3-105',64);
INSERT INTO `score` values('107','3-105',91);
INSERT INTO `score` values('108','3-105',78);
INSERT INTO `score` values('101','6-166',85);
INSERT INTO `score` values('107','6-166',79);
INSERT INTO `score` values('108','6-166',81);

SELECT cno,max(degree),avg(degree)
FROM score
group BY cno;

-- 基本单表查询

SELECT * FROM student; -- *代表所有内容

-- 仅查询学生姓名

SELECT sname from student; -- 查询单个字段的值

-- 查询学生生日信息

SELECT sname,sbirthday from student;

-- 不按字段的顺序查询

SELECT class,sname from student;

-- 查询女同学的信息

SELECT * from student WHERE ssex='男'; -- 等值比较的条件

-- 查询所有的班(去掉重复数据)

SELECT DISTINCT class from student; 

SELECT DISTINCT class,sname from student; -- 一般不一起查询其它字段

-- SELECT sname,sbirthday from student;

-- 起别名 内容 as 别名 （as可以不写）

SELECT sname AS '学生姓名',sbirthday AS '学生出生日期' from student;

-- 查询不在95031班的学生的信息

SELECT * from student 
WHERE class != '95031';

-- 查询所有同学的成绩信息

SELECT * from score;

-- 查询及格同学的成绩信息

SELECT * FROM score WHERE degree>=60;

-- 查询成绩在70-80之间的同学的成绩信息

SELECT * from score
WHERE degree=>70 AND degree<=80;

-- 使用between关键字
SELECT * from score
WHERE degree BETWEEN 70 and 80; -- 包括两个端点的值

-- 查询学号为101和108的同学

SELECT * from student
WHERE sno='101' OR sno='108';

-- 查询成绩在90分以上和60分以下的同学成绩信息

SELECT * from score
WHERE degree>=90 OR degree<=60;

-- 使用in关键字替代or的等值比较
SELECT * from student
WHERE sno in('101','108','107','109');

-- 对成绩进行排序

SELECT degree from score
order by degree desc
LIMIT 5,5;

SELECT degree from score
limit 0,10;

-- 模糊查询

SELECT sname from student where sname LIKE '李__';

-- 查询值为空的记录

SELECT * from score
where degree IS NOT NULL;

-- 排序

SELECT * from score
ORDER BY degree desc,sno asc;

-- 先过滤，再排序
SELECT * from score
order by degree desc
where degree>=70;

-- 聚合函数

SELECT max(degree) AS 最高分
FROM score;

SELECT min(degree) AS 最低分
FROM score;

SELECT avg(degree) AS 平均分
FROM score;

SELECT sum(degree) AS 总分
FROM score;

SELECT max(degree),sno
FROM score;
-- 获取记录数

SELECT count(*)
FROM score;

SELECT max(degree),min(degree),avg(degree),sum(degree)
from score;

-- 获取当前的年
SELECT sname 学生姓名,YEAR(now())-YEAR(sbirthday) AS 年龄
FROM student;

SELECT day(sbirthday)
from student;

-- 有条件的聚合

SELECT avg(degree)
FROM score
WHERE degree>=80
order by degree
LIMIT 0,3;  -- 聚合函数的数值范围仅包括where条件后

-- 分组查询

SELECT cno,max(degree),min(degree),avg(degree)
FROM score
GROUP BY cno;

SELECT DISTINCT cno from score;

SELECT sno,cno
FROM score
GROUP BY cno;

SELECT * from score;

-- 求每个学生的总成绩和平均成绩

SELECT sno,cno,avg(degree),sum(degree)
FROM score
group BY sno,cno;

-- 查询参加了补考的同学成绩信息

SELECT sno,cno,avg(degree),sum(degree)
FROM score
WHERE degree>=70
group BY sno,cno
HAVING count(cno)>1;

SELECT cno,avg(degree)
FROM score
WHERE degree>=70
GROUP BY cno,sno

-- 查询成绩在70分以上的各科平均分

SELECT cno,avg(degree)
from score
WHERE degree>=70
GROUP BY cno;

create TABLE a(
	a1 varchar(20),
	b1 varchar(20),
	c1 int
)

INSERT INTO a values('1002','P2' ,70);
INSERT INTO a values('1002','P2' ,60);
INSERT INTO a values('1001','P1' ,100);
INSERT INTO a values('1002','P1' ,80);
INSERT INTO a values('1002','P2' ,90);

SELECT * from a;

SELECT max(c1),a1,b1
from a;


-- **********************************************

-- 1、 查询Student表中的所有记录的Sname、Ssex和Class列。
-- 2、 查询教师所有的单位即不重复的Depart列。
-- 3、 查询Student表的所有记录。
-- 4、 查询Score表中成绩在60到80之间的所有记录。
-- 5、 查询Score表中成绩为85，86或88的记录。
-- 6、 查询Student表中“95031”班或性别为“女”的同学记录。
-- 7、 以Class降序查询Student表的所有记录。
-- 8、 以Cno升序、Degree降序查询Score表的所有记录。
SELECT * 
FROM score
ORDER BY cno ,degree desc;

-- 9、 查询“95031”班的学生人数。

SELECT count(*)
FROM student
where class='95031';

-- 10、查询Score表中的最高分的学生学号和课程号。（子查询或者排序）

SELECT *
FROM score
ORDER BY degree DESC
LIMIT 0,1;

SELECT sno,cno
FROM score
WHERE degree=(
	SELECT max(degree)
	from score
);


-- 查询分数最高的学生的姓名

-- 查询分数最低的学生的课程名称

SELECT cname
FROM course
WHERE cno=(
	SELECT cno
	FROM score
	where degree=(
		SELECT min(degree)
		from score
	)
);

SELECT sname
FROM student
WHERE sno = (SELECT sno
FROM score
WHERE degree=(SELECT max(degree) from score));

SELECT max(degree)
from score;

-- 子查询
SELECT sno
FROM score
WHERE degree=(SELECT max(degree) from score);

-- 11、查询每门课的平均成绩。

SELECT cno,avg(degree)
from score
group by cno;

-- 12、查询Score表中至少有5名学生选修的并以3开头的课程的平均分数。

-- 以3开头的课程

SELECT cno from score WHERE cno like '3%';

SELECT cno,avg(degree)
from score
-- WHERE cno like '3%'
GROUP BY cno
HAVING count(degree)>=5 and cno like '3%';

SELECT avg(degree)
FROM score
WHERE cno in(
	SELECT cno
from score
WHERE cno like '3%'
GROUP BY cno
HAVING count(degree)>=5
);


-- 13、查询分数大于70，小于90的Sno列。

SELECT sno
from score
where degree>70 AND degree<90;

-- 14、查询所有学生的Sname、Cno和Degree列。

SELECT sname,cno,degree
FROM student as s,score as sc
WHERE s.sno=sc.sno;

SELECT sname,cno,degree
FROM student as s INNER JOIN score as sc
ON s.sno=sc.sno;

SELECT DISTINCT sname 
FROM student as s INNER JOIN score as sc
ON s.sno=sc.sno;

-- 15、查询所有学生的Sno、Cname和Degree列。
-- 16、查询所有学生的Sname、Cname和Degree列。

SELECT sname,cname,degree
from student s INNER JOIN score sc INNER JOIN course c
ON s.sno=sc.sno AND sc.cno=c.cno;

-- 17、查询“95033”班学生的平均分。

SELECT sno from student where class='95033'

SELECT avg(degree)
	from score
	where sno in(
		SELECT sno 
		from student 
		where class='95033'
)
-- 18、假设使用如下命令建立了一个grade表：
create table grade(low  int(3),upp  int(3),rank  char(1))
insert into grade values(90,100,'A');
insert into grade values(80,89,'B');
insert into grade values(70,79,'C');
insert into grade values(60,69,'D');
insert into grade values(0,59,'E');
-- 现查询所有同学的Sno、Cno和rank列。

-- 笛卡尔积

SELECT sno,cno,rank
FROM score,grade
WHERE degree BETWEEN low and upp;

-- 19、查询选修“3-105”课程的成绩高于“109”号同学成绩的所有同学的记录。

SELECT degree FROM score WHERE sno='109' AND cno='3-105';

SELECT sno,degree
FROM score
WHERE cno='3-105' AND degree>(
	SELECT degree FROM score WHERE sno='109' AND cno='3-105'
);

-- 20.选了多门课程并且是这个课程下不是最高分的

SELECT *
from score a
WHERE sno in(
	SELECT sno FROM score GROUP BY sno having count(degree)>1
) AND degree<(SELECT max(degree) from score b where a.cno=b.cno) ;


SELECT *
from score
WHERE sno in(
	SELECT sno FROM score GROUP BY sno having count(degree)>1
) AND degree<(SELECT max(degree) from score where cno='3-105') AND cno='3-105';

SELECT *
from score
WHERE sno in(
	SELECT sno FROM score GROUP BY sno having count(degree)>1
) AND degree<(SELECT max(degree) from score where cno='3-245') AND cno='3-245';

SELECT *
from score
WHERE sno in(
	SELECT sno FROM score GROUP BY sno having count(degree)>1
) AND degree<(SELECT max(degree) from score where cno='6-166') AND cno='6-166';

SELECT *
from score
WHERE sno in(
	SELECT sno FROM score GROUP BY sno having count(degree)>1
) AND degree<(SELECT max(degree) from score where cno='9-888') AND cno='9-888';

SELECT sno FROM score GROUP BY sno having count(degree)>1;

SELECT cno,max(degree) from score group by cno;


-- 21、查询成绩高于学号为“109”、课程号为“3-105”的成绩的所有记录。

SELECT * from score where degree>(
SELECT degree from score where sno='109' and cno='3-105') AND cno='3-105';

-- 22、查询和学号为108、101的同学同年出生的所有学生的Sno、Sname和Sbirthday列。

SELECT year(sbirthday)
from student
where sno in('108','101')

SELECT sno,sname,sbirthday
from student
where year(sbirthday) in(
	SELECT year(sbirthday)
	from student
	where sno in('108','101')
) AND sno not in('108','101');

-- 23、查询“张旭“教师任课的学生成绩。

SELECT tno from teacher WHERE tname='张旭';
SELECT cno FROM course where tno = (SELECT tno from teacher WHERE tname='张旭');

SELECT *
FROM score
where cno = (
	SELECT cno 
	FROM course 
	where tno = (
		SELECT tno 
		from teacher 
		WHERE tname='张旭'
	)
);


-- 24、查询选修某课程的同学人数多于5人的教师姓名。

-- 查找课程编号
SELECT cno
FROM score
group by cno
having count(degree)>5;

-- 查找教师编号
SELECT tno
FROM course
where cno in(
	SELECT cno
	FROM score
	group by cno
	having count(degree)>5
);
-- 通过教师编号查找教师姓名

SELECT tname
from teacher
where tno in(
	SELECT tno
	FROM course
	where cno in(
		SELECT cno
		FROM score
		group by cno
		having count(degree)>5
	)
)
-- 25、查询95033班和95031班全体学生的记录。

SELECT cid
FROM `class`
WHERE cname in('95033','95031');

SELECT *
FROM student
where cid in (
	SELECT cid
	FROM `class`
	WHERE cname in('95033','95031')
);

-- 26、  查询存在有85分以上成绩的课程Cno.

SELECT cno,degree
FROM score
WHERE degree>85
GROUP BY cno;
-- having degree>85;
-- 27、查询出“计算机系“教师所教课程的成绩表。

SELECT tno
from teacher
where depart='计算机系';

SELECT cno
FROM course
WHERE tno in(
	
SELECT tno
from teacher
where depart='计算机系'
);

SELECT *
FROM score
WHERE cno in(
	SELECT cno
	FROM course
	WHERE tno in(
		SELECT tno
		from teacher
		where depart='计算机系'
	)
) AND degree is not null;

-- 28、查询“计算 机系”与“电子工程系“不同职称的教师的Tname和Prof。

SELECT tname,prof
FROM teacher
WHERE prof not in(SELECT prof from teacher WHERE depart='计算机系') AND
prof not in(SELECT prof from teacher WHERE depart='电子工程系');

SELECT tname,prof
FROM teacher
WHERE prof not in(SELECT prof from teacher WHERE depart in('计算机系','电子工程系'));

SELECT prof from teacher WHERE depart='计算机系'
-- 29、查询选修编号为“3-105“课程且成绩至少高于选修编号为“3-245”的同学的Cno、Sno和Degree,并按Degree从高到低次序排序。
-- any:代表括号中任意一个成绩就可以

SELECT sno from score WHERE cno='3-105';
SELECT degree from score WHERE cno='3-245';

degree>any(SELECT degree from score WHERE cno='3-245');

SELECT *
from score
where sno in(SELECT sno from score WHERE cno='3-105') 
AND degree>any(
SELECT degree from score WHERE cno='3-245') AND cno='3-105';

-- 30、查询选修编号为“3-105”且成绩高于选修编号为“3-245”课程的同学的Cno、Sno和Degree.
-- all:代表括号中的所有成绩


SELECT sno,degree from score 
	where degree>all(SELECT degree
	FROM score
	where cno='3-245' AND degree is not null) and cno='3-105';

SELECT sno
FROM score
where cno='3-105';

SELECT degree
FROM score
where cno='3-245' AND degree is not null;



where degree>all(SELECT degree
FROM score
where cno='3-245' AND degree is not null)


SELECT *
FROM score
WHERE

-- 31、 查询所有教师和同学的name、sex和birthday.
-- 32、查询所有“女”教师和“女”同学的name、sex和birthday.

-- 33、 查询成绩比该课程平均成绩低的同学的成绩表。
SELECT *
FROM score a
WHERE degree<(
	SELECT avg(degree)
	from score b
	WHERE a.cno=b.cno
) 

-- 34、 查询所有任课教师的Tname和Depart.

SELECT DISTINCT cno
from score;

SELECT tno
FROM course
WHERE cno in(
	SELECT DISTINCT cno
	from score
);

SELECT tname,depart
FROM teacher
WHERE tno in(
	SELECT tno
	FROM course
	WHERE cno in(
		SELECT DISTINCT cno
		from score
	)
);
-- 35 、 查询所有未讲课的教师的Tname和Depart.
-- 36、查询至少有2名男生的班号。

SELECT cid
FROM student
where ssex='男'
GROUP BY cid
HAVING count(*)>=2;
-- 37、查询Student表中不姓“王”的同学记录。

SELECT *
FROM student
WHERE sname NOT LIKE '王%';

-- 38、查询Student表中每个学生的姓名和年龄。

SELECT sname 姓名,year(now())-year(sbirthday) 年龄
from student;

-- 39、查询Student表中最大和最小的Sbirthday日期值。

SELECT max(day(sbirthday)),min(day(sbirthday))
from student;
-- 40、以班号和年龄从大到小的顺序查询Student表中的全部记录。
SELECT year(now())-year(sbirthday) as 年龄,*
from student
ORDER BY cid desc,年龄 desc;

SELECT *,year(now())-year(sbirthday) as 年龄
from student
ORDER BY cid desc,年龄 desc;


-- 41、查询“男”教师及其所上的课程。

SELECT cname
FROM course
where tno in(
	SELECT tno
	FROM teacher
	where tsex='男'
);
-- 42、查询最高分同学的Sno、Cno和Degree列。

SELECT max(degree)
from score;

SELECT *
from score
where degree=(
	SELECT max(degree)
	from score
);
-- 43、查询和“李军”同性别的所有同学的Sname.

SELECT ssex
from student
WHERE sname='李军'

select sname
from student
where ssex in (
	SELECT ssex
	from student
	WHERE sname='李军'
) AND sno not in (
SELECT sno
from student
where sname='李军'
);
-- 44、查询和“李军”同性别并同班的同学Sname.
-- 45、查询所有选修“计算机导论”课程的“男”同学的成绩表。

SELECT cno
from course
where cname='计算机导论';

SELECT sno
FROM student
where ssex='男';

SELECT *
from score
WHERE cno=(
	SELECT cno
	from course
	where cname='计算机导论'
) AND sno in(
	SELECT sno
	FROM student
	where ssex='男'
)
-- 创建class表

CREATE TABLE `class`(
	cid varchar(20) PRIMARY key,
	cname varchar(20) NOT NULL
);

INSERT INTO `class` values('C001','95031');
INSERT INTO `class` values('C002','95032');
INSERT INTO `class` values('C003','95033');

ALTER TABLE student ADD CONSTRAINT fk_cid FOREIGN key(cid) REFERENCES `class`(cid);

-- 查询姓名为'李军'的学生所在班级的名称

SELECT cname,sname
FROM `class` as c,student as s
WHERE c.cid='C001' AND s.sname='李军';

-- 查询所有未参加考试的学生的姓名
SELECT sname
FROM student
WHERE sno NOT in(
	SELECT DISTINCT sno
	from score
);

SELECT sname
FROM student AS st
WHERE NOT EXISTS (
	SELECT sno
	FROM score as sc
	WHERE st.sno=sc.sno
);

-- 查询分数大于80分以上的学生的姓名

SELECT sname
FROM student
where sno in(
	SELECT sno
	from score
	where degree>80
)

-- 查询所有人的姓名、出生日期、性别

SELECT sname,sbirthday,ssex
FROM student
UNION
SELECT tname,tbirthday,tsex
from teacher;

-- 查询所有学生的姓名及班级名称

-- 简单写法
SELECT sname,cname
FROM student as s,`class` as c
WHERE s.cid=c.cid; -- 通过外键匹配过滤

-- 标准写法
-- 内关联查询
SELECT sname,cname
FROM student s INNER JOIN `class` c
ON s.cid=c.cid;

-- 查询考试成绩及其姓名

SELECT sname,degree
FROM student s INNER JOIN score sc
ON s.sno=sc.sno
WHERE degree is not null;

-- 查询参加考试的学生姓名、成绩、课程名称、教师姓名、班级名称

SELECT s.sname,c.cname,sc.degree,co.cname,t.tname
FROM student as s,`class` as c,score AS sc,course as co,teacher as t
WHERE s.sno=sc.sno AND s.cid=c.cid AND t.tno=co.tno AND co.cno=sc.cno;


