package com.sunbeam;
import static com.sunbeam.Chair.getPrice;
import static com.sunbeam.Chair.setPrice;
// import all static members (fields + methods) from the Math class
import static java.lang.Math.*;

import java.util.Scanner;

public class Program01 {
	public static double circleArea(double rad) {
		//return Math.PI * rad * rad;
		return PI * rad * rad;
	}
	
	
	public static void main(String[] args) {
		//static local variables are not allowed in Java.
		//static int x = 1; // compiler error
		
		//Chair.setPrice(400.0);
		setPrice(400.0);
		//System.out.println("Chair price: " + Chair.getPrice());
		System.out.println("Chair price: " + getPrice()); // static members of other class can be accessed directly after import static
		
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter radius: ");
		double r = sc.nextDouble();
		//double a = Program01.circleArea(r);
		double a = circleArea(r); // static members of same class can be accessed directly
		System.out.println("Area: " + a);
	}
}
