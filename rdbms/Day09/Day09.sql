-- Surrogate Primary Key
CREATE TABLE temp5(id INT PRIMARY KEY AUTO_INCREMENT, name CHAR(15));

INSERT INTO temp5(name) VALUES('Anil');

SELECT * FROM temp5;

INSERT INTO temp5(name) VALUES('Mukesh');
INSERT INTO temp5(name) VALUES('Ramesh');

INSERT INTO temp5 VALUES(10,'Suresh');

INSERT INTO temp5(name) VALUES('Ram');
INSERT INTO temp5 VALUES(5,'Sham');
INSERT INTO temp5(name) VALUES('Prasad');

ALTER TABLE temp5 AUTO_INCREMENT = 1001;

INSERT INTO temp5(name) VALUES('Pratik');

-- 4. Foreign Key
DROP DATABASE classwork_db;

CREATE DATABASE classwork_db;
USE classwork_db;

CREATE TABLE dept(
    deptno INT PRIMARY KEY,
    dname CHAR(15)
);

CREATE TABLE emp(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name CHAR(10),
    deptno INT,
    FOREIGN KEY(deptno) REFERENCES dept(deptno)
);

SELECT * FROM dept;
SELECT * FROM emp;

INSERT INTO emp(name,deptno) VALUES('Anil',10);
-- Cannot add or update a child row: a foreign key constraint fails

INSERT INTO dept VALUES(10, 'DEV');
INSERT INTO dept VALUES(20, 'OPS');
INSERT INTO dept VALUES(30, 'QA');
INSERT INTO dept VALUES(40, 'ACC');

INSERT INTO emp(name,deptno) VALUES('Anil',10);
INSERT INTO emp(name,deptno) VALUES('Mukesh',20);

INSERT INTO emp(name,deptno) VALUES('Ramesh',50);
-- Cannot add or update a child row: a foreign key constraint fails

INSERT INTO emp(name,deptno) VALUES('Ramesh',20);
INSERT INTO emp(name,deptno) VALUES('Suresh',40);

DESC emp;
DESC dept;

SHOW INDEXES FROM emp;
SHOW INDEXES FROM dept;

SHOW CREATE TABLE emp;
SHOW CREATE TABLE dept;

CREATE TABLE addr(
    id INT PRIMARY KEY AUTO_INCREMENT,
    tal CHAR(15),
    dist CHAR(15),
    empid INT UNIQUE,
    FOREIGN KEY (empid) REFERENCES emp(id)
);

INSERT INTO addr(tal,dist,empid) VALUES('Wai','Satara',2);

INSERT INTO addr(tal,dist) VALUES('Wai','Satara');

DESC addr;
SHOW INDEXES FROM addr;

DELETE FROM addr WHERE id = 1;
TRUNCATE TABLE addr;
DROP TABLE addr;

DELETE FROM dept WHERE deptno = 10;
--  Cannot delete or update a parent row: a foreign key constraint fails

DELETE FROM dept WHERE deptno = 30;
--- OK as no matching row is present in to the emp table

TRUNCATE TABLE dept;
-- Cannot truncate a table referenced in a foreign key constraint 

DROP TABLE dept;
-- Cannot drop table 'dept' referenced by a foreign key constraint

UPDATE dept SET deptno = 30 WHERE deptno = 40;
-- Cannot delete or update a parent row: a foreign key constraint fails

TRUNCATE TABLE emp;
DROP TABLE emp;

TRUNCATE TABLE dept;
DROP TABLE dept;

CREATE TABLE dept(
    deptno INT PRIMARY KEY,
    dname CHAR(15)
);

CREATE TABLE emp(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name CHAR(10),
    deptno INT,
    FOREIGN KEY(deptno) REFERENCES dept(deptno) 
    ON DELETE CASCADE ON UPDATE CASCADE
);


INSERT INTO dept VALUES(10, 'DEV');
INSERT INTO dept VALUES(20, 'OPS');
INSERT INTO dept VALUES(30, 'QA');
INSERT INTO dept VALUES(40, 'ACC');

