# Apache Spark

## Spark JDBC Data Format
* Database: MySQL
* Download MySQL JDBC Driver: https://mvnrepository.com/artifact/com.mysql/mysql-connector-j/8.4.0
* Copy JAR into $SPARK_HOME/jars directory.

## MySQL Window Functions

```SQL
SELECT ename, deptno, sal,
ROW_NUMBER() OVER (ORDER BY sal) sr,
RANK() OVER (ORDER BY sal) rnk,
DENSE_RANK() OVER (ORDER BY sal) drnk
FROM emp;

SELECT ename, deptno, sal,
ROW_NUMBER() OVER (wnd) sr,
RANK() OVER (wnd) rnk,
DENSE_RANK() OVER (wnd) drnk
FROM emp
WINDOW wnd AS (ORDER BY sal);


SELECT ename, deptno, sal,
ROW_NUMBER() OVER (wnd) sr,
RANK() OVER (wnd) rnk,
DENSE_RANK() OVER (wnd) drnk
FROM emp
WINDOW wnd AS (PARTITION BY deptno ORDER BY sal);
```

## Spark Tables (using Dataframes)
* Create a "conf" directory in "pyspark" python package directory e.g. /home/nilesh/.local/lib/python3.12/site-packages/pyspark
* Create file hive-site.xml in pyspark/conf directory. Change the paths of metastore and warehouse as per your machine setup.
    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
    <configuration>
        <property>
            <name>javax.jdo.option.ConnectionURL</name>
            <value>jdbc:derby:;databaseName=/home/nilesh/bigdata/metastore_db;create=true</value>
        </property>
        <property>
            <name>javax.jdo.option.ConnectionDriverName</name>
            <value>org.apache.derby.jdbc.EmbeddedDriver</value>
        </property>
        <property>
            <name>javax.jdo.PersistenceManagerFactoryClass</name>
            <value>org.datanucleus.api.jdo.JDOPersistenceManagerFactory</value>
        </property>
        <property>
            <name>spark.sql.warehouse.dir</name>
            <value>file:///home/nilesh/bigdata/spark-warehouse</value>
        </property>
    </configuration>
    ```
* In dataframe code, create spark session using enableHiveSupport() and spark warehouse directory configuration. Change path of spark warehouse as per your system setup.
    ```python
    spark = SparkSession.builder \
            .config('spark.sql.warehouse.dir', 'file:///home/nilesh/bigdata/spark-warehouse')\
            .enableHiveSupport() \
            .getOrCreate()
    ```

## Spark SQL Setup (on Linux) with Derby Metastore
* Build Spark single-node cluster.
    * Download spark and extract it.
    * In ~/.bashrc, set SPARK_HOME and PATH.
    * Setup single-node cluster settings spark-defaults.conf and spark-env.sh and workers
        * spark-defaults.conf
            * spark.master  spark://localhost:7077
            * spark.sql.warehouse.dir  file:///home/nilesh/bigdata/spark-warehouse
        * spark-env.sh
            * export SPARK_MASTER_HOST=localhost
            * export SPARK_LOCAL_IP=localhost
        * workers
            * localhost
* Copy hive-site.xml in $SPARK_HOME/conf.
    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
    <configuration>
        <property>
            <name>javax.jdo.option.ConnectionURL</name>
            <value>jdbc:derby:;databaseName=/home/nilesh/bigdata/metastore_db;create=true</value>
        </property>
        <property>
            <name>javax.jdo.option.ConnectionDriverName</name>
            <value>org.apache.derby.jdbc.EmbeddedDriver</value>
        </property>
        <property>
            <name>javax.jdo.PersistenceManagerFactoryClass</name>
            <value>org.datanucleus.api.jdo.JDOPersistenceManagerFactory</value>
        </property>
        <property>
            <name>spark.sql.warehouse.dir</name>
            <value>file:///home/nilesh/bigdata/spark-warehouse</value>
        </property>
    </configuration>
    ```
* Start Master and Workers.
    * terminal> start-master.sh
    * terminal> start-workers.sh
* Start ThriftServer.
    * terminal> start-thriftserver.sh
    * terminal> netstat -tln | grep "10000"
    * Internally creates spark-warehouse directory and spark metastore_db (in Hive metastore format).
