package com.sunbeam;

import java.util.Scanner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;

public class Demo02Main {
	public static void main(String[] args) {
		// get hdfs fs object
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://localhost:9000");
		try(DistributedFileSystem dfs = (DistributedFileSystem) FileSystem.get(conf)) {
			// open the required file
			String filePath = "/user/nilesh/colors.txt";
			try(FSDataInputStream din = dfs.open(new Path(filePath))) {
				// read the file line by line (Scanner)
				try(Scanner sc = new Scanner(din)) {
					while(sc.hasNextLine()) {
						String line = sc.nextLine();
						System.out.println(line);
					}
				}
			} // din.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
