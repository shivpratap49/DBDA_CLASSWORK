package com.sunbeam;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class NcdcMaxMinReducer extends Reducer<NullWritable, Text, Text, Text> {
	@Override
	protected void reduce(NullWritable key, Iterable<Text> values, Reducer<NullWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		double maxTemp = Double.MIN_VALUE, minTemp = Double.MAX_VALUE;
		short maxYear = 0, minYear = 0;
		for (Text value : values) {
			String yrTemp = value.toString();
			String[] parts = yrTemp.split(",");
			short yr = Short.parseShort(parts[0]);
			double temp = Double.parseDouble(parts[1]);
			if(temp > maxTemp) {
				maxTemp = temp;
				maxYear = yr;
			}
			if(temp < minTemp) {
				minTemp = temp;
				minYear = yr;
			}
		}
		context.write(new Text("Hot"), new Text("Yr:" + maxYear + ", Temp:" + maxTemp));
		context.write(new Text("Cool"), new Text("Yr:" + minYear + ", Temp:" + minTemp));
	}
}
