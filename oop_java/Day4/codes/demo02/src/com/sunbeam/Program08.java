package com.sunbeam;

/* final field can be initialized using field initializer, obj initializer, or constructor.
 * Once initialized, it cannot be modified again.
 * However, final fields must be initialized (in any of the above options). If not, compiler raise error.
 */

class Circle {
	private double radius;
	public final double PI = 3.14; // field initializer
	{	// object intializer
		//PI = 3.14; // allowed if not initialized in field initializer; otherwise error
	}
	public Circle(double r) {
		//PI = 3.14; // allowed if not initialized in field/object initializer; otherwise error
		this.radius = r;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double calcArea() {
		return PI * this.radius * this.radius;
	}
	public double calcPeri() {
		return 2 * PI * this.radius;
	}
}

public class Program08 {
	public static void main(String[] args) {
		final double rad; // final var declaration
		rad = 7; // final var initialization
		//rad = 14; // compiler error: once initialized, cannot be modified
		Circle c1 = new Circle(rad);
		System.out.println("Area: " + c1.calcArea());
		System.out.println("Peri: " + c1.calcPeri());
		
		final double rad2 = 14; // final var declaration & initialization
		final Circle c2 = new Circle(rad2); // final ref declaration & initialization
		c2.setRadius(70); // obj state can be modified (as reference is final)
		//c2 = null; // compiler error: reference once initialized, cannot be modified
		System.out.println("Area: " + c2.calcArea());
		System.out.println("Peri: " + c2.calcPeri());
		
		final int a = 10; // valid syntax
		//int final b = 20; // compiler error -- invalid syntax
	}
}





