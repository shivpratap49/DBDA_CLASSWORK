package com.sunbeam;

class Box<T> {
	private T obj;
	public void set(T obj) {
		this.obj = obj;
	}
	public T get() {
		return this.obj;
	}
}

public class Program06 {
	/*
	public static void main(String[] args) {
		// unbounded generic type references -- ? is wildcard -- any type is okay while creating object
		Box<?> b1; // T is Object
		b1 = new Box<String>(); // okay
		//b1 = new Box<Integer>(); // okay
		Object r1 = b1.get(); // get returns Object type
	}
	*/
	
	/*
	public static void main(String[] args) {
		// upper-bounded generic type references -- any type is okay that is Number or inherited from Number
		Box<? extends Number> b2; // T is Number
		//b2 = new Box<Number>(); // okay
		b2 = new Box<Integer>(); // okay
		//b2 = new Box<String>(); // error: String not extends Number 
		//b2 = new Box<Object>(); // error: Object not extends Number 
		Number r2 = b2.get(); // get returns Number type
	}
	*/
	
	/*
	public static void main(String[] args) {
		// lower-bounded generic type references -- any type is okay that is Number or its super-class.
		Box<? super Number> b3; // T is Number
		//b3 = new Box<Number>(); // okay
		//b3 = new Box<Integer>(); // error: Integer is not super-class of Number
		//b3 = new Box<String>(); // error: String is not super-class of Number
		b3 = new Box<Object>(); // okay: Object is super-class of Number 
		Object r3 = b3.get(); // get returns Object type
	}
	*/
	
	// static non-generic method
	public static void printAnyBox(Box<?> b) {
		Object obj = b.get();
		System.out.println("printBox() -- In Box: " + obj);
	}
	
	// static non-generic method
	public static void printNumberBox(Box<? extends Number> b) {
		Number obj = b.get();
		System.out.println("printBox() -- In Box: " + obj + " with value: " + obj.doubleValue());
	}
	
	// static non-generic method
	public static void printSuperNumberBox(Box<? super Number> b) {
		Object obj = b.get();
		System.out.println("printBox() -- In Box: " + obj);
	}

	public static void main(String[] args) {
		Box<String> b1 = new Box<>();
		b1.set("Hello");
		Box<Integer> b2 = new Box<>();
		b2.set(123);
		Box<Number> b3 = new Box<>();
		b3.set(new Double(3.14));
		Box<Object> b4 = new Box<>();
		b4.set(new Object());
		
//		printAnyBox(b1); // okay
//		printAnyBox(b2); // okay
//		printAnyBox(b3); // okay
//		printAnyBox(b4); // okay

//		printNumberBox(b1); // error: String is not Number
//		printNumberBox(b2); // okay: Integer extends Number
//		printNumberBox(b3); // okay: Number
//		printNumberBox(b4); // error: Object is not Number

//		printSuperNumberBox(b1); // error: String is not super-class of Number
//		printSuperNumberBox(b2); // error: Integer is not super-class of Number
//		printSuperNumberBox(b3); // okay: Number
//		printSuperNumberBox(b4); // okay: Object is super-class of Number
	}
}




















