package com.sunbeam;

public class Person {
	private String name;
	private int age;
	public Person() {
		this.name = "";
		this.age = 1;
		System.out.println("Person() called");
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("Person(String,int) called");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void display() {
		System.out.printf("Name: %s\nAge: %d\n", this.name, this.age);
	}
}
