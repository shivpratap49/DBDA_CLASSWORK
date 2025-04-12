
# number movies for each genre

from pyspark.sql import SparkSession
from pyspark.sql.functions import *

# create spark session
spark = SparkSession.builder\
            .appName("demo09")\
            .config("spark.sql.shuffle.partitions", "2")\
            .getOrCreate()

# movies from csv
rawMovies = spark.read\
            .option("header", True)\
            .option("inferSchema", True)\
            .csv("/home/nilesh/dbda-aug24/BigData/private/movies/movies.csv")

# movies -- array<string> genres
movies = rawMovies\
            .withColumn("genre", explode(split("genres", r"\|")))\
            .drop("genres")\
            
movies.show(n=10, truncate=False)

# result
result = movies.groupby("genre").count()\
            .orderBy(desc("count"))

result.show()
result.explain(extended=True)

# destroy spark session
spark.stop()
