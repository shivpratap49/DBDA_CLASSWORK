package com.sunbeam;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;

public class Demo01Main {
	public static void main(String[] args) {
		// get hdfs fs object
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://localhost:9000/");
	 	try(DistributedFileSystem dfs = (DistributedFileSystem) FileSystem.get(conf)) {
	 		// create FileStatus for given dir
	 		String dirPath = "/user/nilesh";
	 		FileStatus stat = dfs.getFileStatus(new Path(dirPath));
	 		System.out.println("Dir Metadata: ");
	 		System.out.println("	Name: " + stat.getPath().getName());
	 		System.out.println("	Parent: " + stat.getPath().getParent());
	 		System.out.println("	Owner: " + stat.getOwner() + "/" + stat.getGroup());
	 		// list the dir contents
	 		System.out.println("Directory Contents:");
	 		FileStatus[] files = dfs.listStatus(new Path(dirPath));
	 		for (FileStatus st : files) {
	 			System.out.print("	" + (st.isDirectory()?"DIR":"FILE") + " -> ");
				System.out.print(st.getPath().getName() + ": " + st.getLen() / 1024.0 + " KB, ");
				System.out.println(st.getOwner() + "/" + st.getGroup() + ", Replication: " + st.getReplication());
			}
	 	} // dfs.close()
	 	catch (Exception e) {
			e.printStackTrace();
		}
	}
}
