package com.sunbeam;

import java.util.Arrays;
	/*
	 * 		Arrays class is a Helper class 
	 *      inside java.util 
	 *      Most of the methods are static 
	 *      They are called on classname 
	 * 
	 * 
	 */
public class Program {

	public static void main(String[] args) {
		int[ ] arr = {11,2,33,13,44}; 
		
		System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr);
		
		System.out.println(Arrays.toString(arr));
	}
	

}
