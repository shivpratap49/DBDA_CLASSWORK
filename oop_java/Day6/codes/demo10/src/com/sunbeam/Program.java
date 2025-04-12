package com.sunbeam;

import java.util.Scanner;

public class Program {

	/* 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		System.out.print("Enter the number : ");
		int num = sc.nextInt(); 
		System.out.println("Square : "+num * num);
		// "sc" is not closed -- stdin in not closed -- resource leakage

	}
	*/ 
	/* 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		System.out.print("Enter the number : ");
		int num = sc.nextInt(); 
		System.out.println("Square : "+num * num);
		sc.close();

	}
	*/ 
	/* 
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in); 
		try {
			System.out.print("Entet a number: ");
			int num = sc.nextInt(); 
			System.out.println("Square: " + num * num);
		}
		finally {
			// finally block is always executed -- irrespective of exception
			System.out.println("Closing scanner.");
			sc.close(); // internally close System.in i.e. stdin
		}
	}*/ 
	/* 
	public static void main(String[] args) {
		// try-with-resource (since Java 7) ensure that resource is auto-closed.
		try(Scanner sc = new Scanner(System.in)) {
			System.out.print("Entet a number: ");
			int num = sc.nextInt(); 
			System.out.println("Square: " + num * num);
		} // sc.close(); // called automatically
	}
	*/ 
	public static void main(String[] args) {
		// local class -- not accessible outside the method.
		
		// custom resource class -- auto-closeable
		
		class MyResource implements AutoCloseable{
			//...
			public MyResource() {
				System.out.println("MyResource Created");
			}

			@Override
			public void close() {
				System.out.println("MyResource Closed");
				
			}
		}
		try(MyResource mr = new MyResource()){
			System.out.println("Using MyResource");
		}//mr.close 
	}

}
