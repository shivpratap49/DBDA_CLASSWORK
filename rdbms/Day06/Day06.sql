-- Non Standard Joins
-- display empname and deptname of all the emps

SELECT e.ename,d.dname FROM emps e
JOIN depts d ON e.deptno = d.deptno;
-- default join is inner join

SELECT e.ename,d.dname FROM emps e
CROSS JOIN depts d ON e.deptno = d.deptno;

SELECT e.ename,d.dname FROM emps e
CROSS JOIN depts d WHERE e.deptno = d.deptno;

SELECT e.ename,d.dname FROM emps e,depts d 
WHERE e.deptno = d.deptno;

SELECT e.ename,d.dname FROM emps e
INNER JOIN depts d USING(deptno);

SELECT e.ename,d.dname FROM emps e
NATURAL JOIN depts d;

-- dislpay all possible depts for Amit and Nilesh
SELECT e.ename,d.dname FROM emps e
CROSS JOIN depts d WHERE e.ename IN('Amit','Nilesh');


-- DCL
SELECT USER();

PROMPT \u>

root> CREATE USER 'mgr'@'localhost' IDENTIFIED BY 'mgr';

root> SELECT user FROM mysql.user;

cmd> mysql -u mgr -p

mysql> PROMPT \u>

mgr> SHOW DATABASES;

root> SHOW DATABASES;

root> GRANT SELECT ON classwork_db.emp TO 'mgr'@'localhost';

mgr> SHOW DATABASES;
mgr> USE classwork_db;
mgr> SHOW TABLES;
mgr> SELECT * FROM emp;

-- provide the select permission on emps to the manager
root> GRANT SELECT ON classwork_db.emps TO 'mgr'@'localhost';

-- perform DML operations on emps table through mgr login
-- check the result
mgr>INSERT INTO emps(empno,ename) VALUES (6,'Yogesh');
--INSERT command denied to user

mgr>DELETE FROM emps WHERE id = 2;
--DELETE command denied to user

mgr>UPDATE emps SET deptno=40 WHERE empno = 4;
--UPDATE command denied to user

-- to check all the permission that mgr have
mgr> SHOW GRANTS

root> SHOW GRANTS FOR 'mgr'@'localhost'

-- provide the insert permission on emps to mgr
root>GRANT INSERT ON classwork_db.emps TO 'mgr'@'localhost';

mgr> SHOW GRANTS;

mgr>INSERT INTO emps(empno,ename) VALUES (6,'Yogesh');
-- OK

-- provide the UDPATE and DELETE permission on emps to mgr
root> GRANT UPDATE,DELETE ON classwork_db.emps TO 'mgr'@'localhost';

mgr> SHOW GRANTS;

mgr>DELETE FROM emps WHERE id = 6;
-- OK

--- Remopve the permission of the delete from mgr
root>REVOKE DELETE ON classwork_db.emps FROM 'mgr'@'localhost'; 

mgr> SHOW GRANTS;
mgr>DELETE FROM emps WHERE id = 5;
-- DELETE command denied to user

-- provide all permission on the books table to mgr
GRANT ALL PRIVILEGES ON classwork_db.books TO 'mgr'@'localhost';

-- perform all the operations on books table through mgr
mgr> SHOW GRANTS;
mgr> SHOW TABLES;
mgr> SELECT * FROM books;
-- TEST all the DML operations
-- Also check Truncate and Drop

-- can mgr create a table?
-- NO

-- provide all permissions on the classwork database to the mgr
root> GRANT ALL PRIVILEGES ON classwork_db.* TO 'mgr'@'localhost';

mgr> SHOW GRANTS;

-- If permission are not refreshed then use the classwork_db once again
mgr> SHOW TABLES;

-- is the manager able to cretae the table?
-- YES

-- Can manager create another user?
mgr> CREATE USER 'dev'@'localhost' IDENTIFIED BY 'dev';

mgr> REVOKE DELETE ON classwork_db.depts FROM 'mgr'@'localhost';

-- delete the user mgr
root> DROP USER 'mgr'@'localhost';

root> SELECT user FROM mysql.user;

root> SELECT user,host FROM mysql.user;

-- Create the below users from root
CREATE USER 'mgr'@'localhost' IDENTIFIED BY 'mgr';

CREATE USER teamlead IDENTIFIED BY 'teamlead';

CREATE USER dev IDENTIFIED BY 'dev';

root> GRANT ALL PRIVILEGES ON classwork_db.* TO 'mgr'@'localhost' WITH GRANT OPTION;

mgr> SHOW GRANTS;

mgr> GRANT ALL PRIVILEGES ON classwork_db.emps TO teamlead;
mgr> GRANT ALL PRIVILEGES ON classwork_db.depts TO teamlead;
mgr> GRANT ALL PRIVILEGES ON classwork_db.addr TO teamlead;

mgr> GRANT SELECT, INSERT ON classwork_db.emps TO dev; 


-- Transactions
-- mysql supports ACID Transactions
-- A - Atomicity
-- C - Consistency
-- I - Isolation
-- D - Durability

