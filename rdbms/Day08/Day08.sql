-- Indexes

--1. Simple Index
-- dispalay all the java programming books
SELECT * FROM books WHERE subject = 'Java Programming';
-- 1.55

CREATE INDEX idx_books_subject ON books(subject);
-- 0.80

SHOW INDEXES FROM books;
SHOW INDEXES FROM emp;

EXPLAIN FORMAT = JSON SELECT * FROM emp WHERE deptno=20;
-- 1.65
CREATE INDEX idx_emp_deptno ON emp(deptno);

EXPLAIN FORMAT = JSON SELECT * FROM emp WHERE deptno=20;
-- 1.00

SHOW INDEXES FROM emp;

-- chek the query cost for searching books on author.
-- keep an index on the author in desc order

EXPLAIN FORMAT = JSON SELECT * FROM books WHERE author = 'James Gosling';
-- 1.55

CREATE INDEX idx_books_author ON books(author DESC);

EXPLAIN FORMAT = JSON SELECT * FROM books WHERE author = 'James Gosling';
-- 0.35

SHOW INDEXES FROM books;

-- display empname and deptname of all the emps (emps and depts)
EXPLAIN FORMAT = JSON SELECT e.ename, d.dname FROM emps e 
INNER JOIN depts d ON e.deptno = d.deptno;
-- 2.90

CREATE INDEX idx_emps_deptno ON emps(deptno);
CREATE INDEX idx_depts_deptno ON depts(deptno);

EXPLAIN FORMAT = JSON SELECT e.ename, d.dname FROM emps e 
INNER JOIN depts d ON e.deptno = d.deptno;
-- 2.50

SHOW INDEXES FROM emps;
SHOW INDEXES FROM depts;

-- 2. Unique Index
-- display emp with id 4
EXPLAIN FORMAT = JSON SELECT * FROM emps WHERE empno = 4;
-- 0.75

CREATE UNIQUE INDEX idx_emps_empno ON emps(empno);

EXPLAIN FORMAT = JSON SELECT * FROM emps WHERE empno = 4;
-- 1.00

INSERT INTO emps VALUES(4,'Yogesh',30,2);

SHOW INDEXES FROM emps;

INSERT INTO emps VALUES(NULL,'Yogesh',30,2);
INSERT INTO emps VALUES(NULL,'Rajiv',20,3);

-- 3. Composite Index
DROP INDEX idx_emp_deptno ON emp;

-- get the query cost for all emps working as Analyst
EXPLAIN FORMAT = JSON SELECT * FROM emp WHERE job = 'ANALYST';
-- 1.65

-- get the query cost for all emps working in dept 20
EXPLAIN FORMAT = JSON SELECT * FROM emp WHERE deptno = 20;
-- 1.65

-- display all the emps from dept 20 working as ANALYST
SELECT * FROM emp WHERE deptno = 20 AND job = 'ANALYST';

-- get the query cost for the above query
EXPLAIN FORMAT = JSON SELECT * FROM emp WHERE deptno = 20 AND job = 'ANALYST';
-- 1.65

CREATE INDEX idx_emp_deptno_job ON emp(deptno,job);
-- 0.70

SHOW INDEXES FROM emp;

EXPLAIN FORMAT = JSON SELECT * FROM emp WHERE job = 'ANALYST';
-- 1.65

EXPLAIN FORMAT = JSON SELECT * FROM emp WHERE deptno=20;
-- 1.00

-- 4. Unique Composit Index 
CREATE TABLE student(
    rollno INT,
    std INT,
    name VARCHAR(15),
    marks DOUBLE
);

CREATE UNIQUE INDEX idx_student_rollno_std ON student(rollno,std);

SHOW INDEXES FROM student;

INSERT INTO student VALUES(1,1,"Anil",50);
INSERT INTO student VALUES(2,1,"Mukesh",60);
INSERT INTO student VALUES(1,2,"Ramesh",70);

INSERT INTO student VALUES(1,1,"Suresh",70);
--Duplicate entry '1-1'
INSERT INTO student VALUES(1,2,"Suresh",70);
--Duplicate entry '1-2'

INSERT INTO student VALUES(1,NULL,"Suresh",70);
INSERT INTO student VALUES(1,NULL,"Ram",80);


--5. Clustered Index
-- It is a index that is basically created automatically on the primary key of the table
-- If the primary key is not present in the table the mysql will add 
-- a hidden column in your table on which it will keep an index.
-- such index is called as clustered index. 


-- Constraints
-- 1. NOT NULL
-- 2. UNIQUE
-- 3. PRIMARY KEY
-- 4. FOREIGN KEY
-- 5. CHECK

CREATE TABLE temp(
    col1 INT NOT NULL,
    col2 INT,
    col3 INT UNIQUE,
    UNIQUE(col2)
);

-- 1 . NOT NULL
CREATE TABLE temp1(col1 INT NOT NULL, col2 INT);
DESC temp1;

INSERT INTO temp1 VALUES(1,1);
INSERT INTO temp1 VALUES(1,2);

INSERT INTO temp1 VALUES(NULL,2);
-- Column 'col1' cannot be null

INSERT INTO temp1(col2) VALUES(2);
-- Field 'col1' doesn't have a default value

