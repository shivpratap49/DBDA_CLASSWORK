package com.sunbeam;

public class Product1 implements Comparable<Product1> {
	private int id;
	private String name;
	private double price;
	public Product1() {
	}
	public Product1(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product1 [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	@Override
	public int compareTo(Product1 o) {
		int diff = this.id - o.id;
		return diff;
	}
}






