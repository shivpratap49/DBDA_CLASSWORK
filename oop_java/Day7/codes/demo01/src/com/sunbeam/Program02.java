package com.sunbeam;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program02 {
	/*
	// handling the possible errors -- programmatically
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter numerator and denominator: ");
		int num = sc.nextInt();
		int den = sc.nextInt();
		if(den != 0) {
			int res = num / den;
			System.out.println("Result: " + res);
		}
		else
			System.out.println("Cannot Divide by Zero.");
	}
	*/
	/*
	// detect the possible errors -- programmatically
	// handling of problem -- may not be acceptable in all scenarios
	public static int divide(int num, int den) {
		if(den == 0) {
			System.out.println("Cannot Divide by Zero.");
			System.exit(0);
		}
		int res = num / den;
		return res;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter numerator and denominator: ");
		int num = sc.nextInt();
		int den = sc.nextInt();
		int result = divide(num, den);
		System.out.println("Result: " + result);
	}
	*/
	
	/*
	// detect the problem and throw the problem
	public static int divide(int num, int den) {
		if(den == 0)
			throw new RuntimeException("Divide By Zero");
		int res = num / den;
		return res;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Enter numerator and denominator: ");
			int num = sc.nextInt();
			int den = sc.nextInt();
			int result = divide(num, den);
			System.out.println("Result: " + result);
		}
		catch (RuntimeException e) {
			System.out.println("Divide Error");
		}
	}
	*/
	
	/*
	// detect the problem and throw the problem
	public static int divide(int num, int den) {
		int res = num / den; // divide operator may throw ArithmeticException
		return res;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// we can write separate catch block for each possible exception
		try {
			System.out.print("Enter numerator and denominator: ");
			int num = sc.nextInt(); // may throw InputMismatchException
			int den = sc.nextInt();
			int result = divide(num, den);
			System.out.println("Result: " + result);
		}
		catch (InputMismatchException e) {
			System.out.println("Invalid User Input.");
		}
		catch (ArithmeticException e) {
			System.out.println("Divide Error");
		}
	}
	*/
	/*
	// detect the problem and throw the problem
	public static int divide(int num, int den) {
		int res = num / den; // divide operator may throw ArithmeticException
		return res;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// we can write common catch block for multiple exceptions
		try {
			System.out.print("Enter numerator and denominator: ");
			int num = sc.nextInt(); // may throw InputMismatchException
			int den = sc.nextInt();
			int result = divide(num, den);
			System.out.println("Result: " + result);
		}
		catch (InputMismatchException | ArithmeticException e) {
			System.out.println("Some Problem Occurred.");
		}
	}
	*/
	/*
	// detect the problem and throw the problem
	public static int divide(int num, int den) {
		int res = num / den; // divide operator may throw ArithmeticException
		return res;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// we can write common catch block for multiple exceptions
		try {
			System.out.print("Enter numerator and denominator: ");
			int num = sc.nextInt(); // may throw InputMismatchException
			int den = sc.nextInt();
			int result = divide(num, den);
			System.out.println("Result: " + result);
			//sc.close(); // will not execute if exception occurrs
		}
		catch (InputMismatchException | ArithmeticException e) {
			//sc.close(); // will not execute if exception doesn't occur
			System.out.println("Some Problem Occurred.");
		}
		finally {
			sc.close(); // will execute irrespective of exception
			// alternate option is to use try-with-resource -- learned yesterday
		}
	}
	*/
	
	// detect the problem and throw the problem as checked exception
	public static int divide(int num, int den) throws Exception {
		if(den == 0)
			throw new Exception("Divide By Zero");
		int res = num / den;
		return res;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Enter numerator and denominator: ");
			int num = sc.nextInt();
			int den = sc.nextInt();
			int result = divide(num, den); // checked exception -- handled with catch block
			System.out.println("Result: " + result);
		}
		catch (Exception e) {
			System.out.println("Divide Error");
		}
	}

}
