CREATE DATABASE school;
USE school;
# 1、创建学生表（学号、姓名、性别、生日、班级号）和班级表(班级号、班级名称、班级人数)。5分

CREATE TABLE stu
(
    sno INT,
    sname VARCHAR(20),
    sgender CHAR(2),
    sbirth DATE,
    cno INT
) ENGINE=INNODB;

CREATE TABLE class
(
    cno INT,
    cname VARCHAR(20),
    cnum INT
) ENGINE=INNODB;


# 2、给每个表追加主键。5分
ALTER TABLE stu ADD CONSTRAINT pk_stu_sno PRIMARY KEY(sno);
ALTER TABLE class ADD CONSTRAINT pk_class_cno PRIMARY KEY(cno);

# 3、给学生表的班级号追加外键。5分
ALTER TABLE stu ADD CONSTRAINT fk_stu_sno FOREIGN KEY (cno) REFERENCES class(cno);

# 4、给班级人数设置默认值为0. 5分
ALTER TABLE class ALTER cnum SET DEFAULT 0;

# 5、在学生表中添加电话列 phone varchar（11）。5分
ALTER TABLE stu ADD COLUMN phone VARCHAR(11);

# 6、修改学生表中的电话列 phoneNum char（11）。5分
ALTER TABLE stu CHANGE  phone  phoneNum char(11);

# 7、查询所有1996年出生男生的学生信息。 5分
SELECT * FROM stu WHERE YEAR(sbirth)=1996 AND sgender='男';

# 8、查询姓张的学生信息。 5分
SELECT * FROM stu WHERE sname LIKE '张%';

# 9、查询1994、1996、2000年出生学生的姓名、生日、出生年份。5分
SELECT sname,sbirth,YEAR(sbirth) FROM student WHERE YEAR(sbirth) IN ('1994','1996','2000');

# 10、查询向日葵班所有学生的姓名、性别、生日、班级名。5分
SELECT sname,sgender,sbirth,stu.cno FROM stu LEFT JOIN class ON stu.cno=class.cno WHERE cname='向日葵班';

# 11、查询每个班级的人数。5分
SELECT cname,cnum FROM class;

# 12、学生表按生日升序查询所有学员信息。5分
SELECT * FROM stu ORDER BY sbirth ASC;

# 13、取出学生表中第2到第8行数据显示。5分
SELECT  * FROM stu LIMIT 1,7;

# 14、使用左外连接、右外连接、全外连接显示学生表和班级表的信息。5分
    -- 左外链接
        SELECT * FROM stu LEFT JOIN class ON stu.cno=class.cno;
    -- 右外连接
        SELECT * FROM stu RIGHT JOIN class ON stu.cno=class.cno;
    -- 全外连接
        SELECT * FROM stu LEFT JOIN class ON stu.cno=class.cno;
        UNION
        SELECT * FROM stu RIGHT JOIN class ON stu.cno=class.cno;

# 15、编写存储过程，班级名称作为输入参数，输出该班级年级最大的学员姓名。10分

    -- DIMILITER在新版本不可使用，这里就不写了
    CREATE PROCEDURE getMaxAgeByCno(IN cno INT)
    BEGIN
        DECLARE stuName VARCHAR(20);
        SELECT sname FROM stu WHERE (YEAR(NOW())-YEAR(sbirth))=(SELECT MAX(YEAR(NOW())-YEAR(sbirth)) FROM stu) INTO stuName;
        SELECT stuName; 
    END;
    

# 16、创建视图显示学员姓名、学员生日和班级名称。5分
CREATE VIEW stu_view AS SELECT sname,sbirth,cname FROM stu LEFT JOIN class ON stu.cno=class.cno;

# 17、给学生姓名创建普通索引。 5分
CREATE INDEX sname_index ON stu(sname);

# 18、创建一个触发器，实现学生表添加数据，班级人数进行对应修改。 10分
CREATE TRIGGER addCnum 
BEFOR INSERT ON stu FOR EACH ROW
BEGIN
    UPDATE class SET cnum=cnum+1 WHERE cno=new.cno;
END;