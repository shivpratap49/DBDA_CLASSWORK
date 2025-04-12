package com.sunbeam;

public class Program01 {
	public static void main(String[] args) {
		Shape[] arr = {
			new Rectangle(5, 3),
			new Square(10),
			new Circle(7)
		};
		
		//double totalArea = Shapes.calcTotalArea(arr);
		double totalArea = Shape.calcTotalArea(arr);
		System.out.println("Total Area: " + totalArea);
		
		for (Shape sh : arr) {
			double peri = sh.calcPeri();
			System.out.println(sh.toString() + " -- Peri = " + peri);
		}
	}
}
