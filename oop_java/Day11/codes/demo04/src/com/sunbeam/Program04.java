package com.sunbeam;

import java.util.function.BinaryOperator;

public class Program04 {
	// lambda expressions are referenced by functional interface reference.
	// lambda arg scope is limited to lambda expression body/implementation.
	// 
	public static void main(String[] args) {
		// non-capturing lambda
		BinaryOperator<Integer> op1 = (x,y) -> x + y;
		
		// capturing lambda - captures (attach) a variable out-side the lambda implementation.
		// can capture variables that are final or effectively final.
		int z = 10; // "z" is captured in lambda "op2"
		BinaryOperator<Integer> op2 = (x,y) -> x + y + z;
		//z++; // if z is modified, it cannot be captured into the lambda expression.
		
		int a = 22, b = 7;
		int r = op1.apply(a, b);
		System.out.println("op1 result: " + r); // 29
		
		r = op2.apply(a, b);
		System.out.println("op2 result: " + r); // 39
		
		calc(20, 10, (x,y) -> x * y);
		
		calc(20, 10, (x,y) -> x * y * z);
	}
	
	public static void calc(int n1, int n2, BinaryOperator<Integer> op) {
		int res = op.apply(n1, n2);
		System.out.println("Result: " + res);
	}
}








