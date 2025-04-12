# option nullValue = NULL => if NULL is in dataset, consider it as NULL.
# read mode => PERMISSIVE*, DROPMALFORMED, FAILFAST
# computed column
# columns & expressions

from pyspark.sql import SparkSession
from pyspark.sql.functions import *

# create spark session
spark = SparkSession.builder\
            .appName("demo04")\
            .config("spark.sql.shuffle.partitions", "2")\
            .getOrCreate()

# dataframe creation
empFile = "/home/nilesh/dbda-aug24/BigData/data/emp.csv"
empSchema = "empno INT, ename STRING, job STRING, mgr INT, hire DATE, sal DOUBLE, comm DOUBLE, deptno INT"
df = spark.read\
        .option("mode", "FAILFAST")\
        .option("nullValue", "NULL")\
        .schema(empSchema)\
        .csv(empFile)

df.show()

# computed column
# result1 = df.withColumn("income", col("sal") + ifnull(col("comm"), lit(0)))
# result1 = df.withColumn("income", col("sal") + expr("IFNULL(comm, 0)"))
result1 = df.withColumn("income", expr("sal + IFNULL(comm,0)"))
result1.show()

# computed column & projection
# result2 = df.selectExpr("ename", "sal", "comm", "sal + IFNULL(comm,0) AS income")
result2 = df.selectExpr("*", "sal + IFNULL(comm,0) AS income")\
                .drop("mgr", "hire")
result2.show()

# destroy spark session
spark.stop()

