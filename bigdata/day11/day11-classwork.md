### Zookeeper
* Start Zookeeper (from Kafka)
* cmd> zookeeper-shell.sh localhost:2181
* zookeeper commands
    * ls /
    * ls /brokers
    * ls /brokers/topics
    * get /brokers/topics/iot
    * get /brokers/topics/avgiot
    * ls /brokers/ids
* Start Kafka Server
* zookeeper commands
    * ls /brokers/ids
    * get /brokers/ids/0
    * quit

### Spark ML
* Images Dataset: https://drive.google.com/drive/u/0/folders/1ROndFAgwhSwDbtO3eA69E9e3WiJLD0YZ

### Spark Core


#### Start SingleNode Cluster
* Uncomment SPARK_HOME and PATH from ~/.bashrc.
* cmd> start-master.sh
* cmd> start-workers.sh
* cmd> spark-shell
* Browser-> http://localhost:8080
* Browser-> http://localhost:4040

#### On Spark Shell -- Word Count
terminal> cat > ~/colors.txt

	```
    Red green blue
    Red red green
    green Blue black
    green Green blue
	```

```scala
val file = sc.textFile("file:///home/nilesh/colors.txt")

file.partitions.length

val data = file.repartition(3)

val lines = data.map(line => line.toLowerCase())

val words = lines.flatMap(line => line.split("[^a-z]"))

val word1s = words.map(word => (word, 1))

val wordcounts = word1s.reduceByKey((a,i) => a + i)
# reduceByKey() = groupByKey() + reduce() per group

wordcounts.partitions.length

val capwordcounts = wordcounts.map(wc => (wc._1.toUpperCase(), wc._2))

val result = capwordcounts.collect()

```


