
from pyspark.sql import SparkSession

# create new SparkSession
spark = SparkSession.builder\
            .appName("demo01")\
            .getOrCreate()

# create DataFrame
filePath = '/home/nilesh/dbda-aug24/BigData/data/books_hdr.csv'
df = spark.read\
        .option('header', 'True')\
        .option('inferSchema', 'True')\
        .csv(filePath)
df.printSchema()

# Compute results
result = df\
            .groupBy('subject').avg('price')
result.printSchema()

# Show results
result.show(truncate=False)
