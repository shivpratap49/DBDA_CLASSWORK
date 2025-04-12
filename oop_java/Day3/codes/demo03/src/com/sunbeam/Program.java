package com.sunbeam;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		int[ ] arr1 = new int[4];
		
		int[ ] arr2 = new int[] {10,20,30,40};
		
		int[ ] arr3 = {10,20,30,40};
		
		for (int i = 0; i < arr3.length; i++) {
			System.out.println(""+arr3[i]);
		}
		
		double[] arr4 = new double[3]; 
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter the array elements :: ");
		for (int i = 0; i < arr4.length; i++) {
			arr4[i] = sc.nextDouble(); 
		}
		double result = arraySum(arr4); 
		System.out.println("Result : "+result);
	}

	public static double arraySum(double[] arr) {
		double total = 0.0; 
		for (int i = 0; i < arr.length; i++) {
			total = total + arr[i]; 
		}
		
		return total; 
	}

}
