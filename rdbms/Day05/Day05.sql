-- display the empno name and deptname of all the emp
SELECT e.empno, e.ename, d.dname FROM emps e
INNER JOIN depts d ON e.deptno = d.deptno;

SELECT e.empno, e.ename, d.dname FROM emps e 
LEFT JOIN depts d ON e.deptno = d.deptno;

-- display empname, deptname and dist of all the employees
SELECT e.ename,a.dist FROM emps e
INNER JOIN addr a ON e.empno = a.empno;

SELECT e.ename,a.dist,d.dname FROM emps e
INNER JOIN addr a ON e.empno = a.empno
INNER JOIN depts d ON e.deptno = d.deptno;

SELECT e.ename,a.dist,d.dname FROM emps e
INNER JOIN addr a ON e.empno = a.empno
LEFT JOIN depts d ON e.deptno = d.deptno;

SELECT e.ename,a.dist,d.dname FROM  depts d
RIGHT JOIN emps e ON e.deptno = d.deptno;
INNER JOIN addr a ON e.empno = a.empno

-- display empname and his meeting topic
SELECT e.ename,m.meetno FROM emps e
INNER JOIN emp_meeting m ON e.empno=m.empno;

SELECT e.ename,m.topic FROM emps e
INNER JOIN emp_meeting em ON e.empno=em.empno
INNER JOIN meeting m ON em.meetno = m.meetno;

-- display empname attending the meetings with their topics and from 
-- where they are travelling (dist)
SELECT e.ename,a.dist FROM emps e
INNER JOIN addr a ON e.empno = a.empno;  

SELECT e.ename,m.topic,a.dist FROM emps e
INNER JOIN emp_meeting em ON e.empno = em.empno
INNER JOIN meeting m ON em.meetno = m.meetno
INNER JOIN addr a ON e.empno = a.empno;

SELECT e.ename,m.topic,a.dist FROM emps e
INNER JOIN addr a ON e.empno = a.empno
INNER JOIN emp_meeting em ON e.empno = em.empno
INNER JOIN meeting m ON em.meetno = m.meetno;

-- display empname attending the meetings with their topics 
-- and their dept names 
SELECT e.ename,em.meetno FROM emps e
INNER JOIN emp_meeting em ON e.empno = em.empno;

SELECT e.ename,em.meetno, d.dname FROM emps e
INNER JOIN depts d ON e.deptno = d.deptno
INNER JOIN emp_meeting em ON e.empno = em.empno;


SELECT e.ename,m.topic, d.dname FROM emps e
LEFT JOIN depts d ON e.deptno = d.deptno
INNER JOIN emp_meeting em ON e.empno = em.empno
INNER JOIN meeting m ON em.meetno = m.meetno;

-- display empname attending the meetings with their topics 
-- and their dept names and from where they are travelling
SELECT e.ename,m.topic,d.dname,a.dist FROM emps e
INNER JOIN emp_meeting em ON e.empno = em.empno
INNER JOIN meeting m ON em.meetno = m.meetno
LEFT JOIN depts d ON e.deptno = d.deptno
INNER JOIN addr a ON e.empno = a.empno;

-- display deptname and the count of employees in that dept
SELECT d.dname,COUNT(e.empno) FROM emps e 
LEFT JOIN depts d ON e.deptno = d.deptno
GROUP BY d.dname; 

SELECT d.dname,COUNT(e.empno) FROM emps e 
RIGHT JOIN depts d ON e.deptno = d.deptno
GROUP BY d.dname; 

SELECT d.dname,COUNT(e.empno) FROM emps e 
LEFT JOIN depts d ON e.deptno = d.deptno
GROUP BY d.dname
UNION
SELECT d.dname,COUNT(e.empno) FROM emps e 
RIGHT JOIN depts d ON e.deptno = d.deptno
GROUP BY d.dname; 

-- display empname and his no of meeting attended. 
-- display  in the desc order of the meeting count
SELECT e.ename, COUNT(em.meetno) AS meet_count FROM emps e
INNER JOIN emp_meeting em ON e.empno = em.empno
GROUP BY e.ename
ORDER BY meet_count DESC;

-- display empname and his no of meeting attended along with his dist. 
-- display  in the desc order of the meeting count
SELECT e.ename,a.dist, COUNT(em.meetno) AS meet_count FROM emps e
INNER JOIN emp_meeting em ON e.empno = em.empno
INNER JOIN addr a ON e.empno = a.empno
GROUP BY e.ename,a.dist
ORDER BY meet_count DESC;

-- display the emps from DEV dept
SELECT e.ename FROM emps e 
INNER JOIN depts d ON e.deptno = d.deptno
WHERE d.dname = "DEV";

-- display emp names who are attending more than 2 meetings
SELECT e.ename,COUNT(em.empno) AS meet_count FROM emps e
INNER JOIN emp_meeting em ON e.empno = em.empno
GROUP BY e.ename
HAVING meet_count > 2;

SELECT e.ename FROM emps e
INNER JOIN emp_meeting em ON e.empno = em.empno
GROUP BY e.ename
HAVING COUNT(em.empno) > 2;

-- ORDER OF CLAUSES
SELECT col1,col2 FROM TABLE1
JOIN TABLE2 ON condition
JOIN TABLE3 ON condition
WHERE condition
GROUP BY col1,col2
HAVING condition
ORDER BY col ASC/DESC
LIMIT n,m