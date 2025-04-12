package com.sunbeam;

@FunctionalInterface
public interface Shape {
	/*public static final*/ double PI = 3.142;
	
	/*public abstract*/ double calcArea(); // SAM
	/*public*/ default double calcPeri() {
		return 0.0;
	}
	
	// Java 8 allows to write static methods in interface -- No need to additional helper/utility class
	public static double calcTotalArea(Shape[] arr) {
		double total = 0.0;
		for (Shape sh : arr) {
			double area = sh.calcArea();
			total = total + area;
		}
		return total;
	}
}

/*
//helper/utility methods
class Shapes {
	public static double calcTotalArea(Shape[] arr) {
		double total = 0.0;
		for (Shape sh : arr) {
			double area = sh.calcArea();
			total = total + area;
		}
		return total;
	}
}
*/