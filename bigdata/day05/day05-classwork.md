## Apache Hive

### History Server
> mapred --daemon start historyserver

> mapred --daemon stop historyserver

### Hive Functions

```SQL
-- tables already created: movie_staging, rating_staging, movies
-- movies table -- ORC -- movieid INT, title STRING, genres ARRAY<STRING>.
CREATE TABLE ratings(uid INT, mid INT, rating DOUBLE, rtime TIMESTAMP)
STORED AS ORC
TBLPROPERTIES('transactional'='true');

SELECT uid, mid, rating, rtime FROM rating_staging LIMIT 5;

SELECT uid, mid, rating, FROM_UNIXTIME(rtime) FROM rating_staging LIMIT 5;

INSERT INTO ratings
SELECT uid, mid, rating, FROM_UNIXTIME(rtime) FROM rating_staging;

SELECT uid, mid, rating, rtime FROM ratings LIMIT 5;

-- find num of ratings per year
SELECT YEAR(rtime) yr, COUNT(rating) cnt FROM ratings
GROUP BY YEAR(rtime);
```

### Movie Recommendation Systems

```SQL
SET mapreduce.reduce.memory.mb = 4096;
SET mapreduce.reduce.java.opts = -Xmx4096m;

SET hive.input.format=org.apache.hadoop.hive.ql.io.HiveInputFormat;

CREATE VIEW user_movies AS
SELECT rt1.uid, rt1.mid m1, rt1.rating r1, rt2.mid m2, rt2.rating r2 FROM ratings rt1
INNER JOIN ratings rt2 ON rt1.uid = rt2.uid
WHERE rt1.mid < rt2.mid;

DESCRIBE user_movies;

CREATE MATERIALIZED VIEW corr_movies AS
SELECT m1, m2, COUNT(m1) cnt, CORR(r1,r2) cor
FROM user_movies
GROUP BY m1, m2
HAVING CORR(r1,r2) IS NOT NULL;

-- find related movie ids for given movieid
SELECT m1, m2 FROM corr_movies
WHERE cnt > 20 AND cor > 0.7 AND (m1 = 858 OR m2 = 858);

-- find related movie titles for given movieid

CREATE VIEW IF NOT EXISTS recommend_movies AS
SELECT c.m1, c.m2, m.movieid, m.title FROM movies m
INNER JOIN corr_movies c ON (m.movieid = c.m1 OR m.movieid = c.m2)
WHERE c.cor > 0.7 AND c.cnt > 30;

SELECT * FROM recommend_movies
WHERE m1=858 OR m2=858;
```

### Hive Scripts
* Create .hql file with multiple SQL queries and configs.

* Execute the query using beeline.

* terminal> beeline -u jdbc:hive2://localhost:10000/edbda -n $USER -f /path/of/script.hql
* OR
* beeline> !run /path/of/script.hql

### Vectorization

```SQL
SET hive.vectorized.execution.enabled=false;

SELECT job, SUM(sal) FROM emp GROUP BY job;

SET hive.vectorized.execution.enabled=true;
SET hive.vectorized.execution.reduce.enabled = true;

SELECT job, SUM(sal) FROM emp GROUP BY job;
```

```SQL
SET hive.vectorized.execution.enabled=false;

SELECT mid, AVG(rating) FROM ratings GROUP BY mid;
-- 17.516 sec

SET hive.vectorized.execution.enabled=true;
SET hive.vectorized.execution.reduce.enabled = true;

SELECT mid, AVG(rating) FROM ratings GROUP BY mid;
-- ?? sec
```

### Partitioning

```SQL
CREATE TABLE emp_dept_part(
empno INT,
ename STRING,
job STRING,
mgr INT,
hire DATE,
sal DOUBLE,
comm DOUBLE
)
PARTITIONED BY (deptno INT)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
STORED AS TEXTFILE;

-- static partitioning
LOAD DATA LOCAL INPATH 
'/home/nilesh/dbda-aug24/BigData/data/emp10.csv'
INTO TABLE emp_dept_part PARTITION(deptno=10);

LOAD DATA LOCAL INPATH 
'/home/nilesh/dbda-aug24/BigData/data/emp20.csv'
INTO TABLE emp_dept_part PARTITION(deptno=20);

LOAD DATA LOCAL INPATH 
'/home/nilesh/dbda-aug24/BigData/data/emp30.csv'
INTO TABLE emp_dept_part PARTITION(deptno=30);

```

```SQL
SET hive.mapred.mode;

SELECT * FROM emp_dept_part;
-- working

SET hive.mapred.mode=strict;

SELECT * FROM emp_dept_part; -- not working

SELECT * FROM emp_dept_part WHERE deptno=20; -- working

SELECT deptno, SUM(sal) FROM emp_dept_part
WHERE deptno IN (10, 20)
GROUP BY deptno;
```

```SQL
SET hive.mapred.mode=nonstrict;

CREATE TABLE emp_job_part(
empno INT,
ename STRING,
mgr INT,
hire DATE,
sal DOUBLE,
comm DOUBLE,
deptno INT
)
PARTITIONED BY (job STRING)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
STORED AS TEXTFILE;

-- dynamic partitioning

-- step1 - create staging table to upload all incoming data and upload data in it

-- step2 - upload data in main table with dynamic partitioning
INSERT INTO emp_job_part PARTITION(job)
SELECT empno, ename, mgr, hire, sal, comm, deptno, job FROM emp_staging;
```