-- 2. Unique
CREATE TABLE temp2(
    col1 INT UNIQUE,
    col2 INT,
    UNIQUE(col2)
);

DESC temp2;
SHOW INDEXES FROM temp2;

INSERT INTO temp2 VALUES (1,1);
INSERT INTO temp2 VALUES (1,2);

--Duplicate entry '1' for key 'temp2.col1'
INSERT INTO temp2 VALUES (2,1);

--Duplicate entry '1' for key 'temp2.col2'
INSERT INTO temp2 VALUES (2,3);

INSERT INTO temp2(col1) VALUES (3);
INSERT INTO temp2(col2) VALUES (2);

INSERT INTO temp2 VALUES (NULL,NULL);

CREATE TABLE temp3(
    col1 INT NOT NULL UNIQUE,
    col2 CHAR(10)
);

DESC temp3;
SHOW INDEXES FROM temp3;

INSERT INTO temp3 VALUES(1, "Anil");
INSERT INTO temp3 VALUES(2, "Mukesh");

INSERT INTO temp3 VALUES(2, "Ramesh");
--Duplicate entry '2' for key 'temp3.col1'

INSERT INTO temp3 VALUES(3, "Mukesh");

INSERT INTO temp3 VALUES(NULL, "Ramesh");
--Column 'col1' cannot be null

INSERT INTO temp3(col2) VALUES("Ramesh");
--Field 'col1' doesn't have a default value

CREATE TABLE temp4(
    col1 INT NOT NULL,
    col2 CHAR(10),
    UNIQUE(col1)
);

CREATE TABLE temp5(
    col1 INT NOT NULL UNIQUE,
    col2 INT NOT NULL UNIQUE
);

DESC temp5;
SHOW INDEXES FROM temp5;

CREATE TABLE student(
    rollno INT,
    std INT,
    name CHAR(10),
    marks DOUBLE,
    UNIQUE(rollno,std)
);

DESC student;
SHOW INDEXES FROM student;

INSERT INTO student VALUES(1,1,"Anil",50);
INSERT INTO student VALUES(2,1,"Mukesh",60);
INSERT INTO student VALUES(1,2,"Ramesh",70);

INSERT INTO student VALUES(1,1,"Suresh",70);
--Duplicate entry '1-1'
INSERT INTO student VALUES(1,2,"Suresh",70);
--Duplicate entry '1-2'

INSERT INTO student VALUES(1,NULL,"Suresh",70);
INSERT INTO student VALUES(1,NULL,"Ram",80);


CREATE TABLE student2(
    rollno INT NOT NULL,
    std INT,
    name CHAR(10),
    marks DOUBLE,
    UNIQUE(rollno,std)
);

DESC student2;
SHOW INDEXES FROM student2;


CREATE TABLE student3(
    rollno INT NOT NULL,
    std INT NOT NULL,
    name CHAR(10),
    marks DOUBLE,
    UNIQUE(rollno,std)
);

DESC student3;
SHOW INDEXES FROM student3;

INSERT INTO student3 VALUES(1,1,"Anil",50);
INSERT INTO student3 VALUES(2,1,"Mukesh",60);
INSERT INTO student3 VALUES(1,2,"Ramesh",70);

INSERT INTO student3 VALUES(1,1,"Suresh",70);
--Duplicate entry '1-1'
INSERT INTO student3 VALUES(1,2,"Suresh",70);
--Duplicate entry '1-2'

INSERT INTO student3 VALUES(1,NULL,"Suresh",70);
--Column 'std' cannot be null

INSERT INTO student3 VALUES(NULL,1,"Suresh",70);
-- Column 'rollno' cannot be null

INSERT INTO student3(std,name,marks) VALUES(1,"Suresh",70);
--  Field 'rollno' doesn't have a default value

-- 3. Primary Key
-- It is a combination of NOT NULL + UNIQUE
-- It is used to identify ever single row of the table uniquely

DROP TABLE temp1;
DROP TABLE temp2;
DROP TABLE temp3;
DROP TABLE temp4;
DROP TABLE temp5;

DROP TABLE student;
DROP TABLE student2;
DROP TABLE student3;

CREATE TABLE temp1(
    col1 INT PRIMARY KEY,
    col2 CHAR(10)
);

INSERT INTO temp1 VALUES(1,"Anil");
INSERT INTO temp1 VALUES(2,"Mukesh");

INSERT INTO temp1 VALUES(NULL,"Ramesh");
-- Column 'col1' cannot be null

INSERT INTO temp1 VALUES(1,"Ramesh");
--Duplicate entry '1' for key 'temp1.PRIMARY'


CREATE TABLE temp2(
    col1 INT,
    col2 CHAR(10),
    PRIMARY KEY(col1)
);
DESC temp2;
SHOW INDEXES FROM temp2;

CREATE TABLE temp3(
    col1 INT PRIMARY KEY,
    col2 CHAR(10) PRIMARY KEY
);
-- Multiple primary key defined

CREATE TABLE temp3(
    col1 INT PRIMARY KEY,
    col2 CHAR(10) NOT NULL UNIQUE
);

DESC temp3;
SHOW INDEXES FROM temp3;


-- composite primary key
CREATE TABLE student(
    rollno INT,
    std INT,
    name CHAR(10),
    PRIMARY KEY(rollno,std)
);

DESC student;

SHOW INDEXES FROM student;