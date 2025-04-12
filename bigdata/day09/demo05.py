
#  Trending Hashtags -- Batch processing | trigger = Once

from pyspark.sql import SparkSession
from pyspark.sql.functions import *

# create spark session
spark = SparkSession.builder\
            .appName("demo05")\
            .getOrCreate()

# create streaming dataframe -- source = files (format=json)
dirPath = "file:///home/nilesh/dbda-aug24/BigData/private/tweets"
tweetSchema = "id STRING, time STRING, text STRING"
data = spark.readStream\
            .format("json")\
            .option("path", dirPath)\
            .schema(tweetSchema)\
            .load()
data.printSchema()

# processing -- split into words and get hashtags and count them
result = data\
            .select(explode(split(lower("text"), "[^#a-z]")).alias("word"))\
            .where("word LIKE '#%' AND word != '#'")\
            .groupBy("word").count()\
            .orderBy(desc("count")).limit(20)

# write streaming data frame -- sink=console | appln runs only one time
query = result.writeStream\
    .trigger(once=True)\
    .format("console")\
    .option("truncate", "false")\
    .outputMode("complete")\
    .start()

# wait for query execution
query.awaitTermination()

# destroy spark session
spark.stop()