```SQL
CREATE TABLE emp_dept_job_part(
empno INT,
ename STRING,
mgr INT,
hire DATE,
sal DOUBLE,
comm DOUBLE
)
PARTITIONED BY (deptno INT, job STRING)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
STORED AS TEXTFILE;

SET hive.exec.dynamic.partition.mode;

-- load data from staging table to main table
INSERT INTO emp_dept_job_part PARTITION(deptno,job)
SELECT empno, ename, mgr, hire, sal, comm, deptno, job FROM emp_staging;

SELECT * FROM emp_dept_job_part
WHERE deptno=20 AND job='ANALYST';

SELECT * FROM emp_dept_job_part
WHERE deptno=20;

SELECT * FROM emp_dept_job_part
WHERE job='CLERK';

SELECT * FROM emp_dept_job_part
WHERE sal > 2500;

DROP TABLE emp_dept_job_part;
```

```SQL
SET hive.exec.dynamic.partition.mode=strict;

CREATE TABLE emp_dept_job_part(
empno INT,
ename STRING,
mgr INT,
hire DATE,
sal DOUBLE,
comm DOUBLE
)
PARTITIONED BY (deptno INT, job STRING)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
STORED AS TEXTFILE;

-- load data from staging table to main table
INSERT INTO emp_dept_job_part PARTITION(deptno,job)
SELECT empno, ename, mgr, hire, sal, comm, deptno, job FROM emp_staging;
-- error: Dynamic partition strict mode requires at least one static partition column

INSERT INTO emp_dept_job_part PARTITION(deptno=10,job)
SELECT empno, ename, mgr, hire, sal, comm, job FROM emp_staging
WHERE deptno=10;

INSERT INTO emp_dept_job_part PARTITION(deptno=20,job)
SELECT empno, ename, mgr, hire, sal, comm, job FROM emp_staging
WHERE deptno=20;

INSERT INTO emp_dept_job_part PARTITION(deptno=30,job)
SELECT empno, ename, mgr, hire, sal, comm, job FROM emp_staging
WHERE deptno=30;
```

```SQL
SELECT * FROM emp_dept_job_part;
-- allowed (mapred.mode nonstrict)

SET hive.mapred.mode=strict;

SELECT * FROM emp_dept_job_part;
-- error

SELECT * FROM emp_dept_job_part
WHERE deptno=30;
-- allowed (at least one parttioned column should be given in where clause)

SELECT * FROM emp_dept_job_part
WHERE job='MANAGER';
-- allowed (at least one parttioned column should be given in where clause)

SELECT * FROM emp_dept_job_part
WHERE empno=7900;
-- error
```

### Query performance

```SQL
EXPLAIN ANALYZE
SELECT * FROM emp_staging
WHERE deptno=20 AND ename='FORD';

EXPLAIN ANALYZE
SELECT * FROM emp_dept_part
WHERE deptno=20 AND ename='FORD';

EXPLAIN EXTENDED
SELECT * FROM emp_staging
WHERE deptno=20 AND ename='FORD';

EXPLAIN EXTENDED
SELECT * FROM emp_dept_part
WHERE deptno=20 AND ename='FORD';
```

### Bucketing

```SQL
CREATE TABLE emp_bucketed(
empno INT,
ename STRING,
job STRING,
mgr INT,
hire DATE,
sal DOUBLE,
comm DOUBLE,
deptno INT
)
CLUSTERED BY (empno) INTO 2 BUCKETS
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
STORED AS TEXTFILE;

INSERT INTO emp_bucketed
SELECT * FROM emp_staging;

SELECT * FROM emp_bucketed
WHERE empno=7900;

EXPLAIN EXTENDED
SELECT * FROM emp_bucketed
WHERE empno=7900;
```

```SQL
CREATE TABLE emp_dept_bucketed(
empno INT,
ename STRING,
job STRING,
mgr INT,
hire DATE,
sal DOUBLE,
comm DOUBLE,
deptno INT
)
CLUSTERED BY (deptno) INTO 3 BUCKETS
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
STORED AS TEXTFILE;

INSERT INTO emp_dept_bucketed
SELECT * FROM emp_staging;

EXPLAIN EXTENDED
SELECT e.ename, d.dname FROM emp_staging e
INNER JOIN dept_staging d ON e.deptno=d.deptno;

EXPLAIN EXTENDED
SELECT e.ename, d.dname FROM emp_dept_bucketed e
INNER JOIN dept_staging d ON e.deptno=d.deptno;
```

```SQL
CREATE TABLE emp_dept_part_bucketed(
empno INT,
ename STRING,
job STRING,
mgr INT,
hire DATE,
sal DOUBLE,
comm DOUBLE
)
PARTITIONED BY (deptno INT) 
CLUSTERED BY (ename) INTO 3 BUCKETS
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
STORED AS TEXTFILE;

SET hive.exec.dynamic.partition.mode=nonstrict;

INSERT INTO emp_dept_part_bucketed PARTITION(deptno)
SELECT * FROM emp_staging;
```

### Hive Joins

```SQL
SET hive.strict.checks.cartesian.product=false;
SET hive.mapred.mode=nonstrict;

SELECT e.ename, d.dname FROM emp_staging e
CROSS JOIN dept_staging d;

SELECT e.ename, d.dname FROM emp_staging e
INNER JOIN dept_staging d
ON e.deptno = d.deptno;

SELECT e.ename, d.dname FROM emp_staging e
LEFT JOIN dept_staging d
ON e.deptno = d.deptno;

SELECT e.ename, d.dname FROM emp_staging e
RIGHT JOIN dept_staging d
ON e.deptno = d.deptno;

SELECT e.ename, d.dname FROM emp_staging e
FULL JOIN dept_staging d
ON e.deptno = d.deptno;
```
