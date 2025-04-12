package com.sunbeam;

public class Chair {
	private int height;
	private int weight;
	// static field initializer
	private static double price = 100; 
	
	static { // static block
		price = 200;
		System.out.println("static block 1");
	}
	static { // static block
		price = 300;
		System.out.println("static block 2");
	}
	
	public Chair() {
		this(0, 0); // constructor chaining
	}
	public Chair(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public static double getPrice() {
		return price;
	}
	public static void setPrice(double price) {
		Chair.price = price;
	}
	
	public void display() {
		System.out.printf("Height: %d, Weight: %d, Price: %f\n",
				this.height, this.weight, Chair.price);
	}
}
