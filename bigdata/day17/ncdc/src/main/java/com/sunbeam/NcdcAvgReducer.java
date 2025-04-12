package com.sunbeam;

import java.io.IOException;
import java.util.stream.Stream;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.ShortWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class NcdcAvgReducer extends Reducer<ShortWritable, DoubleWritable, ShortWritable, DoubleWritable> {
	@Override
	protected void reduce(ShortWritable key, Iterable<DoubleWritable> values,
			Reducer<ShortWritable, DoubleWritable, ShortWritable, DoubleWritable>.Context context)
			throws IOException, InterruptedException {
		double total = 0.0;
		int count = 0;
		for(DoubleWritable temp: values) {
			total = total + temp.get();
			count++;
		}
		double avg = total / count;
		context.write(key, new DoubleWritable(avg));
	}
}
