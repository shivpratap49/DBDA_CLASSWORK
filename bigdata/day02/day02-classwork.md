## Apache Hive
* https://cwiki.apache.org/confluence/display/Hive/Home

### Basics

```SQL
SHOW DATABASES;

CREATE DATABASE edbda;

SHOW DATABASES;

USE edbda;

CREATE TABLE students(id INT, name CHAR(50), marks DOUBLE)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
STORED AS TEXTFILE;

SHOW TABLES;

DESCRIBE students;

INSERT INTO students VALUES (1, 'Nitin', 96.23);

INSERT INTO students VALUES (2, 'Vishal', 86.43), (3, 'Rahul', 76.54), (4, 'Amit', 97.43);

SELECT * FROM students LIMIT 5;
```

### Schema-on-Read

```sh
# create a new file on bash shell
cmd> cat > /tmp/students.txt
7,James,83.87
Eight,John,72.42
9,Jack,Full
10,Hubert Blaine Wolfeschlegelsteinhausenbergerdorff Sr,76.04
```

```SQL
LOAD DATA LOCAL INPATH '/tmp/students.txt'
INTO TABLE students;

SELECT * FROM students
LIMIT 10;
```

### Know current database

```SQL
SELECT CURRENT_DATABASE();
```

### Create Tables & Ingest Data

```SQL
CREATE TABLE dept_staging(
deptno INT,
dname STRING,
loc STRING
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
STORED AS TEXTFILE;

LOAD DATA LOCAL INPATH '/home/nilesh/dbda-aug24/BigData/data/dept.csv'
INTO TABLE dept_staging;

SELECT * FROM dept_staging
LIMIT 5;

CREATE TABLE emp_staging(
empno INT,
ename STRING,
job STRING,
mgr INT,
hire DATE,
sal DOUBLE,
comm DOUBLE,
deptno INT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
STORED AS TEXTFILE;

LOAD DATA LOCAL INPATH '/home/nilesh/dbda-aug24/BigData/data/emp.csv'
INTO TABLE emp_staging;

SELECT * FROM emp_staging
LIMIT 20;
```

### Rollup & Cube

```SQL
-- count num of emps per job along with total emps.
SELECT job, COUNT(empno) cnt FROM emp_staging
GROUP BY job WITH ROLLUP;

-- count num of emps per dept along with total emps.
SELECT deptno, COUNT(empno) cnt FROM emp_staging
GROUP BY deptno WITH ROLLUP;

-- count num of emps per dept per job along with total emps.
SELECT deptno, job, COUNT(empno) cnt FROM emp_staging
GROUP BY deptno, job WITH ROLLUP;

-- count num of emps per job per dept along with total emps.
SELECT job, deptno, COUNT(empno) cnt FROM emp_staging
GROUP BY job, deptno WITH ROLLUP;

-- count num of emps per job per dept along with total emps -- show deptwise and jobwise subtotals.
(SELECT deptno, job, COUNT(empno) cnt FROM emp_staging
GROUP BY deptno, job WITH ROLLUP)
UNION
(SELECT deptno, job, COUNT(empno) cnt FROM emp_staging
GROUP BY job, deptno WITH ROLLUP);

-- count num of emps per job per dept along with total emps -- show deptwise and jobwise subtotals.
SELECT deptno, job, COUNT(empno) cnt FROM emp_staging
GROUP BY deptno, job WITH CUBE;

-- show deptwise and jobwise total emps.
-- only display subtotals. ???
```

### Collection data types

```SQL
CREATE TABLE people(
id INT,
name STRING,
emails ARRAY<STRING>,
addr STRUCT<area:STRING, dist:STRING, pin:INT>,
phones MAP<STRING,STRING>
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
COLLECTION ITEMS TERMINATED BY '|'
MAP KEYS TERMINATED BY ':'
STORED AS TEXTFILE;

DESCRIBE people;

LOAD DATA LOCAL INPATH '/home/nilesh/dbda-aug24/BigData/data/contacts.csv'
INTO TABLE people;

SELECT * FROM people LIMIT 5;
```

```SQL
-- display name, first email, dist, and mobile number.
-- array elements -- arr[0], ...
-- struct elements -- var.field, ...
-- map elements -- map[key]
SELECT name, emails[0], addr.dist, phones['mobile'] FROM people LIMIT 5;

SELECT name, emails[0] email, addr.dist, phones['mobile'] mobile FROM people LIMIT 5;

-- find person whose email is 'ghule.nilesh@gmail.com'.
SELECT * FROM people
WHERE emails[1] = 'ghule.nilesh@gmail.com';

SELECT * FROM people
WHERE ARRAY_CONTAINS(emails, 'ghule.nilesh@gmail.com');

-- print name and number of emails per person
SELECT name, SIZE(emails) FROM people;

-- find people from 'karad'.
SELECT * FROM people
WHERE addr.dist = 'karad';

-- find num of people per dist.
SELECT addr.dist, COUNT(id) FROM people
GROUP BY addr.dist;

-- find people whose office number is '24260308'.
SELECT * FROM people
WHERE phones['office'] = '24260308';

-- display num of phone numbers and phone numbers per person.
SELECT name, SIZE(phones), MAP_VALUES(phones) FROM people LIMIT 5;
```

```SQL
CREATE TABLE movie_staging(
movieid INT,
title STRING,
genres ARRAY<STRING>
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY '^'
COLLECTION ITEMS TERMINATED BY '|'
STORED AS TEXTFILE
TBLPROPERTIES ('skip.header.line.count'='1');

DESCRIBE EXTENDED movie_staging;

LOAD DATA LOCAL INPATH '/home/nilesh/dbda-aug24/BigData/private/movies/movies_caret.csv'
INTO TABLE movie_staging;

SELECT * FROM movie_staging LIMIT 15;

-- find all 'Action' movies
SELECT * FROM movie_staging
WHERE ARRAY_CONTAINS(genres, 'Action');
```
