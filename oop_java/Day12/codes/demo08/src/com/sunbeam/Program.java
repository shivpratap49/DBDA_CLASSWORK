package com.sunbeam;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter the path :: ");
		String path = sc.next(); 
		File file = new File(path); 
		
		if(!file.exists()) {
			System.out.println("Invalid ");
			System.exit(0);
		}
		if(file.isDirectory()) {
			String[] lst = file.list(); 
			for (String l : lst) {
				System.out.println(l);
			}
		}
		else if(file.isFile()) {
			System.out.println("Name :" + file.getName());
			System.out.println("Parent : "+file.getParent());
			System.out.println("File Information");
			if(file.canRead())
				System.out.println("Read");
			if(file.canExecute())
				System.out.println("Execute");
			if(file.canWrite())
				System.out.println("Write");
			
			long lstModified = file.lastModified(); 
			System.out.println("Last modified " + new Date(lstModified));
		}
		else {
			System.out.println("Niether file nor directory");
		}
	}

}
