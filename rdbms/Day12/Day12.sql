-- display deptno and count of employees in that dept
SELECT deptno,COUNT(empno) FROM emp GROUP BY deptno;

-- display total employees in the organization
SELECT "Total", COUNT(empno) FROM emp;

-- combine the output of above queries
(SELECT deptno,COUNT(empno) FROM emp GROUP BY deptno)
UNION
(SELECT "Total", COUNT(empno) FROM emp);

-- display deptno and count of employees in that dept along with the 
-- final total of all emps
SELECT deptno,COUNT(empno) FROM emp GROUP BY deptno WITH ROLLUP;

SELECT IFNULL(deptno,"Total") AS deptno,COUNT(empno) AS emp_count FROM emp GROUP BY deptno WITH ROLLUP;

-- display deptwise total salary spent on emp along with the 
-- total salary spent on all depts

SELECT deptno,SUM(sal) FROM emp GROUP BY deptno;

SELECT "Total", SUM(sal) FROM emp;

(SELECT deptno,SUM(sal) FROM emp GROUP BY deptno)
UNION
(SELECT "Total", SUM(sal) FROM emp);

SELECT deptno,SUM(sal) FROM emp GROUP BY deptno WITH ROLLUP;

SELECT IFNULL(deptno,"Total") deptno,SUM(sal) sum_sal FROM emp GROUP BY deptno WITH ROLLUP;


-- display deptwise job wise total sal spent
SELECT deptno,job,SUM(sal) FROM emp GROUP BY deptno,job;

-- display deptwise job wise total sal spent along with the subtotals
SELECT deptno,job,SUM(sal) FROM emp GROUP BY deptno,job WITH ROLLUP;

SELECT IFNULL(deptno,"Dept Total") deptno ,IFNULL(job,"All Jobs Total")job,
SUM(sal) FROM emp GROUP BY deptno,job WITH ROLLUP;


-- display jobwise deptwise total sal spent along with the subtotals

SELECT job,deptno,SUM(sal) FROM emp GROUP BY job,deptno WITH ROLLUP;

SELECT IFNULL(job,"Job Total") job,IFNULL(deptno,"Dept Total") dept,
SUM(sal) FROM emp GROUP BY job,deptno WITH ROLLUP;


-- GROUPING()

INSERT INTO emp(empno,ename,sal) VALUES (8000,'JHON',2000);

-- display deptwise total salary spent on emp along with the 
-- total salary spent on all depts
SELECT deptno,SUM(sal) FROM emp GROUP BY deptno;
SELECT deptno,SUM(sal) FROM emp GROUP BY deptno WITh ROLLUP;
SELECT IFNULL(deptno,"Total") dept,SUM(sal) FROM emp GROUP BY deptno WITh ROLLUP;


SELECT deptno,SUM(sal),GROUPING(deptno) FROM emp GROUP BY deptno WITh ROLLUP;

SELECT IF(GROUPING(deptno)=1,"Total",deptno) dept,SUM(sal) FROM emp GROUP BY deptno WITh ROLLUP;


-- display jobwise total salary spent on emp along with the 
-- total salary spent on all jobs

SELECT job,SUM(sal) FROM emp GROUP BY job;

SELECT job,SUM(sal) FROM emp GROUP BY job WITH ROLLUP;

SELECT job,SUM(sal),GROUPING(job) FROM emp GROUP BY job WITH ROLLUP;

SELECT job,SUM(sal),GROUPING(job) FROM emp GROUP BY job WITH ROLLUP;

SELECT IF(GROUPING(job)=1,"Total",job) job ,SUM(sal) FROM emp 
GROUP BY job WITH ROLLUP;

-- diplay deptwise , jobwise, total and subtotal of sal spent
SELECT deptno,job, SUM(sal) FROM emp GROUP BY deptno,job;

SELECT deptno,job, SUM(sal) FROM emp GROUP BY deptno,job WITH ROLLUP; 

SELECT deptno,job, SUM(sal), GROUPING(deptno), GROUPING(job) FROM emp 
GROUP BY deptno,job WITH ROLLUP; 

SELECT IF(GROUPING(deptno)=1,"Dept Total",deptno) dept,
IF(GROUPING(job)=1,"Job Total",job) job, 
SUM(sal) sum_sal FROM emp 
GROUP BY deptno,job WITH ROLLUP; 

-- display only the subtotals and total for the deptwise ,jobwise salary
SELECT IF(GROUPING(deptno)=1,"Dept Total",deptno) dept,
IF(GROUPING(job)=1,"Job Total",job) job, 
SUM(sal) sum_sal FROM emp 
GROUP BY deptno,job WITH ROLLUP
HAVING GROUPING(job)=1; 

-- Window Functions
-- 1. Aggegrate Function (Group Functions)
    -- SUM(), MAX(), MIN(), AVG(), COUNT()
-- 2. Non Aggegrate Functions
    -- ROW_NUMBER(),RANK(), DENSE_RANK(), LEAD(), LAG()

-- display ename, sal, and the total salary spent on all emps.
-- smith 1000 - 30000
-- JHON 2000 - 30000

SELECT ename,sal,(SELECT SUM(sal) FROM emp) total FROM emp;

SELECT ename,sal,SUM(sal) total FROM emp;
-- error

SELECT ename,sal,SUM(sal) OVER() total FROM emp;

-- display deptno and count of emps in that dept out of the total emps
-- 10 - 3 - 14
-- 20 - 5 - 14

