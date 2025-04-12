package com.sunbeam;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    // reduce() called once for each group
    @Override
	public void reduce(Text word, Iterable<IntWritable> counts, Reducer<Text, IntWritable, Text, IntWritable>.Context ctx) 
			throws IOException, InterruptedException {
        int total = 0;
        for(IntWritable cnt: counts)
            total = total + cnt.get();
        ctx.write(word, new IntWritable(total));
    }
}
