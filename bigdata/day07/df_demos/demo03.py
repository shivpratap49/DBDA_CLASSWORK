# load emp csv data and perform aggregate operations

# spark.sql.shuffle.partitions
#   when group by is done, by default spark divides data into 200 partitions.
#   these partitions are processed with 200 tasks (threads).
#   for smaller data, this can be reduced using "spark.sql.shuffle.partitions" property.

from pyspark.sql import SparkSession
from pyspark.sql.functions import *

# create spark session
spark = SparkSession.builder\
            .appName("demo03")\
            .config("spark.sql.shuffle.partitions", "2")\
            .getOrCreate()

# dataframe creation
# empFile = "hdfs://localhost:9000/user/nilesh/emp/input"
empFile = "/home/nilesh/dbda-aug24/BigData/data/emp.csv"
empSchema = "empno INT, ename STRING, job STRING, mgr INT, hire DATE, sal DOUBLE, comm DOUBLE, deptno INT"

df = spark.read\
        .schema(empSchema)\
        .option("path", empFile)\
        .format("csv")\
        .load()

# aggregate operation
result1 = df.groupBy("deptno")\
            .sum("sal")\
            .withColumnRenamed("sum(sal)", "total")\
            .where("total > 9000.0")
result1.printSchema()
result1.show()

# multiple aggregate operations
result2 = df.groupBy("job")\
            .agg(sum("sal").alias("sumsal"), avg("sal").alias("avgsal"), max("sal").alias("maxsal"), min("sal").alias("minsal"), count("sal").alias("cntsal"))
result2.printSchema()
result2.show()

# null handling
# result3 = df.fillna(0)    # replace all nulls in all columns
# result3 = df.fillna(0, ["comm"]) # replace all nulls in given columns
result3 = df.na.fill({"comm": 0, "mgr": -1}) # replace given value in given column null
result3.show()

# destroy spark session
spark.stop()