INSERT INTO emp(name,deptno) VALUES('Anil',10);
INSERT INTO emp(name,deptno) VALUES('Mukesh',20);
INSERT INTO emp(name,deptno) VALUES('Ramesh',20);
INSERT INTO emp(name,deptno) VALUES('Suresh',30);
INSERT INTO emp(name,deptno) VALUES('Ram',40);

DELETE FROM dept WHERE deptno = 30;

-- update the deptno to 50 of emp with id 5 
UPDATE emp SET deptno = 50 WHERE id = 5;
-- Cannot add or update a child row: a foreign key constraint fails 

-- update the deptno to 50 where deptno is 40 (use dept table)
UPDATE dept SET deptno = 50 WHERE deptno = 40;

CREATE TABLE student(
    rollno INT,
    std INT,
    name CHAR(15),
    PRIMARY KEY (rollno,std)
);

INSERT INTO student VALUES (1,1,'Anil');
INSERT INTO student VALUES (1,2,'Mukesh');
INSERT INTO student VALUES (1,3,'Ramesh');
INSERT INTO student VALUES (2,1,'Suresh');
INSERT INTO student VALUES (2,2,'Sham');

SELECT * FROM student;

CREATE TABLE marks(
    rollno INT,
    std INT,
    maths INT,
    science INT,
    FOREIGN KEY (rollno,std) REFERENCES student(rollno,std)
    ON DELETE CASCADE ON UPDATE CASCADE
);


INSERT INTO marks VALUES (1,1,40,50);
INSERT INTO marks VALUES (1,2,50,60);
INSERT INTO marks VALUES (1,3,70,80);

INSERT INTO marks VALUES (2,3,80,90);
-- Cannot add or update a child row: a foreign key constraint fails


DROP TABLE marks;

CREATE TABLE marks(
    rollno INT,
    std INT,
    maths INT,
    science INT,
    PRIMARY KEY(rollno,std),
    FOREIGN KEY (rollno,std) REFERENCES student(rollno,std)
    ON DELETE CASCADE ON UPDATE CASCADE
);


-- Self Refrentail FK
CREATE TABLE emps(
    id INT PRIMARY KEY,
    name CHAR(15),
    salary DOUBLE,
    mgr INT,
    FOREIGN KEY (mgr) REFERENCES emps(id)
);

INSERT INTO emps VALUES(1,"Anil",10000,2);
-- Cannot add or update a child row: a foreign key constraint fails

INSERT INTO emps VALUES(1,"Mukesh",50000,NULL);
INSERT INTO emps VALUES(2,"Anil",40000,1);
INSERT INTO emps VALUES(3,"Ramesh",30000,2);
INSERT INTO emps VALUES(4,"Suresh",20000,2);

CREATE TABLE dept_backup(
    deptno INT PRIMARY KEY,
    dname CHAR(15)
);

SELECT * FROM dept_backup;
INSERT INTO dept_backup SELECT * FROM dept;

CREATE TABLE emp_backup(
    id INT PRIMARY KEY,
    name CHAR(10),
    deptno INT,
    FOREIGN KEY(deptno) REFERENCES dept_backup(deptno)
);

DELETE FROM dept_backup;
INSERT INTO emp_backup SELECT * FROM emp;
-- NOT POSSIBLE 

SELECT @@foreign_key_checks;
SET @@foreign_key_checks=0;
INSERT INTO emp_backup SELECT * FROM emp;
-- OK

INSERT INTO emp VALUES (6,'Suresh', 40);
--OK

SET @@foreign_key_checks=1;
INSERT INTO emp VALUES (7,'Sham', 40);
-- NOT OK

-- 5. CHECK Constraint
CREATE TABLE employee(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name CHAR(15) CHECK (LENGTH(name) > 1),
    age INT CHECK (age>18),
    salary DOUBLE CHECK (salary>1000)
); 

INSERT INTO employee(name,age,salary) VALUES('B',16, 500);
-- Check constraint 'employee_chk_1' is violated

