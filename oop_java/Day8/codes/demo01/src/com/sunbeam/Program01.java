package com.sunbeam;

public class Program01 {
	// generic method using java.lang.Object -- till Java 1.4
	public static void printObjectArray(Object[] arr) {
		for (int i = 0; i < arr.length; i++) {
			//String ele = (String)arr[i]; // will cause runtime ClassCastException if element is not String
			System.out.println("Object ele: " + arr[i]);
		}
	}
	
	// generic method using generic type param -- since Java 5.0
	public static <T> void printTypedArray(T[] arr) {
		for (int i = 0; i < arr.length; i++) {
			T ele = arr[i];
			System.out.println("T ele: " + ele);
		}
	}
	
	// generic method using bounded generic type param -- since Java 5.0
	public static <T extends Number> void printNumberArray(T[] arr) {
		for (int i = 0; i < arr.length; i++) {
			T ele = arr[i];
			System.out.println("T ele: " + ele);
		}
	}

	public static void main(String[] args) {
		/*
		Object[] arr1 = { "11", "22", "33", 44 };
		printObjectArray(arr1);
		String[] arr2 = { "Nilesh", "Nitin", "Amit", "Akshita" };
		printObjectArray(arr2);
		*/
		
		/*
		Integer[] arr1 = { 11, 22, 33, 44 };
		printTypedArray(arr1); // T = Integer

		String[] arr2 = { "Nilesh", "Nitin", "Amit", "Akshita" };
		printTypedArray(arr2); // T = String
		
		Double[] arr3 = { 1.1, 2.2, 3.3, 4.4 };
		Program01.<Number>printTypedArray(arr3); // T = Number
		*/

		Integer[] arr1 = { 11, 22, 33, 44 };
		printNumberArray(arr1); // T = Integer

		String[] arr2 = { "Nilesh", "Nitin", "Amit", "Akshita" };
		//printNumberArray(arr2); // compiler error: String is not Number
		
		Double[] arr3 = { 1.1, 2.2, 3.3, 4.4 };
		Program01.<Number>printNumberArray(arr3); // T = Number
	}
}
