-- dual is a virtual table
-- completly optional in mysql
SELECT NOW();
SELECT NOW() FROM DUAL;

--using help
HELP FUNCTIONS;
HELP NUMERIC FUNCTIONS;
HELP POW

SELECT POW(3,3);

SELECT ROUND(123.45);
SELECT ROUND(123.65);
SELECT ROUND(123.24,1);
SELECT ROUND(123.25,1);

SELECT ROUND(123.24,2);
SELECT ROUND(123.56,2);

-- display only the price from the books table 
-- where the price should have only 2 digits after the decimal
SELECT ROUND(price,2) FROM books;

SELECT ROUND(price,2) AS price FROM books;

SELECT ROUND(123,-1);
SELECT ROUND(157,-1);

SELECT ROUND(123,-2);
SELECT ROUND(157,-2);

HELP CEILING;
--Returns the smallest integer value not less than X.
SELECT CEIL(1.34);
-- X = 1.34 Generated value(gv)=2
-- gv > x; (gv is not less than x) 

HELP FLOOR;
SELECT FLOOR(1.34);
--Returns the largest integer value not greater than X.
-- X = 1.34 Generated value(gv)= 1
-- gv < x; (gv is not greater than x) 

-- String Fuunctions
HELP STRING FUNCTIONS;
HELP CONCAT;

SELECT CONCAT('sunbeam','-','infotech');

-- display empno - empname from emp table
SELECT CONCAT(empno,'-',ename) AS details FROM emp;

-- ename is working as job in dept deptno
-- eg -> SMITH is working as CLERK in dept 20
SELECT CONCAT(ename,' is working as ',job,' in dept ',deptno) AS details FROM emp;

HELP LOWER;
SELECT LOWER('QUADRATICALLY');

HELP UPPER;
SELECT UPPER('Hej');

-- display all the enames and jobs in small case
SELECT LOWER(ename) ename, LOWER(job) job FROM emp;

-- display all the subjects in upper case
SELECT upper(subject) subject FROM books; 

HELP LEFT;
SELECT LEFT('sunbeam',1);
SELECT LEFT('sunbeam',3);

HELP RIGHT;
SELECT RIGHT('sunbeam',1);
SELECT RIGHT('sunbeam',3);

-- display all the initial letter of the emp name.
SELECT LEFT(ename,1) initial FROM emp;

-- display all the emps whose first letter of name falls in the range of B and 
SELECT * FROM emp WHERE LEFT(ename,1) BETWEEN 'B' AND 'J';

HELP SUBSTRING;
SELECT SUBSTRING('Quadratically',5);
SELECT SUBSTRING('foobarbar' FROM 4);

SELECT SUBSTRING('Quadratically',5,6);
SELECT SUBSTRING('Sakila', -3);
SELECT SUBSTRING('Sakila', -5, 3);
SELECT SUBSTRING('Sakila' FROM -4 FOR 2);

HELP LENGTH;

HELP TRIM;

HELP LPAD;

HELP RPAD;

-- dispay the credit card number like below
-- XXXXXXXX1234
-- i/P -> 8365
SELECT LPAD('8365',12,'X');

-- display the mobile no as below
-- mob=8983049388
-- 89XXXXXX88

SELECT CONCAT(LEFT('8983049388',2),'XXXXXX',RIGHT('8983049388',2)) AS mob;

SELECT RPAD(RPAD(LEFT('8983049388',2),8,'X'),10,RIGHT('8983049388',2)) AS mob;

-- display ***sunbeam***
SELECT LPAD(RPAD('sunbeam',10,'*'),13,'*');

SELECT RPAD(LPAD('sunbeam',10,'*'),13,'*');

-- Date and Time functions
SELECT NOW();

SELECT SYSDATE();

SELECT NOW(),SLEEP(2),NOW();
SELECT SYSDATE(),SLEEP(2),SYSDATE();

SELECT DATE('2024-11-18 17:00:39');
SELECT TIME('2024-11-18 17:00:39');

