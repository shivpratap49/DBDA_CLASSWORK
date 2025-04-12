# optimization -- catalyst

from pyspark.sql import SparkSession
from pyspark.sql.functions import *

# create spark session
spark = SparkSession.builder\
            .appName("demo08")\
            .config("spark.sql.shuffle.partitions", "2")\
            .getOrCreate()

# dataframe creation -- json
booksFile = "/home/nilesh/dbda-aug24/BigData/data/books.json"
booksSchema = "id INT, name STRING, author STRING, subject STRING, price DOUBLE"
df = spark.read\
        .schema(booksSchema)\
        .json(booksFile)

df.printSchema()
df.show(truncate=False)

result = df.groupBy("subject").sum("price")\
        .where("subject IN ('C Programming', 'Java Programming')")

result.printSchema()
result.show(truncate=False)

result.explain(extended=True)

# destroy spark session
spark.stop()
