package com.sunbeam;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.mapreduce.lib.partition.HashPartitioner;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

// MR Driver --> Create Job, Configure Job and Submit Job
public class Main extends Configured implements Tool {
	public static void main(String[] args) throws Exception {
		// create new config by parsing command line args
		GenericOptionsParser parser = new GenericOptionsParser(args);
		Configuration conf = parser.getConfiguration();
		Main driver = new Main();
		int ret = ToolRunner.run(conf, driver, parser.getRemainingArgs());
		System.exit(ret);
	}
	
	@Override
	public int run(String[] args) throws Exception {
		// Create Job
		Configuration conf = super.getConf();
		Job job = Job.getInstance(conf, "EmpAvgSal");
		// set the jar in which mapper and reducer classes are present
		job.setJarByClass(Main.class);
		// set the mapper class
		job.setMapperClass(EmpMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(DoubleWritable.class);
		// set the reducer class
		job.setReducerClass(EmpReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(DoubleWritable.class);
		// additional settings (combiner, partitioner, num of reducers, ...)
		job.setPartitionerClass(HashPartitioner.class); // default
		job.setNumReduceTasks(2);
		// set input
		job.setInputFormatClass(TextInputFormat.class);
		TextInputFormat.setInputPaths(job, args[0]);
		// set output
		job.setOutputFormatClass(TextOutputFormat.class);
		TextOutputFormat.setOutputPath(job, new Path(args[1]));
		// submit the job
		job.submit();
		boolean success = job.waitForCompletion(true);
		return success ? 0 : 1;
	}
}




