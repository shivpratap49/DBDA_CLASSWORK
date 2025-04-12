package com.sunbeam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;



public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter the srcPath :: ");
		String srcPath = sc.next(); 
		System.out.println("Enter the destPath :: ");
		String destPath = sc.next(); 
		int b; 
		try(FileInputStream fin = new FileInputStream(srcPath)){
		    try(FileOutputStream fout = new FileOutputStream(destPath)){
		    	  while((b = fin.read())!=-1) {
		    		  fout.write(b);
		    	  }
		    }
		}//fin.close(); 
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("File copied ...");
		
	}

}
