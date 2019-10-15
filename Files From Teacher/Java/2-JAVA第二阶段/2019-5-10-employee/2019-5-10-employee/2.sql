/*Table structure for table `dept` */

DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
  `DEPTNO` int(11) NOT NULL,
  `DNAME` varchar(14) default NULL,
  `LOC` varchar(13) default NULL,
  PRIMARY KEY  (`DEPTNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dept` */

insert  into `dept`(`DEPTNO`,`DNAME`,`LOC`) values (10,'ACCOUNTING','NEW YORK'),(20,'RESEARCH','DALLAS'),(30,'SALES','CHICAGO'),(40,'OPERATIONS','BOSTON');

/*Table structure for table `emp` */

DROP TABLE IF EXISTS `emp`;

CREATE TABLE `emp` (
  `EMPNO` int(11) NOT NULL,
  `ENAME` varchar(10) default NULL,
  `JOB` varchar(9) default NULL,
  `MGR` int(11) default NULL,
  `HIREDATE` date default NULL,
  `SAL` decimal(7,2) default NULL,
  `COMM` decimal(7,2) default NULL,
  `DEPTNO` int(11) default NULL,
  PRIMARY KEY  (`EMPNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `emp` */

insert  into `emp`(`EMPNO`,`ENAME`,`JOB`,`MGR`,`HIREDATE`,`SAL`,`COMM`,`DEPTNO`) values (7369,'SMITH','CLERK',7902,'1984-05-05',800.00,NULL,20),(7499,'ALLEN','SALESMAN',7698,'1983-05-05',1600.00,300.00,30),(7521,'WARD','SALESMAN',7698,'1984-06-05',1250.00,500.00,30),(7566,'JONES','MANAGER',7839,'1990-10-05',2975.00,NULL,20),(7654,'MARTIN','SALESMAN',7698,'1982-07-20',1250.00,1400.00,30),(7698,'BLAKE','MANAGER',7839,'1984-05-05',2850.00,NULL,30),(7782,'CLARK','MANAGER',7839,'1984-05-06',2450.00,NULL,10),(7788,'SCOTT','ANALYST',7566,'1984-05-07',3000.00,NULL,20),(7839,'KING','PRESIDENT',NULL,'1984-05-08',5000.00,NULL,10),(7844,'TURNER','SALESMAN',7698,'1984-05-09',1500.00,0.00,30),(7876,'ADAMS','CLERK',7788,'1984-05-10',1100.00,NULL,20),(7900,'JAMES','CLERK',7698,'1984-05-11',950.00,NULL,30),(7902,'FORD','ANALYST',7566,'1984-05-12',3000.00,NULL,20),(7934,'MILLER','CLERK',7782,'1984-05-13',1300.00,NULL,10),(8001,'andy','salesman',7698,'2019-05-10',5000.00,500.00,30);

