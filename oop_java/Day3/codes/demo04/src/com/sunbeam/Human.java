package com.sunbeam;

public class Human  {
   private int age , weight; 
   private int height; 
   
   public Human() {
	// TODO Auto-generated constructor stub
   }

	public Human(int age, int weight, int height) {
		this.age = age;
		this.weight = weight;
		this.height = height;
	}
	//getters / setters 
	public void display( ) {
		System.out.println("Age : " + age + " Weight " + weight + " Height " + height);
	}
	 
}
