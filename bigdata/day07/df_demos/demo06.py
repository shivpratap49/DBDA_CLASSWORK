# yearly avg temp -- hottest/coolest year

from pyspark.sql import SparkSession
from pyspark.sql.functions import *

# create spark session
spark = SparkSession.builder\
            .appName("demo06")\
            .config("spark.sql.shuffle.partitions", "2")\
            .getOrCreate()

ncdcPath = "/home/nilesh/dbda-aug24/BigData/private/ncdc"
ncdcdf = spark.read.text(ncdcPath)

ncdcdf.printSchema() # value column
ncdcdf.show(n=3, truncate=False)

# extract year, temp and quality
regex = r"^.{15}([0-9]{4}).{68}([-\+][0-9]{4})([0-9]).*$"
ncdc = ncdcdf\
    .select(regexp_extract("value", regex, 1).alias("yr").cast('SHORT'), regexp_extract("value", regex, 2).alias("temp").cast('SHORT'), regexp_extract("value", regex, 3).alias("quality").cast('BYTE'))\
    .where("temp != 9999 AND quality IN (0,1,2,4,5,9)")

ncdc.printSchema() # yr, temp, quality
ncdc.show(n=3)

# yearly avg temp
avgtemp = ncdc.groupBy('yr').avg('temp')\
            .withColumnRenamed('avg(temp)', 'avgtemp')
avgtemp.printSchema()
avgtemp.show()

# find hottest year
hotdf = avgtemp.orderBy("avgtemp", ascending=False).limit(1).withColumn("label", lit("Hot"))

# hotdf = avgtemp.orderBy(desc("avgtemp")).limit(1)
# hotdf.show()

# hotrow = avgtemp.orderBy(desc("avgtemp")).first()
# print(f"Hot: Year={hotrow[0]}, AvgTemp={hotrow[1]}")

cooldf = avgtemp.orderBy("avgtemp").limit(1).withColumn("label", lit("Cool"))

# cooldf = avgtemp.orderBy(asc("avgtemp")).limit(1)
# cooldf.show()

# coolrow = avgtemp.orderBy(asc("avgtemp")).first()
# print(f"Cool: Year={coolrow[0]}, AvgTemp={coolrow[1]}")

result = hotdf.union(cooldf)
result.show()

# destroy spark session
spark.stop()
