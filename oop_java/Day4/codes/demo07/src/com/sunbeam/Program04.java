package com.sunbeam;

public class Program04 {
	public static void main(String[] args) {
		Student s1 = new Student();
		System.out.println();
		
		Student s2 = new Student("Nilesh", 20, 424, "DAC", 77);
		System.out.println("Name: " + s2.getName());
		System.out.println("Age: " + s2.getAge());
		System.out.println("Roll: " + s2.getRoll());
		System.out.println("Course: " + s2.getCourse());
		System.out.println("Marks: " + s2.getMarks());
		System.out.println();
		
		Student s3 = new Student("Sachin", 30, 10, "Cricket", 99);
		s3.display();
		System.out.println();
	}
}
