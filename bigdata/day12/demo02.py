
# Word Count (except Stop Words)

from pyspark import SparkConf, SparkContext

# create spark context
conf = SparkConf()\
        .setAppName("demo2")\
        # .set("spark.driver.memory", "1G")\

sc = SparkContext(conf=conf)

# execute word count job

# to access stopword list on all workers use broadcast variables
# and on workers retrive the list (.value)
stopWords = sc.broadcast(["", "as", "in", "or", "and", "a", "the", "under", "for", "by"])

# to count the events/data use accumulator
artCount = sc.accumulator(0)


def countArticle(word):
    if word in ['a', 'an', 'the']:
        artCount.add(1)
    return word


filePath = "file:///home/nilesh/dbda-aug24/spark-3.4.4-bin-hadoop3/LICENSE"
result = sc.textFile(filePath)\
            .repartition(3)\
            .map(lambda line: line.lower())\
            .flatMap(lambda line: line.split())\
            .map(lambda word: countArticle(word))\
            .filter(lambda word: word not in stopWords.value)\
            .map(lambda word: (word, 1))\
            .reduceByKey(lambda a,x: a + x)\
            .map(lambda wc: (wc[0].upper(), wc[1]))\
            .collect()

# print result
for wc in result:
    print(wc)

# print article count
print("Article Count:", artCount.value)

# hold execution
input("press enter to exit...")

# close the context
sc.stop()
