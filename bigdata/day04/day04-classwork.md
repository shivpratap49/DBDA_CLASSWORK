## Apache Hive

### Python Hive Connectivity
* terminal> sudo apt install python3-dev libsasl2-dev python3-pip libsasl2-modules
* terminal> pip3 install thrift sasl thrift_sasl
* terminal> pip3 install pyhive

```python
from pyhive import hive

# hive config
host_name = 'localhost'
port = 10000
user = 'nilesh'
password = ''
db_name = 'edbda'

# get hive connection
conn = hive.Connection(host=host_name, port=port, username=user, password=password, database=db_name, auth='CUSTOM')

# get the cursor object
cur = conn.cursor()

# execute the sql query using cursor
sal = input('Enter minimum salary: ')
sql = "SELECT * FROM emp WHERE sal > " + str(sal)
cur.execute(sql)

# collect/process result
result = cur.fetchall()
for row in result:
    print(row)

# close the connection
conn.close()
```

### External Tables

* Managed Table
    - Data in HDFS Hive warehouse directory.
    - Metadata in Metastore.
    - When table dropped, data from hdfs is deleted as well as metadata from metastore is deleted.

```SQL
SHOW TABLES;

DESCRIBE emp_staging;

SELECT * FROM emp_staging LIMIT 5;

DROP TABLE emp_staging;
-- delete metadata + data

SHOW TABLES;
```

* External tables
    - Data in HDFS (not in hive warehouse).
    - Metadata in Metastore

> hadoop fs -mkdir -p /user/$USER/emp/input

> hadoop fs -put /home/nilesh/dbda-aug24/BigData/data/emp.csv /user/$USER/emp/input

> hadoop fs -ls /user/$USER/emp/input

```SQL
CREATE EXTERNAL TABLE emp_staging(
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
STORED AS TEXTFILE
LOCATION '/user/nilesh/emp/input/';

SELECT * FROM emp_staging
LIMIT 15;

SELECT deptno, AVG(sal) FROM emp_staging
GROUP BY deptno;
```

```SQL
CREATE EXTERNAL TABLE emp_staging2(
empno INT,
ename STRING,
job STRING,
mgr INT,
hire DATE,
sal DECIMAL(7,2),
comm DECIMAL(7,2),
deptno INT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
STORED AS TEXTFILE
LOCATION '/user/nilesh/emp/input/';

SELECT * FROM emp_staging2
LIMIT 15;

SELECT deptno, AVG(sal) FROM emp_staging2
GROUP BY deptno;

DESCRIBE FORMATTED emp_staging2;

DROP TABLE emp_staging2;
-- only deletes metadata
-- data in hdfs is intact.

SHOW TABLES;

SELECT * FROM emp_staging LIMIT 15;
-- other external tables can still access
-- that data
```

```SQL
-- add more emps into table
LOAD DATA LOCAL INPATH '/home/nilesh/dbda-aug24/BigData/data/emp.csv'
INTO TABLE emp_staging;
-- if data is already present, new data is appened (may cause duplication)

SELECT * FROM emp_staging LIMIT 30;

-- first remove old emeps and then add more emps into table
LOAD DATA LOCAL INPATH '/home/nilesh/dbda-aug24/BigData/data/emp.csv'
OVERWRITE INTO TABLE emp_staging;

SELECT * FROM emp_staging LIMIT 30;
```

### Json Data (+External Table)

> hadoop fs -mkdir -p /user/$USER/books/input

> hadoop fs -put /home/nilesh/dbda-aug24/BigData/data/books.json /user/$USER/books/input

> hadoop fs -ls /user/$USER/books/input

```SQL
CREATE EXTERNAL TABLE books_json (
id INT,
name STRING,
author STRING,
subject STRING,
price DOUBLE
)
ROW FORMAT SERDE 'org.apache.hive.hcatalog.data.JsonSerDe'
STORED AS TEXTFILE
LOCATION '/user/nilesh/books/input';

DESCRIBE FORMATTED books_json;

SELECT * FROM books_json LIMIT 15;
```

### 

* find num of movies of given genre.

```SQL
SELECT movieid, title, genres FROM movie_staging LIMIT 5;

SELECT movieid, title, SPLIT(genres, '\\|') FROM movie_staging LIMIT 5;

CREATE TABLE movies (
movieid INT,
title STRING,
genres ARRAY<STRING>
)
STORED AS ORC;

DESCRIBE movies;

INSERT INTO movies
SELECT movieid, title, SPLIT(genres, '\\|') FROM movie_staging;

SELECT * FROM movies
LIMIT 5;

SELECT COUNT(*) FROM movies
WHERE ARRAY_CONTAINS(genres, 'Romance');
```

* count movies per genre.

```SQL
-- works in spark sql
SELECT movieid, title, EXPLODE(genres) genre FROM movies;

SELECT EXPLODE(genres) FROM movies
LIMIT 10;

SELECT movieid, title, genre FROM movies
LATERAL VIEW EXPLODE(genres) genres_tbl AS genre
LIMIT 10;

SELECT genre, COUNT(*) cnt FROM movies
LATERAL VIEW EXPLODE(genres) genres_tbl AS genre 
GROUP BY genre;
```

* count occurrences of words in a text file.

> hadoop fs -mkdir -p /user/$USER/worcount/input

> hadoop fs -put /home/nilesh/dbda-aug24/hadoop-3.3.2/LICENSE.txt /user/$USER/worcount/input

> hadoop fs -ls /user/$USER/worcount/input

```SQL
CREATE EXTERNAL TABLE license(
line STRING
)
STORED AS TEXTFILE
LOCATION '/user/nilesh/wordcount/input';

SELECT * FROM license
LIMIT 10;

SELECT LOWER(line) FROM license
LIMIT 10;

SELECT SPLIT(LOWER(line), '[^a-z]') FROM license
LIMIT 10;

SELECT EXPLODE(SPLIT(LOWER(line), '[^a-z]')) word FROM license
LIMIT 100;

WITH words AS (
SELECT EXPLODE(SPLIT(LOWER(line), '[^a-z]')) word FROM license
)
SELECT word FROM words
WHERE word NOT IN ('')
LIMIT 10;


WITH words AS (
SELECT EXPLODE(SPLIT(LOWER(line), '[^a-z]')) word FROM license
)
SELECT word, COUNT(*) cnt FROM words
WHERE word NOT IN ('', 'a', 'an', 'the', 'as', 'in', 'under', 'for', 'by', 'on', 'over', 'above')
GROUP BY word
LIMIT 10;


WITH words AS (
SELECT EXPLODE(SPLIT(LOWER(line), '[^a-z]')) word FROM license
)
SELECT word, COUNT(*) cnt FROM words
WHERE word NOT IN ('', 'a', 'an', 'the', 'as', 'in', 'under', 'for', 'by', 'on', 'over', 'above')
GROUP BY word
ORDER BY cnt DESC
LIMIT 10;
```



