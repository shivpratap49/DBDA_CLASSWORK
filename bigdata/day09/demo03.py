
# Structured Streaming Demo -- Based on Streaming Dataframes
#   Streaming Dataframe --> Infinite dataset -- New records are appended.

#  Word Count

from pyspark.sql import SparkSession
from pyspark.sql.functions import *

# create spark session
spark = SparkSession.builder\
            .appName("demo03")\
            .getOrCreate()

# create streaming dataframe -- source = socket (localhost:4444)
data = spark.readStream\
            .format("socket")\
            .option("host", "localhost")\
            .option("port", "4444")\
            .load()
data.printSchema()

# processing -- split into words and remove stop words and count words
result = data\
            .select(explode(split(lower("value"), "[^a-z]")).alias("word"))\
            .where("word NOT IN ('', 'in', 'as', 'is', 'are', 'a', 'the', 'for', 'you', 'i', 'by', 'or', 'and', 'under', 'over', 'he', 'she', 'they', 'it')")\
            .groupBy("word").count()

# write streaming data frame -- sink=console
query = result.writeStream\
    .trigger(processingTime="10 seconds")\
    .format("console")\
    .option("truncate", "false")\
    .outputMode("update")\
    .start()

# wait for query execution
print("press ctrl+c to terminate the application...")
query.awaitTermination()

# destroy spark session
spark.stop()
