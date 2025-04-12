package com.sunbeam;

public class Program {

	public static void main1(String[] args) {
		//String class in java represents immutable set of characters
		//length() returns number of chars
		//charAt() returns char at given index  -- 0 to len-1 
		//str reference is created on stack 
		//"Sunbeam" string literal/constant is created on String pool (heap) 	
		String str = "Sunbeam"; 
		System.out.println("Lenght : "+str.length());
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i); 
			System.out.print(ch);
		}
	}
	public static void main2(String[] args) {
		// "new" String objects created on heap
		String str = new String("Infotech"); 
		System.out.println("Length : "+str.length());
		for (int i = 0; i < str.length(); i++) {
			  char ch = str.charAt(i); 
			  System.out.print(ch);
		}
	}
	public static void main3(String[] args) {
		String str = "Sunbeam Infotech"; 
		char ch = 't'; 
		int index = str.indexOf(ch); 
		System.out.println("Char " + ch + " found at Index: " + index); // 12
		
		ch = 'e'; 
		index = str.indexOf(ch); 
		System.out.println("Char " + ch + " found at Index: " + index); // 4
		
		ch = 'e'; 
		index = str.lastIndexOf(ch); 
		System.out.println("Char " + ch + " found at Index: " + index); // 13 (last occurrence)
		
		ch = 'x'; 
		index = str.indexOf(ch); 
		System.out.println("Char " + ch + " found at Index: " + index); // -1 (not found)
	}
	public static void main4(String[] args) {
		// strings are immutable.
	    // operations performed on string will create a new object with modified contents.
		String s1 = "Sunbeam"; 
		String s2 = s1.toUpperCase(); 
		System.out.println("s1: " + s1); // "SunBeam"
		System.out.println("s2: " + s2); // "SUNBEAM"
		String s3 = s1.toLowerCase(); 
		System.out.println("s1: " + s1); // "SunBeam"
		System.out.println("s3: " + s3); // "sunbeam"
	}
	public static void main5(String[] args) {
		String s1 = "Sunbeam"; 
		String s2 = "Infotech"; 
		String s3 = s1.concat(s2); 
		System.out.println("s1: " + s1); // "Sunbeam"
		System.out.println("s2: " + s2); // "Infotech"
		System.out.println("s3: " + s3); // "SunbeamInfotech"
	}
	public static void main6(String[] args) {
		String str = "SunbeamInfotech"; 
		String s1 = str.substring(7);// returns new string starting from index 7 to last index
		System.out.println("s1: " + s1); // Infotech
		String s2 = str.substring(7, 11); // returns new string starting from index 7 and ending on index 10 (11-1)
		System.out.println("s2: " + s2); // Info
		// Note: start index is inclusive, end index is exclusive
	}
	public static void main7(String[] args) {
		String str = "this is an example"; 
		String[] parts = str.split(" ");
		for (int i = 0; i < parts.length; i++)
			System.out.println(parts[i]);
	}
	public static void main8(String[] args) {
		// trim() removes leading and trailing spaces from the string
		String s1 = "        Sunbeam   Infotech             "; 
		System.out.println("s1 Length: " + s1.length());
		String s2 = s1.trim(); 
		System.out.println("s2 Length: " + s2.length());
	}
	public static void main(String[] args) {
		// String.format() is like C langauge sprintf() fn
		String str = "Sunbeam"; 
		int year = 1998; 
		String s = String.format("%s company is founded in year %d\n",str,year); 	
		System.out.println(s);
	}
}