INSERT INTO employee(name,age,salary) VALUES('Anil',16, 500);
-- Check constraint 'employee_chk_2' is violated

INSERT INTO employee(name,age,salary) VALUES('Anil',26, 500);
-- Check constraint 'employee_chk_3' is violated.

INSERT INTO employee(name,age,salary) VALUES('Anil',26, 1500);
-- OK
SHOW CREATE TABLE employee;

CREATE TABLE emp_temp(
    id INT PRIMARY KEY,
    salary DOUBLE,
    deptno INT,
    CONSTRAINT chk_salary CHECK (salary>1000),
    CONSTRAINT fk_deptno FOREIGN KEY (deptno) REFERENCES dept(deptno)
);

SHOW CREATE TABLE emp_temp;
DESC emp_temp;
SHOW INDEXES FROM emp_temp;

DROP TABLE emp_temp;

CREATE TABLE emp_temp(
    id INT,
    salary DOUBLE,
    email VARCHAR(50),
    deptno INT,
    CONSTRAINT pk_id PRIMARY KEY(id),
    CONSTRAINT chk_salary CHECK (salary>1000),
    CONSTRAINT uni_email UNIQUE (email),
    CONSTRAINT fk_deptno FOREIGN KEY (deptno) REFERENCES dept(deptno)
);

-- ALTER
DROP DATABASE classwork_db;
CREATE DATABASE classwork_db;
USE classwork_db;

CREATE TABLE dept(
    deptno INT,
    dname CHAR(15)
);

CREATE TABLE emp(
    id INT,
    name CHAR(15),
    deptno INT
);

INSERT INTO dept VALUES(10, 'DEV');
INSERT INTO dept VALUES(20, 'OPS');
INSERT INTO dept VALUES(30, 'QA');
INSERT INTO dept VALUES(40, 'ACC');

INSERT INTO emp VALUES (1,'Anil',10);
INSERT INTO emp VALUES (2,'Mukesh',20);
INSERT INTO emp VALUES (3,'Ramesh',30);
INSERT INTO emp VALUES (4,'Suresh',40);

SELECT * FROM emp;
SELECT * FROM dept;

-- add the column job in the emp table
ALTER TABLE emp ADD COLUMN job CHAR(20);

SELECT * FROM emp;
DESC emp;
SHOW CREATE TABLE emp;

-- add job as dev to dept 20 and 40 and ops for 10 and 30
UPDATE emp SET job = 'DEV' WHERE deptno IN (20,40);
UPDATE emp SET job = 'OPS' WHERE deptno IN (10,30);

-- change the type of col from char to varchar(10)
ALTER TABLE emp MODIFY job VARCHAR(10);
DESC emp;
SHOW CREATE TABLE emp;

-- change the type of job from varchar to INT
ALTER TABLE emp MODIFY job INT;
--error Incorrect integer value: 'OPS'

-- change the col name of id to empno
ALTER TABLE emp CHANGE id empno INT;

ALTER TABLE emp RENAME COLUMN empno TO id;

-- add primary key to the emp table on id
ALTER TABLE emp ADD PRIMARY KEY (id);
DESC emp;

-- add primary key to the dept table on deptno
ALTER TABLE dept ADD PRIMARY KEY (deptno);
DESC dept;

-- add foreign key to the emp table on deptno
ALTER TABLE emp ADD FOREIGN KEY(deptno) REFERENCES dept(deptno);

-- delete the column job
ALTER TABLE emp DROP COLUMN job;

-- remove foreign key constarints from the emp table
ALTER TABLE emp DROP CONSTRAINT emp_ibfk_1;
DESC emp;
SHOW CREATE TABLE emp;
SHOW INDEXES FROM emp;
INSERT INTO emp VALUES(5,'Ram',50);
-- OK

DROP INDEX deptno ON emp;

-- remove the primary key from emp
ALTER TABLE emp DROP PRIMARY KEY;

INSERT INTO emp(id) VALUES(NULL);