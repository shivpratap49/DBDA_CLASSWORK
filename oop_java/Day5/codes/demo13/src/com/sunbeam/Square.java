package com.sunbeam;

public class Square implements Shape {
	private float side; 
	public Square() {
		// TODO Auto-generated constructor stub
	}
	public Square(float side) {
		this.side = side;
	}
	@Override
	public double calcArea() {
		return this.side * this.side; 
	}
	@Override
	public double calcPeri() {
		return 4 * this.side; 
	}
	
}
