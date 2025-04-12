### Emp Jobwise Total Sal (mr2)
* Create directory in HDFS to store emp files. Upload emp files there.
    > hadoop fs -mkdir -p /user/nilesh/emp/input

    > hadoop fs -put /home/nilesh/dbda-aug24/BigData/data/emp?0.csv /user/nilesh/emp/input

* EmpMapper
    * Input: offset LongWritable, line Text
    * Output: job Text, sal DoubleWritable
    * Logic:
        * line -- split by ","
        * pick -- parts[2] as job, and parts[5] as sal

* EmpReducer
    * Input: job Text, sals DoubleWritable
    * Output: job Text, totalSal DoubleWritable
    * Logic:
        * Sum of sals per group

* Main
    * Driver code

* Execute the MR job -- In current cluster (single node)

    > hadoop jar mr2-empavgsal-0.0.1-SNAPSHOT.jar com.sunbeam.Main -D dfs.replication=2 /user/nilesh/emp/input /user/nilesh/emp/output2

    > hadoop fs -ls /user/nilesh/emp/output2

    > hadoop fs -cat /user/nilesh/emp/output2/part-r-00000

* Execute the MR job -- In local mode
    * In Local mode, job must access local file system (not HDFS).

    > vim local-config.xml

        * add local config settings
            - fs = file:///
            - mapred framework = local
    
    > mkdir -p /tmp/emp/input

    > cp /home/nilesh/dbda-aug24/BigData/data/emp?0.csv /tmp/emp/input

    > ls /tmp/emp/input

    > hadoop jar mr2-empavgsal-0.0.1-SNAPSHOT.jar com.sunbeam.Main -conf /home/nilesh/dbda-aug24/BigData/day16/local-config.xml /tmp/emp/input /tmp/emp/output1

    > cat /tmp/emp/output1/part-r-00000

* Execute the MR job -- In production cluster
    * In Cluster mode, job must access HDFS (in that cluster).

    > vim cluster-config.xml

        * add cluster config settings
            - fs = hdfs://master:9000/
            - mapred framework = yarn
            - resource manager = master:8032
    
    > create input dir into hadoop cluster and upload input files there

    > hadoop jar mr2-empavgsal-0.0.1-SNAPSHOT.jar com.sunbeam.Main -conf /home/nilesh/dbda-aug24/BigData/day16/cluster-config.xml /input/dir/path /output/dir/path

### Emp Jobwise Avg Sal (mr3)

* EmpMapper
    * Input: offset LongWritable, line Text
    * Output: job Text, sal DoubleWritable
    * Logic:
        * line -- split by ","
        * pick -- parts[2] as job, and parts[5] as sal

* EmpReducer
    * Input: job Text, sals DoubleWritable
    * Output: job Text, totalSal DoubleWritable
    * Logic:
        * Avg of sals per group

* Main
    * Driver code
    * job.setNumReduceTasks(2);

* Execute the MR job -- In current cluster (single node)

    > hadoop jar mr3-empavgsal-0.0.1-SNAPSHOT.jar com.sunbeam.Main /user/nilesh/emp/input /user/nilesh/emp/output4

