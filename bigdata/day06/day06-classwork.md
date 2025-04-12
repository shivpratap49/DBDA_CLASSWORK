
### Hive Joins
* Implicit Join Syntax (not recommended)
```SQL
SELECT d.dname, e.ename FROM dept_staging d, emp_staging e
WHERE e.deptno = d.deptno AND d.deptno = 40;
```

* Join without condition (bad practice -- like cross join)
```SQL
SELECT d.dname, e.ename FROM dept_staging d
LEFT JOIN emp_staging e
WHERE e.deptno = d.deptno AND d.deptno = 40;
```

* condition in WHERE is not same as condition in ON clause.
```SQL
SELECT d.dname, e.ename FROM dept_staging d
LEFT JOIN emp_staging e ON e.deptno = d.deptno
WHERE d.deptno = 40;
```

```SQL
SELECT d.dname, e.ename FROM dept_staging d
LEFT JOIN emp_staging e ON e.deptno = d.deptno AND d.deptno = 40;
```

* Sub queries & Left Semi Join

```SQL
SELECT d.deptno, d.dname FROM dept_staging d
WHERE EXISTS (SELECT e.deptno FROM emp_staging e WHERE e.deptno = d.deptno);
-- 14.94 sec
```

```SQL
SELECT d.deptno, d.dname FROM dept_staging d
WHERE d.deptno IN (SELECT e.deptno FROM emp_staging e);
-- 14.88 sec
```

```SQL
SELECT d.deptno, d.dname FROM dept_staging d
LEFT SEMI JOIN emp_staging e ON (d.deptno = e.deptno);
-- 13.21 sec
```

* Reduce side Joins

```SQL
SET hive.auto.convert.join = false;

SELECT d.deptno, d.dname FROM dept_staging d
INNER JOIN emp_staging e ON (d.deptno = e.deptno);
-- 16.3 sec
```

* Map side Joins


```SQL
SET hive.auto.convert.join = true;

SELECT d.deptno, d.dname FROM dept_staging d
INNER JOIN emp_staging e ON (d.deptno = e.deptno);
-- 14.0 sec
```




