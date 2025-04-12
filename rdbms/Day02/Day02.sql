USE classwork_db;

-- display all the emps 
SELECT * FROM emp;

-- Limit
-- display first 5 employees
SELECT * FROM emp LIMIT 5;

-- display first 10 employees
SELECT * FROM emp LIMIT 10;

-- display ename,sal and job of first 8 employees
SELECT ename,sal,job FROM emp LIMIT 8;

-- display ename,sal and da for first 6 employees
SELECT ename,sal,sal*0.5 AS da FROM emp LIMIT 6;

-- display 6 records of emp skipping the first 5
SELECT * FROM emp LIMIT 5,6;


-- Order By clause
--display ename and salary of all the employees
SELECT ename,sal FROM emp;

--display ename and salary of all the employees sorted on sal in asc order
SELECT ename,sal FROM emp ORDER BY sal;

--display ename and salary of all the employees sorted on sal in desc
SELECT ename,sal FROM emp ORDER BY sal DESC;

-- display all emp in alphabetical order
SELECT * FROM emp ORDER BY ename;

-- display deptno and job sorted on the deptno and jobs in asc order
SELECT deptno,job FROM emp;

SELECT deptno,job FROM emp ORDER BY deptno;

SELECT deptno,job FROM emp ORDER BY deptno,job;

-- display only first 7 emp with sal in desc order
SELECT * FROM emp LIMIT 7;

SELECT * FROM emp ORDER BY sal DESC;

SELECT * FROM emp ORDER BY sal DESC LIMIT 7;

-- dispaly the employee with highest salary
SELECT * FROM emp ORDER BY sal DESC LIMIT 1;

-- display 4 emps with lowest salary
SELECT * FROM emp ORDER BY sal LIMIT 4;

-- display the second higest salary
SELECT sal FROM emp ORDER BY sal DESC LIMIT 1,1;

-- display the third higest salary
SELECT DISTINCT sal FROM emp;
SELECT DISTINCT sal FROM emp ORDER BY sal DESC;
SELECT DISTINCT sal FROM emp ORDER BY sal DESC LIMIT 1,1;

-- display ename and da of the employees sorted by da in asc order
SELECT ename,sal*0.5 AS da FROM emp ORDER BY sal*0.5; 
SELECT ename,sal*0.5 AS da FROM emp ORDER BY da; 
SELECT ename,sal*0.5 AS da FROM emp ORDER BY 2; 

-- WHERE Clause
-- display emp and their deptno
SELECT ename,deptno FROM emp;

-- display emps from dept 30;
SELECT ename,deptno FROM emp WHERE deptno=30;

-- display all emps having sal<2000
SELECT ename,sal FROM emp WHERE sal<2000;

-- display all the emps who are working as analyst
SELECT ename,sal,job FROM emp WHERE job = "ANALYST";
SELECT ename,sal,job FROM emp WHERE job = 'ANALYST';
SELECT ename,sal,job FROM emp WHERE job = 'analyst';
SELECT ename,sal,job FROM emp WHERE job = "analyst";

-- display all the emps with sal >1200 and working as salesman 
SELECT * FROM emp WHERE sal>1200;
SELECT * FROM emp WHERE sal>1200 AND job='SALESMAN';

-- display all emps who are not in dept 30
SELECT * FROM emp WHERE deptno!=30;
SELECT * FROM emp WHERE deptno<>30;

-- display all emps whose sal are > 1000 but < 2000
SELECT * FROM emp WHERE sal>1000 AND sal<2000;

-- display all emps whose sal are > 1500 but < 3000 also include the given range
SELECT * FROM emp WHERE sal>1500 AND sal<3000;
SELECT * FROM emp WHERE sal>=1500 AND sal<=3000;

-- display all the employees working either clerk or the salesman
SELECT * FROM emp WHERE job='CLERK' OR job = 'SALESMAN'; 

-- display all the emp who were hired in 1982

SELECT * FROM emp WHERE hire>='1982-01-01' AND hire <='1982-12-31';

-- Conditions on NULL

-- display all the employees with comm as null
SELECT * FROM emp WHERE comm = NULL; 
-- wrong output, cannot use relational operator with NULL

SELECT* FROM emp WHERE comm IS NULL; -- OK
SELECT * FROM emp WHERE comm <=> NULL; -- OK

-- dislpay all the employees with not null comm
SELECT * FROM emp WHERE comm != NULL;
-- wrong output

SELECT * FROM emp WHERE comm IS NOT NULL;
SELECT * FROM emp WHERE comm <> NULL; -- NOT OK

-- IN and BETWEEN OPERATOR

-- display all the employees who are working as clerk or the managers
SELECT * FROM emp WHERE job = 'CLERK' OR job = 'MANAGER';

SELECT * FROM emp WHERE job IN ('CLERK','MANAGER');

-- display all the employees from dept 10 and 30
SELECT * FROM emp WHERE deptno IN (10,30);

