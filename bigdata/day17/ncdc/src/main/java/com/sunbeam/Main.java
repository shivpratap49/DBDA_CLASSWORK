package com.sunbeam;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.ShortWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.CombineTextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
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
		if(args.length != 3) {
			System.out.println("Pass 3 input dirs: input, aux and output");
			return 1;
		}
		// Create Job
		Configuration conf = super.getConf();
		Job job1 = Job.getInstance(conf, "NcdcAvgTemp");
		// set the jar in which mapper and reducer classes are present
		job1.setJarByClass(Main.class);
		// set the mapper class
		job1.setMapperClass(NcdcAvgMapper.class);
		job1.setMapOutputKeyClass(ShortWritable.class);
		job1.setMapOutputValueClass(DoubleWritable.class);
		// set the reducer class
		job1.setReducerClass(NcdcAvgReducer.class);
		job1.setOutputKeyClass(ShortWritable.class);
		job1.setOutputValueClass(DoubleWritable.class);
		// additional settings (combiner, partitioner, num of reducers, ...)
		
		// set input
		job1.setInputFormatClass(CombineTextInputFormat.class);
		CombineTextInputFormat.setInputPaths(job1, args[0]);
		// set output
		job1.setOutputFormatClass(TextOutputFormat.class);
		TextOutputFormat.setOutputPath(job1, new Path(args[1]));
		// submit the job
		job1.submit();
		boolean success = job1.waitForCompletion(true);
		if(!success)
			return 1;
	
		// Create Job
		Job job2 = Job.getInstance(conf, "NcdcMaxMin");
		// set the jar in which mapper and reducer classes are present
		job2.setJarByClass(Main.class);
		// set the mapper class
		job2.setMapperClass(NcdcMaxMinMapper.class);
		job2.setMapOutputKeyClass(NullWritable.class);
		job2.setMapOutputValueClass(Text.class);
		// set the reducer class
		job2.setReducerClass(NcdcMaxMinReducer.class);
		job2.setOutputKeyClass(Text.class);
		job2.setOutputValueClass(Text.class);
		// additional settings (combiner, partitioner, num of reducers, ...)

		// set input
		job2.setInputFormatClass(KeyValueTextInputFormat.class);
		TextInputFormat.setInputPaths(job2, args[1]);
		// set output
		job2.setOutputFormatClass(TextOutputFormat.class);
		TextOutputFormat.setOutputPath(job2, new Path(args[2]));
		// submit the job
		job2.submit();
		success = job2.waitForCompletion(true);

		return success ? 0 : 1;
	}
}




