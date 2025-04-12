package com.sunbeam;

public class Singleton {
	// fields and methods
	
	// static field to hold the single object
	private static Singleton obj;
	// create singleton object
	static {
		// static block executed only once, so only one object of the class will be created
		obj = new Singleton();
	}
	
	// if constructor is private, object of the class cannot be created outside that class
	private Singleton() {
		// fields initialization
		System.out.println("Singleton() called.");
	}
	
	// getter method to make obj accessible outside the class
	public static Singleton getInstance() {
		return obj;
	}
}
