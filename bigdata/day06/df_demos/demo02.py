
from pyspark.sql import SparkSession

# create new SparkSession
spark = SparkSession.builder\
            .appName("demo02")\
            .getOrCreate()

# create DataFrame
filePath = '/home/nilesh/dbda-aug24/BigData/data/emp_hdr.csv'
empSchema = 'empno INT, ename STRING, job STRING, mgr INT, hire DATE, sal DOUBLE, comm DOUBLE, deptno INT'
df = spark.read\
        .option('header', 'True')\
        .schema(empSchema)\
        .csv(filePath)
df.printSchema()

# Compute results
result = df\
            .groupBy('job').avg('sal')
result.printSchema()

# Show results
result.show(truncate=False)
