package com.sunbeam;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class MR01Main {
    // Driver: create map-reduce job and submit it to hadoop cluster
    public static void main(String[] args) {
        try {
            // create a new job
            Configuration conf = new Configuration();
            Job job = Job.getInstance(conf, "WordCount");
            // set jar in which mapper & reducer classes are available
            job.setJarByClass(MR01Main.class);
            // mapper settings
            job.setMapperClass(WordCountMapper.class);
            job.setMapOutputKeyClass(Text.class);
            job.setMapOutputValueClass(IntWritable.class);
            // reducer settings
            job.setReducerClass(WordCountReducer.class);
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(IntWritable.class);
            // set input and output formats
            job.setInputFormatClass(TextInputFormat.class);
            job.setOutputFormatClass(TextOutputFormat.class);
            // set input and output dir/file
            TextInputFormat.addInputPaths(job, "/user/nilesh/wc/input");
            Path path = new Path("/user/nilesh/wc/output1");
            TextOutputFormat.setOutputPath(job, path);
            // submit the job and get success/failed status
            job.submit();
            boolean success = job.waitForCompletion(true);
            System.out.println("Job Execution Success: " + success);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
 }
