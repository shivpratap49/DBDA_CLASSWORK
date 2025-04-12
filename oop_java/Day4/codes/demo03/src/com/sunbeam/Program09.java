package com.sunbeam;

class Chair {
	private int height, weight;
	private static int price = 100;
	public Chair() {
		this.height = 0;
		this.weight = 0;
	}
	public Chair(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}
	public void display() {
		System.out.printf("height: %d, weight: %d, ", 
				this.height, this.weight);
		//System.out.printf("price: %d\n", this.price); // accessible, but misleading
		System.out.printf("price: %d\n", Chair.price); // more readable 
	}
	public static void setPrice(int price) {
		Chair.price = price;
	}
	public static int getPrice() {
		return Chair.price;
	}
}

public class Program09 {
	public static void main(String[] args) {
		Chair c1 = new Chair(2, 3);
		Chair c2 = new Chair(3, 4);
		// In Java, static members can be accessed using object name -- however this misleading
		//c1.price = 200;
		//Chair.price = 200; // allowed: if price not declared private
		//c1.setPrice(200); // allowed but misleading
		Chair.setPrice(200); 
		c1.display();
		c2.display();
		System.out.println("Chair price: " + Chair.getPrice());		
	}
}
