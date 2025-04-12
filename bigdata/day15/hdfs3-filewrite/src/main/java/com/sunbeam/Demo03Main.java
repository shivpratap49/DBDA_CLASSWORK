package com.sunbeam;

import java.io.PrintStream;
import java.util.Scanner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;

public class Demo03Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// get hdfs fs object
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://localhost:9000");
		conf.set("dfs.replication", "1");
		conf.set("dfs.blocksize", "" + (32 * 1024 * 1024));
		try(DistributedFileSystem dfs = (DistributedFileSystem) FileSystem.get(conf)) {
			// create a new file
			String filePath = "/user/nilesh/bigdata2.txt";
			try(FSDataOutputStream dout = dfs.create(new Path(filePath))) {
				// write into file line by line
				System.out.println("Enter text (4 lines)...");
				PrintStream out = new PrintStream(dout);
				for(int i=1; i<=4; i++) {
					String line = sc.nextLine(); // input string from user
					out.println(line);
				}
				//dout.flush();	// send any in-mem data over network (to data node)
				//dout.hflush(); // send any in-mem data to data node and wait until it reach data node memory (ack)
				dout.hsync(); // send any in-mem data to data node and wait until it is written in data node disk (ack)
			} // dout.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
