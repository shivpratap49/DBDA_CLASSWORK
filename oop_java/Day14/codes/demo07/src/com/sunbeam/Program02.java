package com.sunbeam;

class Outer {
	static int outerField1 = 10;
	int outerField2 = 20;
	static int field = 50;
	
	static class Inner {
		static int innerField1 = 30;
		int innerField2 = 40;		
		static int field = 60;
		
		public void display() {
			System.out.println("innerField1: " + innerField1); // okay = 30
			System.out.println("innerField2: " + innerField2); // okay = 40
			System.out.println("Inner static field: " + field); // okay = 60
			
			System.out.println("outerField1: " + outerField1); // okay = 10
			//System.out.println("outerField2: " + outerField2); // error
			System.out.println("Outer static field: " + Outer.field); // okay = 50
		}
	}
}

public class Program02 {
	public static void main(String[] args) {
		Outer.Inner inObj = new Outer.Inner();
		inObj.display();
	}
}
