package com.sunbeam;

import java.util.ArrayList;
import java.util.Date;

//generic programming -- Java 5.0 or above
class Box<TYPE> {
	private TYPE obj;
	public void set(TYPE obj) {
		this.obj = obj;
	}
	public TYPE get() {
		return this.obj;
	}
}

public class Program04 {
	public static void main(String[] args) {
		Box<Double> b1 = new Box<Double>();
		b1.set(new Double(3.14));
		Double r1 = b1.get();
		System.out.println("r1 = " + r1);
		
		Box<Date> b2 = new Box<Date>();
		b2.set(new Date());
		Date r2 = b2.get();
		System.out.println("r2 = " + r2);
		
		Box<String> b3 = new Box<String>();
		b3.set("123");
		//Integer r3 = b3.get(); // compiler error: compile time type checking = type-safety
		String r3 = b3.get(); 
		System.out.println("r3 = " + r3);

		/*
		Box b4 = new Box(); // warning: Box is a raw type
		b4.set(null); // set() arg = Object
		Object r4 = b4.get(); // get() returns = Object
		System.out.println("r4 = " + r4);
		*/
		
		Box<Object> b4 = new Box<>(); // no warning: T = Object -- given explicitly by programmer
		b4.set(null); // set() arg = Object
		Object r4 = b4.get(); // get() returns = Object
		System.out.println("r4 = " + r4);		
	}
	/*
	public static void main(String[] args) {
		// Java collections -- type-safety problem -- till Java 1.4
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(11);
		list.add(22);
		list.add(33);
		//list.add("44"); // -- compiler error -- compile time type-checking = type-safety
		for(Integer ele : list) {
			System.out.println(ele);
		}
	}
	*/
}
