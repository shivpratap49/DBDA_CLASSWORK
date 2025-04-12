
# number movies for each genre

from pyspark.sql import SparkSession
from pyspark.sql.functions import *

# create spark session
spark = SparkSession.builder\
            .appName("demo10")\
            .config("spark.sql.shuffle.partitions", "2")\
            .getOrCreate()

# movies from csv
rawMovies = spark.read\
            .option("header", True)\
            .option("inferSchema", True)\
            .csv("/home/nilesh/dbda-aug24/BigData/private/movies/movies.csv")
rawMovies.createOrReplaceTempView("raw_movies")

# movies -- array<string> genres
movies = spark.sql(r"SELECT title, EXPLODE(SPLIT(genres, '\\|')) genre FROM raw_movies")
movies.createOrReplaceTempView("movies")

# result
result = spark.sql("SELECT genre, COUNT(1) cnt FROM movies GROUP BY genre ORDER BY cnt DESC")
result.show()
result.explain(extended=True)

# destroy spark session
spark.stop()
