## Apache Hive

> beeline -u jdbc:hive2://localhost:10000/edbda -n nilesh

### File Formats

* **ORC format**
```SQL
SHOW TABLES;

CREATE TABLE dept(
deptno INT,
dname STRING,
loc STRING
)
STORED AS ORC;

INSERT INTO dept
SELECT * FROM dept_staging;

SELECT * FROM dept LIMIT 5;

CREATE TABLE emp(
empno INT,
ename STRING,
job STRING,
mgr INT,
hire DATE,
sal DOUBLE,
comm DOUBLE,
deptno INT
)
STORED AS ORC;

INSERT INTO emp
SELECT * FROM emp_staging;

SELECT * FROM emp LIMIT 5;
```

* **Parquet**

```SQL
CREATE TABLE emp_parq(
empno INT,
ename STRING,
job STRING,
mgr INT,
hire DATE,
sal DOUBLE,
comm DOUBLE,
deptno INT
)
STORED AS PARQUET;

INSERT INTO emp_parq
SELECT * FROM emp_staging;

SELECT * FROM emp_parq LIMIT 5;
```

### RegEx -- in Linux
* Find by pattern
* Patterns given using Wildcard chars
    ```
    ^   start of line
    $   end of line
    .   any single char
    [a-zA-Z]    match any one char in given set
    [^a-zA-Z]    match any one char not in given set
    *   0 or more occurrences of prev char/group
    ---
    ?   0 or 1 occurrences of prev char/group
    +   1 or more occurrences of prev char/group
    {n}  n occurrences of prev char/group
    {,n}  max n occurrences of prev char/group
    {m,}  min m occurrences of prev char/group
    {m,n}  min m to max n occurrences of prev char/group
    (word1|word2|word3)  any group
    ```
* grep  -- works with basic wildcard 
* fgrep -- exact match (no wildcard)
* egrep -- works with basic and extended wildcard
* char classes in regex
    ```
    \d  [0-9]
    \w  [a-zA-Z]
    \s  spaces
    ```

#### Example 1
> cat > food.txt

    ```
    this
    biscuit
    isn't
    tasty,
    but
    that
    cake
    is
    really good
    ```
* Commands
    ```sh
    egrep "is" food.txt
    egrep "^is" food.txt
    egrep "is$" food.txt
    egrep "^is$" food.txt
    ```

#### Example 2
> cat > select.txt

    ```
    bag
    beg
    big
    bog
    bug
    b*g
    bg
    ```

* Commands
    ```sh
    egrep "b.g" select.txt
    egrep "b[a-z]g" select.txt
    egrep "b[aiu]g" select.txt
    egrep "b[^a-z]g" select.txt
    egrep "b\*g" select.txt
    fgrep "b*g" select.txt
    ```

#### Example 3
> cat > repeat.txt

    ```
    wow
    woow
    wooow
    woooow
    wooooow
    woooooow
    wooooooow
    woooooooow
    ww
    ```
* Commands
    ```sh
    egrep "wo*w" repeat.txt
    egrep "wo?w" repeat.txt
    egrep "wo+w" repeat.txt
    egrep "wo{3}w" repeat.txt
    egrep "wo{3,}w" repeat.txt
    egrep "wo{,3}w" repeat.txt
    egrep "wo{3,5}w" repeat.txt
    ```

#### Example 4
> cat > groups.txt

    ```
    hello
    dbda
    god
    bless
    you
    ```

* Commands
    ```sh
    egrep "(dbda|god|bless)" groups.txt
    ```

#### Example 5
> cat > phones.txt

    ```
    Mobiles
    9527331338
    9282938
    09881208115
    982392382932
    +919881208114
    ```

* Commands
    ```sh
    egrep "[0-9]{10}" phones.txt

    egrep "^[0-9]{10}$" phones.txt
    
    egrep "^0?[0-9]{10}$" phones.txt

    egrep "^(\+91)?[0-9]{10}$" phones.txt
    
    egrep "^(\+91|0)?[0-9]{10}$" phones.txt
    ```
#### Regex in Programming languages
* Builtin functions/classes APIs
* Capture groups
    * Ex1
        * Input: "James 007"
        * Regex: "([a-zA-Z]+) ([0-9]+)"
    * Ex2
        * Input: "0029028060999991910010120004+69100+027217FM-12+014999999V0201801N002119999999N0000001N9-01171+99999098081ADDGF100991999999999999999999"
        * Regex: "^.{15}([0-9]{4}).{68}([-\+][0-9]{4})([0-9]).*$"

### RegEx -- in Hive/MySQL

```SQL
CREATE TABLE contacts(name STRING, mobile STRING)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
STORED AS TEXTFILE;

INSERT INTO contacts VALUES
('P1', 'Mobiles'),
('P2', '9527331338'),
('P3', '9282938'),
('P4', '09881208115'),
('P5', '982392382932'),
('P6', '+919881208114');

SELECT * FROM contacts LIMIT 10;

SELECT * FROM contacts
WHERE mobile RLIKE '^(\\+91|0)?[0-9]{10}$';
```

### SerDes

* **CSV** -- OpenCSVSerde
    * empno, ename, address
        ```
        1, Nilesh, Pune
        2, Nitin, "Marketyard, Pune"
        3, James Bond \"7\", London
        ```
    * Properties
        * field delimiter -- ,
        * quote char -- "
        * escape char -- \