-- display all employees who work in dept 10 or they are managers
SELECT * FROM emp WHERE deptno = 10 OR job = 'MANAGER';
-- IN cannot be used for checking condition on different columns
-- IN can be used only on the same cols for the equality checks

-- display details of employees whose names are SMITH, MARTIN,KING,JAMES
SELECT * FROM emp WHERE ename="SMITH" OR ename="MARTIN" OR ename="KING" OR ename="JAMES";
SELECT * FROM emp WHERE ename IN ("SMITH","MARTIN","KING","JAMES");

-- display all the emps who are not manager or salesman
SELECT * FROM emp WHERE job IN('MANAGER','SALESMAN');
SELECT * FROM emp WHERE job NOT IN('MANAGER','SALESMAN');

-- display all the emps with sal > 1500 and sal <3000
SELECT * FROM emp WHERE sal>=1500 AND sal<=3000;
SELECT * FROM emp WHERE sal BETWEEN 1500 AND 3000;

-- display all the emps hired in 1982
SELECT * FROM emp WHERE hire BETWEEN '1982-01-01' AND '1982-12-31';

-- display all the emps from dept 20 which are working as manager
SELECT * FROM emp WHERE deptno = 20 AND job = 'MANAGER';

-- insert the employees with the below details in the emp table
-- 1,B
-- 2,J
-- 3,K
INSERT INTO emp(empno,ename) VALUES(1,'B'),(2,'J'),(3,'K');

-- display all the emp sorted on their ename;
SELECT ename FROM emp ORDER BY ename;

-- display all the employees whose first letter of name falls between B and J
SELECT ename FROM emp WHERE ename >='B' AND ename <='J'
SELECT ename FROM emp WHERE ename BETWEEN 'B' AND 'J'

SELECT ename FROM emp WHERE ename BETWEEN 'B' AND 'K' AND ename!='K';


-- Like Operator
-- % -> any no of char occurances or empty
-- _ -> single occurance char

-- display all the emps with their names starting with M
SELECT ename FROM emp WHERE ename>='M' AND ename<'N';

SELECT ename FROM emp WHERE ename LIKE 'M%';

-- diplay all the emps whose names are ending with H
SELECT ename FROM emp WHERE ename LIKE '%H';

-- display all the emp who have R in between
SELECT ename FROM emp WHERE ename LIKE '%R%';

-- display all the emp whose ename are exactly of 4 characters
SELECT ename FROM emp WHERE ename LIKE '____';

-- display all emps who are having 2nd character as A in their name
SELECT ename FROM emp WHERE ename LIKE '_A%';

-- display all the emps having 2 'A' in their name
SELECT ename FROM emp WHERE ename LIKE '%A%A%'; 

-- display all the employees whose first letter of name falls between B and J
SELECT ename FROM emp WHERE ename BETWEEN 'B' AND 'J';
SELECT ename FROM emp WHERE ename BETWEEN 'B' AND 'J' OR ename LIKE 'J%';


-- practice examples
-- display the emp with highest sal between 1000 and 2000
SELECT ename,sal FROM emp;
SELECT ename,sal FROM emp WHERE sal BETWEEN 1000 AND 2000;

SELECT ename,sal FROM emp WHERE sal BETWEEN 1000 AND 2000 ORDER BY sal DESC;

SELECT ename,sal FROM emp WHERE sal BETWEEN 1000 AND 2000 ORDER BY sal DESC LIMIT 1;

-- display only the 5th highest sal in the range of 1000 and 2000
SELECT DISTINCT sal FROM emp WHERE sal BETWEEN 1000 AND 2000 ORDER BY sal DESC LIMIT 4,1;

-- display CLERK with min salary
SELECT * FROM emp WHERE job = 'CLERK';
SELECT * FROM emp WHERE job = 'CLERK' ORDER BY sal;
SELECT * FROM emp WHERE job = 'CLERK' ORDER BY sal LIMIT 1;

-- display the 2nd highest salary from the dept 20 and 30
SELECT sal FROM emp WHERE deptno IN (20,30);
SELECT sal FROM emp WHERE deptno IN (20,30) ORDER BY sal DESC;
SELECT DISTINCT sal FROM emp WHERE deptno IN (20,30) ORDER BY sal DESC;
SELECT DISTINCT sal FROM emp WHERE deptno IN (20,30) ORDER BY sal DESC LIMIT 1,1;

-- DML -> UPDATE
-- change the location of the dept 4o to USA
UPDATE dept SET loc="USA" WHERE deptno = 40;

UPDATE dept SET loc='INDIA';

-- increase the price of the C programming books by 50;
UPDATE books SET price = price + 50 WHERE subject = 'C Programming';

-- provide sal as 1000 and comm as 200 for the employee B
UPDATE emp SET sal=1000,comm=200 WHERE ename='B';


-- DML - DELETE
-- delete the dept 20 from the dept table
DELETE FROM dept WHERE deptno = 20;
DELETE FROM dept;

-- DDL -> Truncate
TRUNCATE TABLE books;

-- DDL -> DROP
DROP TABLE dept;

