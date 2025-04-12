package com.sunbeam;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class EmpReducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {
	@Override
	protected void reduce(Text key, Iterable<DoubleWritable> values,
			Reducer<Text, DoubleWritable, Text, DoubleWritable>.Context context) throws IOException, InterruptedException {
		double total = 0.0;
		int count = 0;
		for (DoubleWritable sal : values) {
			total = total + sal.get();
			count++;
		}
		double avg = total / count;
		context.write(key, new DoubleWritable(avg));
	}
}
