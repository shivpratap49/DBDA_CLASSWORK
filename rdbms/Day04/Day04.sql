-- GROUP FUNCTIONS
-- Multi-Row Functions

-- display count of total employees
SELECT COUNT(*) FROM emp;
SELECT COUNT(ename) FROM emp;

-- display total salary paid to all the employees
SELECT SUM(sal) FROM emp;

-- display highest salary
SELECT MAX(sal) AS max_sal FROM emp;

-- display avg salaries of all the emp
SELECT AVG(sal) AS avg_sal FROM emp;

-- display count of employees who gets the commission
-- employees who have the commision will be considerd in the group function
-- employees who have comm as NULL will be ignored in the group function
SELECT COUNT(comm) FROM emp;

-- Limitations of Group Function

-- display the emp with highest salary
SELECT ename,MAX(sal) FROM emp;
-- we cannot select non aggegrated cols along with group functions

SELECT ename FROM emp WHERE sal = MAX(sal);
-- cannot use it in where clause

-- We cannot have nesting of group functions

-- Group BY

-- display deptwise total salary spent
SELECT deptno,SUM(sal) AS sum_sal FROM emp GROUP BY deptno;

-- display jobwise count of employees
SELECT job,ename FROM emp ORDER BY job;
SELECT job,COUNT(ename) FROM emp GROUP BY job;

-- display highest salary from every dept
SELECT deptno,sal FROM emp ORDER BY deptno;
SELECT deptno,MAX(sal) AS max_sal FROM emp GROUP BY deptno;

-- display count of employees in every dept job wise
SELECT deptno,job,ename FROM emp ORDER BY deptno,job;

SELECT deptno,job,COUNT(ename) AS emp_count FROM emp GROUP BY deptno,job;

-- Having clause
-- display the dept which spends total salary  > 9000
SELECT deptno,SUM(sal) AS sum_sal FROM emp GROUP BY deptno HAVING SUM(sal)>9000;

-- display the job and its avg salary whose avg sal>2500
SELECT job,AVG(sal) AS avg_sal FROM emp GROUP BY job HAVING avg_sal>2500;

-- display maximum salary from dept 20 and 30
SELECT deptno,MAX(sal) AS max_sal FROM emp GROUP BY deptno HAVING deptno IN (20,30);

SELECT deptno,MAX(sal) AS max_sal FROM emp WHERE deptno IN(20,30) GROUP BY deptno;

-- display the dept with the lowest salary
SELECT deptno,SUM(sal) AS sum_sal FROM emp GROUP BY deptno;

SELECT deptno,SUM(sal) AS sum_sal FROM emp GROUP BY deptno ORDER BY sum_sal;

SELECT deptno,SUM(sal) AS sum_sal FROM emp 
GROUP BY deptno ORDER BY sum_sal LIMIT 1;

-- display the job with highest average salary
SELECT job,AVG(SAL) AS avg_sal FROM emp GROUP BY job;

SELECT job,AVG(SAL) AS avg_sal FROM emp GROUP BY job ORDER BY avg_sal DESC;

SELECT job,AVG(SAL) AS avg_sal FROM emp 
GROUP BY job ORDER BY avg_sal DESC LIMIT 1;

-- JOINS
SELECT ename,dname FROM emps
CROSS JOIN depts;

SELECT empno,ename,dname FROM emps
CROSS JOIN depts;

SELECT empno,ename,emps.deptno,dname FROM emps
CROSS JOIN depts;

SELECT empno,ename,depts.deptno,dname FROM emps
CROSS JOIN depts;

SELECT e.empno,e.ename,d.deptno,d.dname  
FROM emps e CROSS JOIN depts d;

SELECT e.empno,e.ename,d.deptno,d.dname  
FROM depts d CROSS JOIN emps e;

-- INNER JOIN
SELECT e.empno,e.ename, e.deptno,d.deptno, d.dname 
FROM emps e INNER JOIN depts d ON e.deptno = d.deptno; 

-- display empname and deptname of all the employees
SELECT e.ename,d.dname FROM depts d 
INNER JOIN emps e ON e.deptno = d.deptno;

-- display empname and deptname of all the 
-- employees in which they are not working
SELECT e.ename,d.dname FROM depts d 
INNER JOIN emps e ON e.deptno != d.deptno;

-- display all the employees and their deptname.
-- display employees even if the dept name does not exists
SELECT e.ename,d.dname 
FROM emps e LEFT OUTER JOIN depts d
ON e.deptno = d.deptno;

SELECT e.ename,d.dname 
FROM emps e LEFT JOIN depts d
ON e.deptno = d.deptno;

-- display all the employees and their deptname.
-- display deptname even if the emps does not exists in that dept
SELECT e.ename,d.dname 
FROM emps e RIGHT OUTER JOIN depts d
ON e.deptno = d.deptno;

SELECT e.ename,d.dname 
FROM emps e RIGHT JOIN depts d
ON e.deptno = d.deptno;

SELECT e.ename,d.dname 
FROM depts d LEFT JOIN emps e
ON e.deptno = d.deptno;

-- FULL OUTER JOIN
-- It is not supported in mysql but can be simulated using SET operators
SELECT e.ename,d.dname 
FROM emps e LEFT JOIN depts d
ON e.deptno = d.deptno
UNION ALL
SELECT e.ename,d.dname 
FROM emps e RIGHT JOIN depts d
ON e.deptno = d.deptno;

SELECT e.ename,d.dname 
FROM emps e LEFT JOIN depts d
ON e.deptno = d.deptno
UNION
SELECT e.ename,d.dname 
FROM emps e RIGHT JOIN depts d
ON e.deptno = d.deptno;

-- SELF JOIN
-- display empname and his respective manager name
SELECT e.ename AS emp_name, m.ename AS mgr_name 
FROM emps e INNER JOIN emps m ON e.mgr=m.empno;

SELECT e.ename AS emp_name, m.ename AS mgr_name 
FROM emps e LEFT JOIN emps m ON e.mgr=m.empno;