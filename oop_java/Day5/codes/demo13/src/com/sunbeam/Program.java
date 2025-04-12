package com.sunbeam;

public class Program {

	public static void main(String[] args) {
		Shape shape = new Rectangle(10, 2); 
		System.out.println("Area : "+shape.calcArea());
		System.out.println("Peri : "+shape.calcPeri());
		
		shape = new Square(4); 
		System.out.println("Area : "+shape.calcArea());
		System.out.println("Peri : "+shape.calcPeri());
		
		shape = new Circle(3.1f);  
		System.out.println("Area : "+shape.calcArea());
		System.out.println("Peri : "+shape.calcPeri());
		
	}

}
