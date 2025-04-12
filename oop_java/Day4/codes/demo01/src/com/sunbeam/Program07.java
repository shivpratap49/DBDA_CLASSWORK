package com.sunbeam;

class MyClass {
	private int num1 = 1111; // field initializer
	private int num2;
	private int num3;
	private int num4 = 1; // field initializer
	
	{	// object/instance initializer -- since Java 5.0
		this.num2 = 111;
		System.out.println("initializer block 1");
	}
	
	{	// object/instance initializer -- since Java 5.0
		this.num4 = 2;
		System.out.println("initializer block 2");
	}
	
	{	// object/instance initializer -- since Java 5.0
		System.out.println("initializer block 3");
	}
	
	// constructor
	public MyClass() {
		this.num3 = 11;
		this.num4 = 3;
		System.out.println("constructor");
	}
	public void display() {
		System.out.printf("num1=%d, num2=%d, num3=%d, num4=%d\n",
				this.num1, this.num2, this.num3, this.num4);
	}
}

public class Program07 {
	public static void main(String[] args) {
		MyClass obj = new MyClass();
		obj.display();
	}
}
