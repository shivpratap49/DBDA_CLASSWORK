package com.sunbeam;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.ShortWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Counter;
import org.apache.hadoop.mapreduce.Mapper;

public class NcdcAvgMapper extends Mapper<LongWritable, Text, ShortWritable, DoubleWritable> {
	@Override
	protected void map(LongWritable key, Text value,
			Mapper<LongWritable, Text, ShortWritable, DoubleWritable>.Context context)
			throws IOException, InterruptedException {
		String line = value.toString();
		short yr = Short.parseShort(line.substring(15, 19));
		double temp = Double.parseDouble(line.substring(87, 92));
		short q = Short.parseShort(line.substring(92, 93));
		if(temp != 9999 && (q == 0 || q == 1 || q == 2 || q == 4 || q == 5 || q==9)) {
			context.getCounter(NcdcCounter.ValidRecords).increment(1);
			context.write(new ShortWritable(yr), new DoubleWritable(temp));
		} else {
			Counter cntr = context.getCounter(NcdcCounter.InvalidRecords);
			cntr.increment(1);
			System.out.println(line);
		}
	}
}
