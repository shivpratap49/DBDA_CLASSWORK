package com.sunbeam;

public class Student extends Person {
	private int roll;
	private String course;
	private int marks;
	
	public Student() {
		this.roll = 1;
		this.course = "";
		this.marks = 0;
		System.out.println("Student() called");
	}
	public Student(String name, int age, int roll, String course, int marks) {
		//this.name = name; // error: private members of Person not accessible in Student
		super(name, age); // invokes super class constructor
		this.roll = roll;
		this.course = course;
		this.marks = marks;
		System.out.println("Student(String,int,int,String,int) called");
	}
	
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	public void display() {
		//// getName() and getAge() inherited from Person to Student -- so accessible on "this" obj.
		//System.out.printf("Name: %s\nAge: %d\n", 
			//this.getName(), this.getAge());
		//// display() is also inherited from Person to Student -- 
		super.display();
		System.out.printf("Roll: %d\nCourse: %s\nMarks: %d\n",
				this.roll, this.course, this.marks);
	}
}
