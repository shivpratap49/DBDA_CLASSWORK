package com.sunbeam;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    // map() called once for each record
	@Override
	protected void map(LongWritable offset, Text line, Mapper<LongWritable, Text, Text, IntWritable>.Context ctx)
			throws IOException, InterruptedException {
        String str = line.toString();
        String lowerLine = str.toLowerCase();
        String[] words = lowerLine.split("[^a-z]");
        for(String word: words)
            ctx.write(new Text(word), new IntWritable(1));
	}
}
