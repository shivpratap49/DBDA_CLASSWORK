CREATE TABLE accounts(
    accno INT PRIMARY KEY,
    balane DOUBLE,
    acc_type VARCHAR(10) 
);

INSERT INTO accounts VALUES(1001,7000,"SAVINGS");
INSERT INTO accounts VALUES(1002,14000,"CURRENT");
INSERT INTO accounts VALUES(1003,21000,"SAVINGS");
INSERT INTO accounts VALUES(1004,28000,"CURRENT");

SELECT * FROM accounts;

CREATE TABLE transactions(
    txid INT PRIMARY KEY AUTO_INCREMENT,
    accno INT,
    amount DOUBLE,
    tx_type CHAR(10)
);

INSERT INTO transactions(accno,amount,tx_type) VALUES(1001,1000,"Deposit");
INSERT INTO transactions(accno,amount,tx_type) VALUES(1002,2000,"Withdraw");

DROP TABLE transactions;

CREATE TABLE transactions(
    txid INT PRIMARY KEY AUTO_INCREMENT,
    accno INT,
    amount DOUBLE,
    tx_type CHAR(10),
    status CHAR(10)
);
INSERT INTO transactions(accno,amount,tx_type) VALUES(1001,1000,"Deposit");


INSERT INTO emp(empno,ename,sal) VALUES(8000,'John',3500);
SELECT * FROM emp;

-- display empname of all emps with first letter 
-- as capital and rest all in small case

SELECT ename FROM emp;

SELECT CONCAT(UPPER(LEFT(ename,1)), LOWER(SUBSTRING(ename,2))) FROM emp;