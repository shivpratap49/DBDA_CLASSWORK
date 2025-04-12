package com.sunbeam;

// generic class with bounded type parameter (T)
class Box<T extends Number> {
	private T obj;
	public void set(T obj) {
		this.obj = obj;
	}
	public T get() {
		return this.obj;
	}
}

public class Program05 {
	public static void main(String[] args) {
		Box<Integer> b1 = new Box<>(); // Integer is-a Number
		b1.set(new Integer(123));
		System.out.println("Integer: " + b1.get());
		
		Box<Double> b2 = new Box<>(); // Double is-a Number
		b2.set(new Double("3.14"));
		System.out.println("Double: " + b2.get());
		
		Box<Number> b3 = new Box<>(); // Number
		b3.set(new Long(1));
		System.out.println("Number: " + b3.get());
		
		//Box<String> b4 = new Box<>(); // compiler error: String is not Number
		//Box<Boolean> b5 = new Box<>(); // compiler error: Boolean is not Number
		//Box<Object> b4 = new Box<>(); // compiler error: Object is not Number 
	}
}
