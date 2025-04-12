
# Word Count

from pyspark import SparkConf, SparkContext

# create spark context
conf = SparkConf()\
        .setAppName("demo1")\
        # .set("spark.driver.memory", "1G")\

sc = SparkContext(conf=conf)

# execute word count job
filePath = "file:///home/nilesh/colors.txt"
result = sc.textFile(filePath)\
            .repartition(3)\
            .map(lambda line: line.lower())\
            .flatMap(lambda line: line.split())\
            .map(lambda word: (word, 1))\
            .reduceByKey(lambda a,x: a + x)\
            .map(lambda wc: (wc[0].upper(), wc[1]))\
            .collect()

# print result
for wc in result:
    print(wc)

# hold execution
input("press enter to exit...")

# close the context
sc.stop()
