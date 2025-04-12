package com.sunbeam;
import java.util.Scanner;

enum Arithmetic 
{
	EXIT , ADDITION,SUBTRACTION,MULTIPLICATION,DIVISION
}

//enums are objects not int 
public class Program{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter two numbers: ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int result;
		System.out.println("\n0. Exit\n1. Add\n2. Subtract\n3. Multiply\n4. Divide\nEnter choice: ");
		//int choice = sc.nextInt();
		Arithmetic choice = Arithmetic.ADDITION;
		switch (choice) {
		case ADDITION:
			result = num1 + num2;
			System.out.println("Result: " + result);
			break;
		case SUBTRACTION:
			result = num1 - num2;
			System.out.println("Result: " + result);
			break;
		case MULTIPLICATION:
			result = num1 * num2;
			System.out.println("Result: " + result);
			break;
		case DIVISION:
			result = num1 / num2;
			System.out.println("Result: " + result);
			break;
		}
	}
}









