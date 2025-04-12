
# Top Movies
from pyspark import SparkConf, SparkContext

# create spark context
conf = SparkConf()\
        .setAppName("demo3")\

sc = SparkContext(conf=conf)

# parse rating
def parseRating(line):
    try:
        parts = line.split(",")
        movieId = int(parts[1])
        return (movieId, 1)
    except:
        return ()


# parse movie
def parseMovie(line):
    try:
        parts = line.split("^")
        movieId = int(parts[0])
        title = parts[1]
        return (movieId, title)
    except:
        return ()

# read ratings csv
# count num of ratings per movie
ratingFile = "file:///home/nilesh/dbda-aug24/BigData/private/movies/ratings.csv"
ratings = sc.textFile(ratingFile)\
            .map(lambda line: parseRating(line))\
            .filter(lambda mc: len(mc) == 2)\
            .reduceByKey(lambda a, x: a + x)

# ratings.foreach(lambda v: print(v))

moviesFile = "file:///home/nilesh/dbda-aug24/BigData/private/movies/movies_caret.csv"
movies = sc.textFile(moviesFile)\
            .map(lambda line: parseMovie(line))\
            .filter(lambda mt: len(mt) == 2)\

# movies.foreach(lambda v: print(v))

# join movies with ratings -- always done in key-value pair rdd -- key1==key2
movieRatings = ratings.join(movies)\
                .sortBy(lambda tup: tup[1][0], ascending=False)\

# movieRatings.foreach(lambda v: print(v))

# get top most movie -- action
topmost = movieRatings.first()
print(topmost)

# get top 10
top10 = movieRatings.take(10)
print(top10)

input("press enter to exit...")

# close the context
sc.stop()