```SQL
DROP TABLE IF EXISTS movie_staging;

CREATE TABLE movie_staging(
movieid INT,
title STRING,
genres STRING
)
ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.OpenCSVSerde'
WITH SERDEPROPERTIES (
   'separatorChar' = ',',
   'quoteChar'     = '"',
   'escapeChar'    = '\\'
)
STORED AS TEXTFILE
TBLPROPERTIES ('skip.header.line.count'='1');

DESCRIBE FORMATTED movie_staging;

LOAD DATA LOCAL INPATH '/home/nilesh/dbda-aug24/BigData/private/movies/movies.csv'
INTO TABLE movie_staging;

SELECT * FROM  movie_staging LIMIT 15;
```

* **ROW FORMAT DELIMITED**
```SQL
CREATE TABLE rating_staging(
uid INT,
mid INT,
rating DOUBLE,
rtime BIGINT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
STORED AS TEXTFILE
TBLPROPERTIES ('skip.header.line.count'='1');

LOAD DATA LOCAL INPATH '/home/nilesh/dbda-aug24/BigData/private/movies/ratings.csv'
INTO TABLE rating_staging;

SELECT * FROM rating_staging LIMIT 10;
```

* **RegexSerDe**

```SQL
CREATE TABLE ncdc_staging (
yr SMALLINT,
temp SMALLINT,
quality TINYINT
)
ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.RegexSerDe'
WITH SERDEPROPERTIES (
  'input.regex' = '^.{15}([0-9]{4}).{68}([-\+][0-9]{4})([0-9]).*$'
)
STORED AS TEXTFILE;

LOAD DATA LOCAL INPATH '/home/nilesh/dbda-aug24/BigData/private/ncdc/'
INTO TABLE ncdc_staging;

SELECT * FROM ncdc_staging LIMIT 5;

SELECT * FROM ncdc_staging
WHERE temp != 9999
AND quality IN (0, 1, 2, 4, 5, 9)
LIMIT 5;

-- find yearly avg temp
SELECT yr, AVG(temp) avgtemp FROM ncdc_staging
WHERE temp != 9999
AND quality IN (0, 1, 2, 4, 5, 9)
GROUP BY yr;

-- find hottest and coolest year

(SELECT 'Cool' label, yr, AVG(temp) avgtemp FROM ncdc_staging
WHERE temp != 9999
AND quality IN (0, 1, 2, 4, 5, 9)
GROUP BY yr
ORDER BY avgtemp ASC
LIMIT 1)
UNION
(SELECT 'Hot' label, yr, AVG(temp) avgtemp FROM ncdc_staging
WHERE temp != 9999
AND quality IN (0, 1, 2, 4, 5, 9)
GROUP BY yr
ORDER BY avgtemp DESC
LIMIT 1);
```

### Hive Views

```SQL
CREATE VIEW v_ncdc AS
SELECT yr, AVG(temp) avgtemp FROM ncdc_staging
WHERE temp != 9999
AND quality IN (0, 1, 2, 4, 5, 9)
GROUP BY yr;


SHOW TABLES;

SHOW VIEWS;

DESCRIBE v_ncdc;

(SELECT 'Cool' label, yr, avgtemp
FROM v_ncdc
ORDER BY avgtemp ASC LIMIT 1)
UNION
(SELECT 'Hot' label, yr, avgtemp
FROM v_ncdc
ORDER BY avgtemp DESC LIMIT 1);
```

### Materialized View
* Materialized View store view query as well as computed data/result.
* Materialized View can be created only when
    * table is ORC
    * table is transactional.

```SQL
CREATE TABLE ncdc (
yr SMALLINT,
temp SMALLINT,
quality TINYINT
)
STORED AS ORC
TBLPROPERTIES('transactional'='true');

INSERT INTO ncdc
SELECT * FROM ncdc_staging;

CREATE MATERIALIZED VIEW mv_ncdc AS
SELECT yr, AVG(temp) avgtemp FROM ncdc
WHERE temp != 9999
AND quality IN (0, 1, 2, 4, 5, 9)
GROUP BY yr;

SHOW TABLES;

SHOW MATERIALIZED VIEWS;

DESCRIBE mv_ncdc;

DESCRIBE FORMATTED mv_ncdc;

(SELECT 'Cool' label, yr, avgtemp
FROM mv_ncdc
ORDER BY avgtemp ASC LIMIT 1)
UNION
(SELECT 'Hot' label, yr, avgtemp
FROM mv_ncdc
ORDER BY avgtemp DESC LIMIT 1);
```

```SQL
DELETE FROM ncdc WHERE yr = 1903;

SELECT * FROM  ncdc WHERE yr = 1903;

SELECT * FROM mv_ncdc;
-- still shows results from old data i.e. 1903 included in result

ALTER MATERIALIZED VIEW mv_ncdc REBUILD;
-- compute new results and overwrites materialized view results in hdfs

SELECT * FROM mv_ncdc;
-- show latest results

DROP MATERIALIZED VIEW mv_ncdc;
```

### DML operations in Hive

```SQL
UPDATE ncdc SET temp = temp + 10
WHERE yr = 1901;

ALTER TABLE ncdc COMPACT 'minor';

```