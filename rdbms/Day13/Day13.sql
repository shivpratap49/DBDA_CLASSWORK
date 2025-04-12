SELECT accid,txdate,amount,SUM(amount) OVER() FROM transactions WHERE accid = 1; 

SELECT accid,txdate,amount,SUM(amount) OVER(ORDER BY txdate) FROM transactions WHERE accid = 1; 


INSERT INTO transactions VALUES(1, '2000-01-08', 1000);
INSERT INTO transactions VALUES(1, '2000-01-08', 2000);

SELECT accid,txdate,amount,SUM(amount) OVER(ORDER BY txdate) balance FROM transactions WHERE accid = 1; 
SELECT accid,txdate,amount,
SUM(amount) OVER(ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) balance 
FROM transactions WHERE accid = 1; 

-- Test case
SELECT accid,txdate,amount,SUM(amount) OVER(ORDER BY txdate) balance FROM transactions WHERE accid = 1; 
SELECT accid,txdate,amount,
SUM(amount) OVER(ROWS BETWEEN 1 PRECEDING AND 1 FOLLOWING) balance 
FROM transactions WHERE accid = 1; 


-- display empname ,salary and the category of the employees
-- sal<2500 -> 'POOR' 
-- sal >2500 -> 'RICH'
SELECT ename,sal,IF(sal>=2500,'RICH','POOR') category FROM emp;

-- display category wise count of employees

SELECT category,COUNT(category) category_count FROM
(SELECT ename,sal,IF(sal>=2500,'RICH','POOR') category FROM emp);
-- Every derived table must have its own alias

SELECT category,COUNT(category) category_count FROM
(SELECT ename,sal,IF(sal>=2500,'RICH','POOR') category FROM emp)
AS emp_category GROUP BY category;

CREATE VIEW v_emp_category AS 
SELECT ename,sal,IF(sal>=2500,'RICH','POOR') category FROM emp;

SELECT category,COUNT(category) category_count FROM v_emp_category GROUP BY category;

WITH emp_category AS
(SELECT ename,sal,IF(sal>=2500,'RICH','POOR') category FROM emp)
SELECT category,COUNT(category) category_count FROM emp_category GROUP BY category;

-- display emps with highest sal from each dept
SELECT * FROM emp e1 WHERE sal = (SELECT MAX(sal) FROM emp e2 WHERE e1.deptno = e2.deptno);

WITH dept_sal AS 
(SELECT deptno,MAX(sal) max_sal FROM emp GROUP BY deptno)
SELECT e.* FROM emp e INNER JOIN dept_sal d ON e.deptno = d.deptno
WHERE e.sal = d.max_sal;

-- display rank of all emps from the dept with higest sal as rank 1
SELECT RANK() OVER(PARTITION BY deptno ORDER BY sal DESC) rnk,
ename,sal,deptno,job FROM emp;

WITH dept_rnk AS
(SELECT RANK() OVER(PARTITION BY deptno ORDER BY sal DESC) rnk,
ename,sal,deptno,job FROM emp)
SELECT * FROM dept_rnk WHERE rnk = 1;

-- display emps from every dept with 2nd highest salary
WITH dept_rnk AS
(SELECT DENSE_RANK() OVER(PARTITION BY deptno ORDER BY sal DESC) dns_rnk,
ename,sal,deptno,job FROM emp)
SELECT * FROM dept_rnk WHERE dns_rnk = 2;

-- display avg of total salary of all depts
SELECT deptno,SUM(sal) sum_sal FROM emp GROUP BY deptno;

WITH dept_sum AS
(SELECT deptno,SUM(sal) sum_sal FROM emp GROUP BY deptno)
SELECT AVG(sum_sal) dept_avg FROM dept_sum;


WITH RECURSIVE seq(n) AS (
    (SELECT 1)  -- anchor
    UNION
    (SELECT n+1 FROM seq -- recersive member
    WHERE n<5) -- condition
)SELECT * FROM seq;


-- display years in which emps were hired from 1981 to 1985
SELECT YEAR(hire) years FROM emp WHERE YEAR(hire) BETWEEN 1981 AND 1985;

SELECT DISTINCT YEAR(hire) years FROM emp WHERE YEAR(hire) BETWEEN 1981 AND 1985;

WITH RECURSIVE years(yr) AS (
    (SELECT 1981)
    UNION
    (SELECT yr+1 FROM years WHERE yr<1985)
)
SELECT DISTINCT YEAR(hire) yrs FROM emp WHERE YEAR(hire) IN (SELECT yr FROM years);


WITH RECURSIVE seq AS (
    (SELECT 1 AS n) 
    UNION
    (SELECT n+1 FROM seq 
    WHERE n<5)
)SELECT * FROM seq;

WITH RECURSIVE years AS (
    (SELECT 1981 AS yr)
    UNION
    (SELECT yr+1 FROM years WHERE yr<1985)
)
SELECT DISTINCT YEAR(hire) yrs FROM emp WHERE YEAR(hire) IN (SELECT yr FROM years);

-- display level of employees
SELECT empno,ename,mgr,sal FROM emp WHERE mgr IS NULL;

SELECT empno,ename,mgr,sal, 1 AS level FROM emp WHERE mgr IS NULL;

WITH RECURSIVE emp_hirerachy AS(
    (SELECT empno,ename,mgr,sal, 1 AS level FROM emp WHERE mgr IS NULL)
    UNION
    (SELECT e.empno,e.ename,e.mgr,e.sal,level + 1 FROM emp e 
    INNER JOIN emp_hirerachy eh ON e.mgr = eh.empno)
)
SELECT * FROM emp_hirerachy;