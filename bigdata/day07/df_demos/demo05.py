# data formats: json, text, orc, parquet
#   read and write

from pyspark.sql import SparkSession
from pyspark.sql.functions import *

# create spark session
spark = SparkSession.builder\
            .appName("demo05")\
            .config("spark.sql.shuffle.partitions", "2")\
            .getOrCreate()

# dataframe creation -- text
licenseFile = "/home/nilesh/dbda-aug24/hadoop-3.3.2/LICENSE.txt"
licdf = spark.read.text(licenseFile)
licdf.printSchema() # text format -- single column=value
licdf.show(truncate=False) # display 20 lines

# dataframe creation -- json
booksFile = "/home/nilesh/dbda-aug24/BigData/data/books.json"
booksSchema = "id INT, name STRING, author STRING, subject STRING, price DOUBLE"
df = spark.read\
        .schema(booksSchema)\
        .json(booksFile)

df.printSchema()
df.show(truncate=False)

# write data into different formats
df.write.mode("OVERWRITE").format("csv").save("/tmp/book_csv")
print("books saved in csv format...")
df.write.mode("OVERWRITE").format("json").save("/tmp/book_json")
print("books saved in json format...")
df.write.mode("OVERWRITE").format("orc").save("/tmp/book_orc")
print("books saved in orc format...")
df.write.mode("OVERWRITE").format("parquet").save("/tmp/book_parquet")
print("books saved in parquet format...")

# destroy spark session
spark.stop()
