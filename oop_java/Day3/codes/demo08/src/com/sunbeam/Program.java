package com.sunbeam;

public class Program {
	
	//call by value 
	public static void swap(int a, int b) {
		int t = a; 
		a = b; 
		b = t; 
		System.out.println(" a " + a + " b "  + b  );
	}
	public static void main(String[] args) {
		int a = 10 , b = 20; 
		System.out.println(" a " + a + " b "  + b  );
		
		swap(a,b); 
		
		System.out.println(" a " + a + " b "  + b  );
		
	}


}