* Start beeline.
    * terminal> beeline -u jdbc:hive2://localhost:10000 -n $USER

### Spark SQL queries

```SQL
SHOW DATABASES;

SHOW TABLES;

DESCRIBE emp;

SELECT * FROM emp;

SELECT job, SUM(sal) FROM emp
GROUP BY job;
```

```SQL
CREATE DATABASE classwork;

SHOW DATABASES;

USE classwork;

CREATE TABLE hbooks(
id INT,
name STRING,
author STRING,
subject STRING,
price DOUBLE
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
STORED AS TEXTFILE;

SHOW TABLES;

DESCRIBE hbooks;

-- to load data into hive tables
-- load it using load data query
LOAD DATA LOCAL INPATH
'/home/nilesh/dbda-aug24/BigData/data/books.csv'
INTO TABLE hbooks;

SELECT * FROM hbooks LIMIT 5;

SELECT subject, SUM(price) FROM hbooks
GROUP BY subject;
```

```SQL
CREATE TABLE sbooks(
id INT,
name STRING,
author STRING,
subject STRING,
price DOUBLE
)
USING csv;

DESCRIBE FORMATTED sbooks;

-- to load data into spark tables
-- load it from another table
INSERT INTO sbooks
SELECT * FROM hbooks;

SELECT * FROM sbooks LIMIT 5;

SELECT subject, SUM(price) FROM sbooks
GROUP BY subject;

EXPLAIN
SELECT subject, SUM(price) FROM sbooks
GROUP BY subject;

EXPLAIN EXTENDED
SELECT subject, SUM(price) FROM sbooks
GROUP BY subject;

DROP TABLE sbooks;
-- drops table data as well structure
-- managed table

SHOW TABLES;
```

```SQL
-- for external demo first do the following steps
-- cmd> mkdir /tmp/movies
-- cmd> cp /home/nilesh/dbda-aug24/BigData/private/movies/movies.csv /tmp/movies

CREATE EXTERNAL TABLE movies(
movieId INT,
title STRING,
genres STRING
)
USING csv
OPTIONS(
path 'file:///tmp/movies',
header true
);

SHOW TABLES;

DESCRIBE FORMATTED movies;

SELECT * FROM movies LIMIT 15;
```

```SQL
SELECT movieId, title, EXPLODE(SPLIT(genres, '\\|')) genre FROM movies LIMIT 10;

CREATE OR REPLACE VIEW movie_genres AS
SELECT movieId, title, EXPLODE(SPLIT(genres, '\\|')) genre FROM movies;

SHOW TABLES;

SHOW VIEWS;

DESCRIBE FORMATTED movie_genres;

SELECT genre, COUNT(1) cnt FROM movie_genres
GROUP BY  genre;
```

```SQL
DROP TABLE movies;
-- deletes metadata from metastore
-- table data is not deleted /tmp/movies

SELECT * FROM movie_genres;
-- error

DROP VIEW movie_genres;
```

```SQL
DROP DATABASE classwork;
-- cannot drop non-empty db.

SHOW TABLES;

!quit
```

## Stop Spark SQL

> stop-thriftserver.sh

> stop-workers.sh

> stop-master.sh

* Comment SPARK_HOME and PATH from ~/.bashrc.

> echo $SPARK_HOME

## Data Bricks Community Edition


```python
from pyspark.sql.functions import *
```


```python
wordsPath = '/FileStore/tables/wordcount/'
df = spark.read.text(wordsPath)
df.printSchema()
```

```python
df.show(truncate=False, n=10)
```

```python
words = df.selectExpr("EXPLODE(SPLIT(LOWER(value), '[^a-z0-9]')) word")
words.printSchema()

words.show(n=50)
```

```python
result = words\
    .where("word NOT IN ('', 'this', 'that', 'by', 'in')") \
    .groupBy('word').count() \
    .orderBy('count', ascending=False) \
    .limit(20)

result.printSchema()
```

```python
display(result)
# result.show()
```

```python
result.createOrReplaceTempView('wordcnt_result')
```

```python
%sql

SELECT * FROM wordcnt_result ORDER BY count DESC;
```