SELECT deptno, COUNT(empno) FROM emp GROUP BY deptno;
SELECT deptno, COUNT(empno), (SELECT COUNT(empno) FROM emp) total FROM emp GROUP BY deptno;

SELECT deptno, COUNT(empno) OVER() FROM emp;
SELECT deptno, COUNT(empno) OVER(PARTITION BY deptno) emp_count FROM emp;

SELECT deptno, COUNT(empno) OVER(PARTITION BY deptno) emp_count FROM emp GROUP BY deptno;
SELECT DISTINCT deptno, COUNT(empno) OVER(PARTITION BY deptno) emp_count FROM emp;

SELECT DISTINCT deptno, 
COUNT(empno) OVER(PARTITION BY deptno) emp_count,
COUNT(empno) OVER() total_count
FROM emp;

-- display emp with max salary from its dept
SELECT deptno,ename,sal FROM emp ORDER BY deptno,sal DESC;

SELECT deptno,ename,sal FROM emp WHERE sal IN (SELECT MAX(sal) FROM emp GROUP BY deptno);
-- partial output

SELECT deptno,ename,sal FROM emp e1 WHERE sal = 
(SELECT MAX(sal) FROM emp e2 WHERE e2.deptno = e1.deptno);

-- display emp with his deptno,name,sal and max salary of his dept
SELECT deptno,ename,sal, 
MAX(sal) OVER(PARTITION BY deptno) dept_sal 
FROM emp; 


SELECT deptno,ename,sal, 
MAX(sal) OVER(PARTITION BY deptno) dept_sal 
FROM emp WHERE sal = MAX(sal) OVER(PARTITION BY deptno); 
-- You cannot use the window function 'max' in this context.'

SELECT deptno,ename,sal FROM emp WHERE sal IN (SELECT MAX(sal) OVER(PARTITION BY deptno) FROM emp );

-- Non Aggegrated Function
-- ROW_NUMBER()

SELECT ROW_NUMBER() OVER() , empno,ename,sal,job FROM emp; 
SELECT ROW_NUMBER() OVER(PARTITION BY deptno) rno , empno,ename,sal,job FROM emp;

SELECT ROW_NUMBER() OVER(PARTITION BY deptno) rno , empno,ename,sal,deptno,job FROM emp; 

SELECT ROW_NUMBER() OVER(PARTITION BY deptno ORDER BY sal) rno , 
empno,ename,sal,deptno,job FROM emp; 

SELECT ROW_NUMBER() OVER(PARTITION BY deptno ORDER BY sal DESC) rno , 
empno,ename,sal,deptno,job FROM emp; 

-- test case
SELECT ROW_NUMBER() OVER(PARTITION BY deptno) rno , 
empno,ename,sal,deptno,job FROM emp ORDER BY sal; 

-- RANK()
SELECT RANK() OVER(),empno,ename,sal,deptno,job FROM emp; 

SELECT RANK() OVER(ORDER BY sal DESC) rnk,empno,ename,sal,deptno,job FROM emp; 

SELECT RANK() OVER(PARTITION BY deptno ORDER BY sal DESC) rnk,
empno,ename,sal,deptno,job FROM emp; 

-- DENSE_RANK()

SELECT DENSE_RANK() OVER(),empno,ename,sal,deptno,job FROM emp; 

SELECT DENSE_RANK() OVER(ORDER BY sal DESC) dns_rnk,empno,ename,sal,deptno,job FROM emp; 

SELECT DENSE_RANK() OVER(PARTITION BY deptno ORDER BY sal DESC) dns_rnk,
empno,ename,sal,deptno,job FROM emp; 

SELECT DENSE_RANK() OVER(PARTITION BY deptno ORDER BY sal DESC) dns_rnk,
empno,ename,sal,deptno,job FROM emp 
WHERE DENSE_RANK() OVER(PARTITION BY deptno ORDER BY sal DESC) = 1;

SELECT empno,ename,sal,LEAD(sal) OVER() lead_sal FROM emp;

SELECT empno,ename,sal,LAG(sal) OVER() lag_sal FROM emp;

SELECT empno,ename,sal,LEAD(sal) OVER(ORDER BY sal) lead_sal FROM emp;

SELECT empno,ename,sal,LAG(sal) OVER(ORDER BY sal) lag_sal FROM emp;

SELECT empno,ename,deptno,sal,LEAD(sal) OVER(PARTITION BY deptno) lead_sal FROM emp;

SELECT empno,ename,deptno,sal,LAG(sal) OVER(PARTITION BY deptno) lag_sal FROM emp;

SELECT empno,ename,deptno,sal,
LEAD(sal) OVER(PARTITION BY deptno ORDER BY sal) lead_sal FROM emp;

SELECT empno,ename,job,sal,
LEAD(sal) OVER(PARTITION BY job ORDER BY sal) - sal next_increment FROM emp;

-- MOVING WINDOW

DROP TABLE IF EXISTS transactions;
CREATE TABLE transactions (accid INT, txdate DATETIME, amount DOUBLE);
INSERT INTO transactions VALUES
(1, '2000-01-01', 1000),
(1, '2000-01-02', 2000),
(1, '2000-01-03', -500),
(1, '2000-01-04', -300),
(1, '2000-01-05', 4000),
(1, '2000-01-06', -2000),
(1, '2000-01-07', -200),
(2, '2000-01-02', 3000),
(2, '2000-01-04', 2000),
(2, '2000-01-06', -1000),
(3, '2000-01-01', 2000),
(3, '2000-01-03', -1000),
(3, '2000-01-05', 500);

SELECT * FROM transactions;