SELECT DATE(NOW());
SELECT TIME(NOW());

SELECT ADDDATE(NOW(),INTERVAL 2 DAY);
SELECT DATE_ADD(NOW(),INTERVAL 2 DAY);

SELECT ADDDATE(NOW(),2);
SELECT DATE_ADD(NOW(),2);

SELECT DATE_ADD('2018-05-01',INTERVAL 1 DAY);
-> '2018-05-02'

SELECT DATE_ADD('2020-12-31 23:59:59',INTERVAL 1 SECOND);
-> '2021-01-01 00:00:00'

SELECT DATE_ADD('2018-12-31 23:59:59',INTERVAL 1 DAY);
-> '2019-01-01 23:59:59'

SELECT DATE_ADD('2100-12-31 23:59:59',INTERVAL '1:1' MINUTE_SECOND);
-> '2101-01-01 00:01:00'

SELECT DATE_ADD('1900-01-01 00:00:00',INTERVAL '-1 10' DAY_HOUR);
-> '1899-12-30 14:00:00'

SELECT DATE_ADD('1992-12-31 23:59:59.000002',INTERVAL '1.999999' SECOND_MICROSECOND);
-> '1993-01-01 00:00:01.000001'

-- DATE_SUB
SELECT DATE_SUB('2025-01-01 00:00:00',INTERVAL '1 1:1:1' DAY_SECOND);
-> '2024-12-30 22:58:59'

SELECT DATE_SUB('1998-01-02', INTERVAL 31 DAY);
-> '1997-12-02'

SELECT DATE_SUB('2018-05-01',INTERVAL 1 YEAR);
-> '2017-05-01'

HELP TIMESATMPDIFF;

-- display experiance of employees in years and months
SELECT ename,TIMESTAMPDIFF(YEAR,hire,NOW()) AS years FROM emp;-- no of years 
SELECT ename,TIMESTAMPDIFF(MONTH,hire,NOW()) AS months FROM emp; -- total months

SELECT ename,TIMESTAMPDIFF(MONTH,hire,NOW())%12 AS months FROM emp; 

SELECT ename,
TIMESTAMPDIFF(YEAR,hire,NOW()) AS years, 
TIMESTAMPDIFF(MONTH,hire,NOW())%12 AS months 
FROM emp;

SELECT DATE(NOW()),TIME(NOW()), DAY(NOW()),MONTH(NOW()),YEAR(NOW());

-- display all the emps hired in 1982
SELECT * FROM emp WHERE YEAR(hire) = 1982;

--  Flow Control Functions
HELP Flow Control Functions

-- display names of the dept from emp table
-- 10 -> Development
-- 20 -> Testing
-- any other dept -> UNKNOWN

SELECT ename,deptno, CASE 
WHEN deptno = 10 THEN 'DEVELOPMENT'
WHEN deptno = 20 THEN 'TESTING'
ELSE 'UNKNOWN'
END AS deptname
FROM emp;


SELECT ename,deptno, CASE deptno
WHEN 10 THEN 'DEVELOPMENT'
WHEN 20 THEN 'TESTING'
ELSE 'UNKNOWN'
END AS deptname
FROM emp;

-- display all the emps and their category
-- ename and category  (sal < 2000 as POOR otherwise RICH)
SELECT ename,sal,IF(sal<2000,'POOR','RICH') AS category FROM emp;

-- display all the comm. if the comm is null then display their salary 
SELECT IFNULL(comm,sal) AS comm_sal FROM emp;

SELECT IF(comm IS NULL,sal,comm) AS comm_sal FROM emp;

-- make the comm as null if the sal is 1250
SELECT ename,sal,comm FROM emp WHERE sal=1250;
SELECT ename,sal,NULLIF(sal,1250) AS comm FROM emp WHERE sal=1250;

SELECT VERSION();
DSD
SELECT DATABASE();

SELECT USER();
