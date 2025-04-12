package com.sunbeam;

import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.SortedMap;

public class Program {
	
	/* 
	public static void main(String[] args) {
		SortedMap<String, Charset> map = Charset.availableCharsets(); 
		System.out.println("Size : " +map.size());
		map.forEach((K,V) -> System.out.println(K + "-----" + V));
	}
	*/ 
	public static void main(String[] args) {
		int ch; 
		try(FileReader rd = new FileReader("file2.txt")){
			while((ch = rd.read())!=-1) {
				System.out.print((char)ch); 
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
