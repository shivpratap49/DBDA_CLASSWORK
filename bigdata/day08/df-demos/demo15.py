
# Spark SQL -- Read Tables

from pyspark.sql import SparkSession
from pyspark.sql.functions import *

spark = SparkSession.builder \
            .config("spark.sql.shuffle.partitions", "2") \
            .config("spark.sql.warehouse.dir", "file:///home/nilesh/bigdata/spark-warehouse")\
            .appName("demo15") \
            .enableHiveSupport() \
            .getOrCreate()

# show spark database
dbs = spark.catalog.listDatabases()
for db in dbs:
    print(f"Spark Db: {db.name}, Location: {db.locationUri}")

# show spark tables
tables = spark.catalog.listTables("default")
for tbl in tables:
    print(f"Spark Table: {tbl}")

# describe spark table
columns = spark.catalog.listColumns("emp", "default")
for col in columns:
    print(f"emp Table Column: {col}")

# read spark table as df
emp = spark.read.table("default.emp")
emp.show()

# execute sql query on spark table
result = spark.sql("SELECT deptno, SUM(sal) FROM emp_dept_part_bucketed GROUP BY deptno")
result.show()

spark.stop()

