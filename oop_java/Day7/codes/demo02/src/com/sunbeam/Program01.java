package com.sunbeam;

import java.util.Scanner;

public class Program01 {
	public static int divide(int num, int den) {
		return num / den;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Enter two numbers: ");
			int n = sc.nextInt();
			int d = sc.nextInt();
			int r = divide(n, d);
			System.out.println("Result: " + r);
		}
		catch(Throwable e) {
			//System.out.println("Exception Message: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