-- TCL
-- START TRANSACTION
-- SAVEPOINT
-- ROLLBACK
-- COMMIT

CREATE TABLE accounts(accno INT, type VARCHAR(10), balance DOUBLE);
INSERT INTO accounts VALUES(1,"SAVINGS",10000);
INSERT INTO accounts VALUES(2,"CURRENT",20000);
INSERT INTO accounts VALUES(3,"SAVINGS",30000);
INSERT INTO accounts VALUES(4,"SAVINGS",25000);
INSERT INTO accounts VALUES(5,"CURRENT",45000);

-- provide all persmission on the accounts to the tealead
GRANT ALL PRIVILEGES ON classwork_db.accounts TO teamlead;

START TRANSACTION;
UPDATE accounts SET balance = balance-15000 WHERE accno = 1;
SELECT * FROM accounts;
ROLLBACK;

SELECT * FROM accounts;

SELECT @@autocommit; -- 1
SET @@autocommit=0;
SELECT @@autocommit; -- 0

UPDATE accounts SET balance = 15000 WHERE accno = 2;
ROLLBACK;
SELECT * FROM accounts;

UPDATE accounts SET balance = 15000 WHERE accno = 2;
COMMIT;
SELECT * FROM accounts;

SET @@autocommit=1;

START TRANSACTION;
UPDATE accounts SET balance = balance-5000 WHERE accno = 5;
UPDATE accounts SET balance = balance+5000 WHERE accno = 20;
SELECT * FROM accounts;
ROLLBACK;

START TRANSACTION;
UPDATE accounts SET balance = balance-5000 WHERE accno = 5;
UPDATE accounts SET balance = balance+5000 WHERE accno = 2;
SELECT * FROM accounts;
COMMIT;

START TRANSACTION;
UPDATE accounts SET balance = balance-5000 WHERE accno = 3;
SAVEPOINT sp1;
UPDATE accounts SET balance = balance-3000 WHERE accno = 2;
SAVEPOINT sp2;
UPDATE accounts SET balance = balance+3000 WHERE accno = 40;
ROLLBACK TO sp2;
UPDATE accounts SET balance = balance+3000 WHERE accno = 4;
ROLLBACK TO sp1;
COMMIT;

teamlead> UPDATE accounts SET balance = 15000 WHERE accno = 1;
teamlead> SELECT * FROM accounts;

mgr> SELECT * FROM accounts;

teamlead> START TRANSACTION;
teamlead> UPDATE accounts SET balance = 25000 WHERE accno = 2;
teamlead>SELECT * FROM accounts;

mgr>SELECT * FROM accounts;

teamlead>COMMIT;

mgr>SELECT * FROM accounts;

teamlead> START TRANSACTION;
teamlead> UPDATE accounts SET balance = 30000 WHERE accno = 2;
teamlead>SELECT * FROM accounts;
mgr>SELECT * FROM accounts;
mgr>UPDATE accounts SET balance = 30000 WHERE accno = 2;
--Lock wait timeout exceeded; try restarting transaction

tealead> ROLLBACK;
mgr>UPDATE accounts SET balance = 30000 WHERE accno = 2; -- OK

teamlead> START TRANSACTION;
teamlead> UPDATE accounts SET balance = balance-5000 WHERE accno = 3;
teamlead>SELECT * FROM accounts;
mgr>SELECT * FROM accounts;
teamlead> START TRANSACTION; 
-- prior transaction is commmited
teamlead>SELECT * FROM accounts;
mgr>SELECT * FROM accounts;


teamlead> START TRANSACTION;
teamlead> UPDATE accounts SET balance = balance-5000 WHERE accno = 3;
teamlead>SELECT * FROM accounts;
mgr>SELECT * FROM accounts;
mgr> UPDATE accounts SET balance = balance-5000 WHERE accno = 3;
-- waiting...
tealead> COMMIT;
teamlead>SELECT * FROM accounts;
mgr>SELECT * FROM accounts;

teamlead> START TRANSACTION;
teamlead> UPDATE accounts SET balance = balance-10000 WHERE accno = 5;
teamlead>SELECT * FROM accounts;

mgr> UPDATE accounts SET balance = balance+8000 WHERE accno = 1;
-- waiting...

tealead> COMMIT;
teamlead>SELECT * FROM accounts;
mgr>SELECT * FROM accounts;


teamlead> START TRANSACTION;
teamlead> UPDATE books SET price = balance+100 WHERE id = 1001;
teamlead> SELECT id,name,price FROM books;

mgr> SELECT id,name,price FROM books;
mgr> UPDATE books SET price = balance-50 WHERE id = 4003;
-- OK
mgr> SELECT id,name,price FROM books;
mgr> UPDATE books SET price = balance+100 WHERE id = 1001;
-- waiting

-- Whenever a table contains a primary key then in the transaction only
-- the row/s that are having Update and delete operations gets locked
-- If the table does not have a primary key then the whole table gets locked. 


-- Pessimistic Locking
-- If we want to lock the table/rows within the transaction before updating/deleting
-- then we can do it bby using the pessimistic locking.
SELECT * FROM accounts FOR UPDATE;