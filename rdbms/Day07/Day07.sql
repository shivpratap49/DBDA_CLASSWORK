-- Subquery
-- It is a query inside another query

-- display emp with highest salary
SELECT * FROM emp ORDER BY sal DESC LIMIT 1;

SELECT * FROM emp WHERE sal = MAX(sal);
-- error cannot use group function in where clause

SET @max_sal = (SELECT MAX(sal) FROM emp);
SELECT * FROM emp WHERE sal = @max_sal;

-- subquery
SELECT * FROM emp WHERE sal = (SELECT MAX(sal) FROM emp);

-- display all the emps with second highest salary
SELECT * FROM emp ORDER BY sal DESC LIMIT 1,1;

SELECT DISTINCT sal FROM emp ORDER BY sal DESC LIMIT 1,1;

SELECT * FROM emp WHERE sal = (SELECT DISTINCT sal FROM emp ORDER BY sal DESC LIMIT 1,1);

--display all emps who are in same dept as that of king
SELECT * FROM emp WHERE deptno = (SELECT deptno FROM emp WHERE ename = 'KING');     

-- display emps having salary less than all the salesman
SELECT MIN(sal) FROM emp WHERE job = 'SALESMAN';
SELECT sal FROM emp WHERE job = 'SALESMAN';

SELECT * FROM emp WHERE sal < (SELECT MIN(sal) FROM emp WHERE job = 'SALESMAN');
SELECT * FROM emp WHERE sal < (SELECT sal FROM emp WHERE job = 'SALESMAN');

--SELECT * FROM emp WHERE sal < ANY(SELECT sal FROM emp WHERE job = 'SALESMAN');
-- not correct output 

SELECT * FROM emp WHERE sal < ALL(SELECT sal FROM emp WHERE job = 'SALESMAN');

-- display emps whith the sal less than any of the emps from dept 20
SELECT * FROM emp WHERE sal < ANY(SELECT sal FROM emp WHERE deptno = 20);

SELECT * FROM emp WHERE sal < (SELECT MAX(sal) FROM emp WHERE deptno = 20);

-- display dept which have employees
SELECT * from dept WHERE deptno = ANY(SELECT deptno FROM emp);
SELECT * from dept WHERE deptno IN (SELECT deptno FROM emp);

-- display depts in which their are no employees 
SELECT * from dept WHERE deptno != ALL(SELECT deptno FROM emp);
SELECT * from dept WHERE deptno NOT IN (SELECT deptno FROM emp);

SELECT * from dept d WHERE deptno = (SELECT DISTINCT e.deptno FROM emp e WHERE e.deptno = d.deptno);

SELECT * from dept d WHERE  EXISTS (SELECT DISTINCT deptno FROM emp);
-- fetch all the depts

SELECT * from dept d WHERE EXISTS (SELECT e.deptno FROM emp e WHERE e.deptno = d.deptno);
SELECT * from dept d WHERE NOT EXISTS (SELECT e.deptno FROM emp e WHERE e.deptno = d.deptno);


-- Subquery in the projection
-- deptwise count of employees
-- 10  -> 2/14
-- 20 -> 5/14

SELECT deptno ,COUNT(empno) FROM emp GROUP BY deptno;

SELECT COUNT(empno) FROM emp;

SELECT deptno ,COUNT(empno) emp_count, (SELECT COUNT(empno) FROM emp) total_emp  FROM emp GROUP BY deptno;

SELECT deptno ,CONCAT (COUNT(empno),' / ', (SELECT COUNT(empno) FROM emp)) emp_count  FROM emp GROUP BY deptno;


-- Subquery in the from clause
-- display the emp and their categories
-- sal<2500 -> POOR otherwise RICH

SELECT ename,sal,IF(sal<2500,"POOR","RICH") AS category FROM emp;

-- category wise count of employees
SELECT category, COUNT(ename) FROM 
(SELECT ename,sal,IF(sal<2500,"POOR","RICH") AS category FROM emp)
AS emp_category
GROUP BY category;

-- Sub query in from clause if used creates a table on which we can select
-- such table is called as derived table or an inline view


-- Subquery in DML Operations
-- insert an emp in to ops dept
INSERT INTO emps VALUES(6,'Anil',(SELECT deptno FROM depts WHERE dname='OPS'),3);

-- update the mgr id of all the emps to 5 who work in ops dept
UPDATE emps SET mgr = 5 WHERE deptno = (SELECT deptno FROM depts WHERE dname='OPS');

-- delete emps from ops dept
DELETE FROM emps WHERE deptno = (SELECT deptno FROM depts WHERE dname='OPS');

-- delete the emp with max sal
DELETE FROM emp WHERE sal=(SELECT MAX(sal) FROM emp); 
-- error
-- we cannot select the vaalue from the table in subquery on which we 
-- are having the DML operations

