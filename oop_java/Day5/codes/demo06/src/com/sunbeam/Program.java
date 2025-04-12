package com.sunbeam;

import java.util.Scanner;

class Shape{
	protected float area; 
	
	public void acceptRecord( ) {
		//TODO 
	}
	public void calculateArea( ) {
		//TODO 
	}
	public void printRecord( ) {
		System.out.println("Area : "+this.area);
	}
}
class Rectangle extends Shape{
	private float length; 
	private float breadth; 
	
	@Override
	public void acceptRecord() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Length : ");
		this.length = sc.nextFloat(); 
		System.out.println("Breadth : ");
		this.breadth = sc.nextFloat(); 
	}
	@Override
	public void calculateArea() {
		this.area = this.length * this.breadth; 
	}
}
class Circle extends Shape{
	private float radius; 
	
	@Override
	public void acceptRecord() {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Radius : ");
		this.radius = sc.nextFloat(); 
	}
	@Override
	public void calculateArea() {
		this.area = (float) (Math.PI * this.radius * this.radius); 
	}
}
public class Program {
	public static int menu( ) {
		Scanner sc = new Scanner(System.in); 
		System.out.println("0.Exit");
		System.out.println("1.Rectangle");
		System.out.println("2.Circle");
		System.out.print("Enter the choice ::");
		return sc.nextInt(); 
	}
	public static void main(String[] args) {
		 int choice; 
		 while((choice = menu())!=0) {
			 Shape shape = null; 
			 switch (choice) {
			case 1:
				shape = new Rectangle(); //upcasting 
				break;
			case 2: 
				shape = new Circle(); //upcasting 
			}
			 if(shape!=null) {
				 //Dynamic method dispatch 
				 shape.acceptRecord(); 
				 shape.calculateArea(); 
				 shape.printRecord(); 
			 }
		 }

	}

}
