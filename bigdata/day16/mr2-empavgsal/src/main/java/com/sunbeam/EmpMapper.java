package com.sunbeam;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class EmpMapper extends Mapper<LongWritable, Text, Text, DoubleWritable> {
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, DoubleWritable>.Context context)
			throws IOException, InterruptedException {
		String[] parts = value.toString().split(",");
		String job = parts[2];
		double sal = Double.parseDouble(parts[5]);
		context.write(new Text(job), new DoubleWritable(sal));
	}
}