SET @max_sal = (SELECT MAX(sal) FROM emp);
DELETE FROM emp WHERE sal=@max_sal; 

-- Optimizations
EXPLAIN FORMAT = JSON SELECT * FROM emps;

EXPLAIN FORMAT = JSON SELECT * FROM emp;

EXPLAIN FORMAT = JSON SELECT * from dept WHERE deptno = ANY(SELECT deptno FROM emp);

EXPLAIN FORMAT = JSON SELECT * from dept d WHERE deptno = (SELECT DISTINCT e.deptno FROM emp e WHERE e.deptno = d.deptno);

-- View
-- display emp and theor category as poor(sal<2500) or rich
SELECT ename,sal,IF(sal<2500,"POOR","RICH") category FROM emp;

-- create a view for above query
CREATE VIEW emp_category AS SELECT ename,sal,IF(sal<2500,"POOR","RICH") category FROM emp;

SHOW TABLES;

SHOW FULL TABLES;

SELECT * FROM emp_category;
-- display category wise count of employees using the above created view
SELECT category, COUNT(ename) FROM emp_category GROUP BY category;
SELECT category, COUNT(ename) 
FROM (SELECT ename,sal,IF(sal<2500,"POOR","RICH") category FROM emp) emp_category 
GROUP BY category;

-- TYpes of views
-- 1. Simple View
    -- DML
-- 2. Complex View

-- create a view on the emp table which dislays name,sal,job,deptno
CREATE VIEW v_emp_details AS SELECT ename,sal,job,deptno FROM emp;

SELECT * FROM v_emp_details;
INSERT INTO v_emp_details VALUES('B',2000,'SALESMAN',20);

SELECT * FROM v_emp_details;
SELECT * FROM emp;

-- create a view for deptwise total sal, max sal,min sal, 
-- avg sal, count from emp table

SELECT deptno, SUM(sal) sum_sal, MAX(sal) max_sal, 
MIN(sal) min_sal, AVG(sal) avg_sal, 
COUNT(ename) count FROM emp GROUP BY deptno;

CREATE VIEW v_emp_deptwise_details AS
SELECT deptno, SUM(sal) sum_sal, MAX(sal) max_sal, 
MIN(sal) min_sal, AVG(sal) avg_sal, 
COUNT(ename) count FROM emp GROUP BY deptno;

SELECT * FROM v_emp_deptwise_details;
-- we are not able to perform DML operations on v_emp_deptwise_details
-- Hence it is a complex view

--  create a view with all emps having sal > 2500
-- display only empno,name,sal;
SELECT empno,ename,sal FROM emp WHERE sal > 2500;

CREATE VIEW v_richemp AS
SELECT empno,ename,sal FROM emp WHERE sal > 2500;

SELECT * FROM v_richemp;

-- insert an employee in the above view with below details
-- (8000,'J',1800);
INSERT INTO v_richemp VALUES(8000,'J',1800);
SELECT * FROM v_richemp;
SELECT * FROM emp;

-- insert an employee in the emp table with below details
-- (8001,'K',3800);
INSERT INTO emp(empno,ename,sal) VALUES(8001,'K',3800);
SELECT * FROM emp;

ALTER VIEW v_richemp AS
SELECT empno,ename,sal FROM emp WHERE sal > 2500 WITH CHECK OPTION;

-- insert an employee in the above view with below details
-- (8002,'Z',2200);
INSERT INTO v_richemp VALUES(8002,'Z',2200);
-- error

-- (8002,'Z',2600);
INSERT INTO v_richemp VALUES(8002,'Z',2600);
-- OK

SELECT * FROM v_richemp;

-- can we create a view on another view
CREATE VIEW v_richemp2 AS
SELECT ename,sal FROM v_richemp WHERE sal>3000;

SELECT * FROM v_richemp2;

-- can we delete a view on which another view is created.
-- what will be the result
DROP VIEW v_richemp;
-- OK

SELECT * FROM v_richemp2;
-- error

-- what will happen we we drop the table on wich views are created?
DROP TABLE emp;
-- OK

SELECT * FROM emp_category;
SELECT * FROM v_emp_details;
SELECT * FROM v_emp_deptwise_details;

DROP VIEW emp_category;
DROP VIEW v_emp_details;
DROP VIEW v_emp_deptwise_details;
DROP VIEW v_richemp2;

-- display all the emps from Dev dept  (emps, depts)
SELECT e.empno,e.ename,d.deptno,d.dname FROM emps e 
INNER JOIN depts d ON e.deptno = d.deptno
WHERE d.dname = "DEV";

CREATE VIEW v_emp_dept AS
SELECT e.empno,e.ename,d.deptno,d.dname FROM emps e 
INNER JOIN depts d ON e.deptno = d.deptno;

SELECT * FROM v_emp_dept;

SELECT * FROM v_emp_dept WHERE dname = "DEV";
