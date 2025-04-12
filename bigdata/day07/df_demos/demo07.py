# top 10 movies

from pyspark.sql import SparkSession
from pyspark.sql.functions import *

# create spark session
spark = SparkSession.builder\
            .appName("demo07")\
            .config("spark.sql.shuffle.partitions", "2")\
            .getOrCreate()

# ratings
ratings = spark.read\
            .option("header", True)\
            .option("inferSchema", True)\
            .csv("/home/nilesh/dbda-aug24/BigData/private/movies/ratings.csv")

topRatings = ratings\
            .groupBy("movieId").count()\
            .orderBy("count", ascending=False)\
            .limit(10)

topRatings.printSchema()
topRatings.show()

# movies
movies = spark.read\
            .option("header", True)\
            .option("inferSchema", True)\
            .csv("/home/nilesh/dbda-aug24/BigData/private/movies/movies.csv")

# top movies
topMovies = topRatings\
    .join(movies, movies['movieId'] == topRatings['movieId'], how='inner')\
    .select("title", "count")

topMovies.show(truncate=False)

topMovies.explain(extended=True)

input("Press enter to exit...")
# destroy spark session
spark.stop()
