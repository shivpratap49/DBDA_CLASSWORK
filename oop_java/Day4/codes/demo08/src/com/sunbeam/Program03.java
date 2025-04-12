package com.sunbeam;

public class Program03 {
	public static void main(String[] args) {
		Date d1 = new Date(6, 2, 2024);
		System.out.println("d1 = " + d1.toString());
			// d1 = com.sunbeam.Date@3d012ddd <-- when not overridden
			// Object.toString() returns class name @ hashcode in hex
		
			// d1 = 6-2-2024 <-- to get state of object, override the method in the class
	}
}
