### Apache Spark

##### Spark Single Node Cluster
* Download & extract spark-x.y.z-bin-hadoop3.tgz.
* In ~/.bashrc
    ```sh
    export SPARK_HOME=$HOME/spark-x.y.z-bin-hadoop3
    export PATH=$SPARK_HOME/bin:$SPARK_HOME/sbin:$PATH
    ```
* In $SPARK_HOME/conf/spark-env.sh
    ```sh
    export SPARK_MASTER_HOST=localhost
    export SPARK_LOCAL_IP=localhost
    ```
* In conf/workers.
    ```
    localhost
    ```
* In $SPARK_HOME/conf/spark-defaults.conf
    ```
    spark.master			spark://localhost:7077
    ```
* Start master & slaves.
    * terminal> start-master.sh
    * terminal> start-slaves.sh
    * terminal> jps
* Using cluster:
    * pyspark --master spark://localhost:7077
    * spark-submit 
