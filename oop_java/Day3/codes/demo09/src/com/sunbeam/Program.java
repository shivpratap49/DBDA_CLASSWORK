package com.sunbeam;

public class Program {
	private static void swap(int[] x) {
		int t = x[0]; 
		x[0] = x[1]; 
		x[1] = t; 
		
	}
	public static void main(String[] args) {
		int[ ] a = {10,20}; 
		
		System.out.println(" a[0] : "  + a[0] + " a[1] :  " + a[1]);
		
		swap(a); 
		
		System.out.println(" a[0] : "  + a[0] + " a[1] :  " + a[1]);
	}

	

}
