package com.sunbeam;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.ShortWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class NcdcMaxMinMapper extends Mapper<Text, Text, NullWritable, Text> {
	@Override
	protected void map(Text key, Text value, Mapper<Text, Text, NullWritable, Text>.Context context)
			throws IOException, InterruptedException {
		String yrTemp = key.toString() + "," + value.toString();
		context.write(NullWritable.get(), new Text(yrTemp));
	}
}
