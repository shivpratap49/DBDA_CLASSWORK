
# Window Functions

from pyspark.sql import SparkSession, Window
from pyspark.sql.functions import *

spark = SparkSession.builder\
            .appName("demo12")\
            .config("spark.sql.shuffle.partitions", "2")\
            .getOrCreate()

empFile = "/home/nilesh/dbda-aug24/BigData/data/emp.csv"
empSchema = "empno INT, ename STRING, job STRING, mgr INT, hire DATE, sal DOUBLE, comm DOUBLE, deptno INT"
df = spark.read\
        .option("nullValue", "NULL")\
        .schema(empSchema)\
        .csv(empFile)

wnd = Window.partitionBy("deptno").orderBy(desc("sal"))
result = df.select(col("ename"), col("deptno"), col("sal"))\
            .withColumn("sr", row_number().over(wnd))\
            .withColumn("rnk", rank().over(wnd))\
            .withColumn("drnk", dense_rank().over(wnd))\
            # .where("drnk = 1")            # deptwise highest salaried emps

result.show()


spark.stop()


