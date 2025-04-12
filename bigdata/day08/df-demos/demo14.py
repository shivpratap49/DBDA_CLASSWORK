
# Spark SQL -- Write/Save Tables
#   .enableHiveSupport() -- internally creates HiveContext.
#   HiveContext is used to interact with Hive/Spark Metastore.

from pyspark.sql import SparkSession
from pyspark.sql.functions import *

spark = SparkSession.builder \
            .config("spark.sql.shuffle.partitions", "2") \
            .config("spark.sql.warehouse.dir", "file:///home/nilesh/bigdata/spark-warehouse")\
            .appName("demo14") \
            .enableHiveSupport() \
            .getOrCreate()

empFile = "/home/nilesh/dbda-aug24/BigData/data/emp.csv"
empSchema = "empno INT, ename STRING, job STRING, mgr INT, hire DATE, sal DOUBLE, comm DOUBLE, deptno INT"
emp = spark.read\
        .option("nullValue", "NULL")\
        .schema(empSchema)\
        .csv(empFile)

emp.write.mode("OVERWRITE")\
    .saveAsTable("emp")
print("emp table saved.")

emp.write.mode("OVERWRITE")\
    .partitionBy("deptno", "job")\
    .saveAsTable("emp_dept_job_part")
print("emp_dept_job_part table saved.")

emp.write.mode("OVERWRITE")\
    .bucketBy(2, "ename")\
    .saveAsTable("emp_bucketed")
print("emp_bucketed table saved.")


emp.write.mode("OVERWRITE")\
    .partitionBy("deptno")\
    .bucketBy(2, "empno")\
    .saveAsTable("emp_dept_part_bucketed")
print("emp_dept_part_bucketed table saved.")

spark.stop()
