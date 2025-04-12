package com.sunbeam;

class Outer {
	static int outerField1 = 10;
	int outerField2 = 20;
	int field = 50;
	
	class Inner {
		final static int innerField1 = 30;
		int innerField2 = 40;		
		int field = 60;
		
		public void display() {
			System.out.println("innerField1: " + innerField1); // okay = 30
			System.out.println("innerField2: " + innerField2); // okay = 40
			System.out.println("Inner non-static field: " + field /* this.field */); // okay = 60
			
			System.out.println("outerField1: " + outerField1); // okay = 10
			System.out.println("outerField2: " + outerField2 /* this.outerField2 */); // okay = 20
			System.out.println("Outer non-static field: " + Outer.this.field); // okay = 50
		}
	}
}

public class Program03 {
	public static void main(String[] args) {
		//Outer.Inner inObj = new Outer.Inner(); // error
		Outer outObj = new Outer();
		Outer.Inner inObj = outObj.new Inner();
		inObj.display();
	}
}
