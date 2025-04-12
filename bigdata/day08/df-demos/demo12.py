
# JDBC

from pyspark.sql import SparkSession
from pyspark.sql.functions import *

spark = SparkSession.builder\
            .appName("demo12")\
            .config("spark.sql.shuffle.partitions", "2")\
            .getOrCreate()

jdbcUrl = "jdbc:mysql://localhost:3306/advsql"
dbTable = "emp"
dbDriver = "com.mysql.cj.jdbc.Driver"
dbUser = "nilesh"
dbPasswd = "nilesh"

df = spark.read\
    .option("driver", dbDriver)\
    .option("user", dbUser) \
    .option("password", dbPasswd) \
    .jdbc(url=jdbcUrl, table=dbTable)

df.printSchema()
df.show()

desc = df.select(mean("sal"), stddev("sal"), sum("sal"), max("sal"), min("sal"))
desc.show()

result = df.groupBy("deptno").agg(sum("sal").alias("sumsal"), avg("sal").alias("avgsal"))
result.show()

dbResultTable = "empsummary"
result.write\
    .option("driver", dbDriver)\
    .option("user", dbUser) \
    .option("password", dbPasswd) \
    .jdbc(url=jdbcUrl, table=dbResultTable)

spark.stop()
