
# Structured Streaming Demo -- Based on Streaming Dataframes
#   Streaming Dataframe --> Infinite dataset -- New records are appended.

# Remove Stopwords

from pyspark.sql import SparkSession
from pyspark.sql.functions import *

# create spark session
spark = SparkSession.builder\
            .appName("demo02")\
            .getOrCreate()

# create streaming dataframe -- source = socket (localhost:4444)
data = spark.readStream\
            .format("socket")\
            .option("host", "localhost")\
            .option("port", "4444")\
            .load()
data.printSchema()

# processing -- split into words and remove stop words
result = data\
            .select(explode(split(lower("value"), "[^a-z]")).alias("word"))\
            .where("word NOT IN ('', 'in', 'as', 'is', 'are', 'a', 'the', 'for', 'you', 'i', 'by', 'or', 'and', 'under', 'over', 'he', 'she', 'they', 'it')")

# write streaming data frame -- sink=console
query = result.writeStream\
    .trigger(processingTime="10 seconds")\
    .format("console")\
    .option("truncate", "false")\
    .option("numRows", "50")\
    .outputMode("append")\
    .start()

# wait for query execution
print("press ctrl+c to terminate the application...")
query.awaitTermination()

# destroy spark session
spark.stop()
