package com.sunbeam;



class Person{
	private String name; 
	private int age; 
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void showRecord( ) {
		System.out.println("Name : "+this.name);
		System.out.println("Age : "+this.age);
	}
	
}
class Employee extends Person{
    private int empid; 
	private float salary; 
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, int age, int empid, float salary) {
		super(name, age); 
		this.empid = empid;
		this.salary = salary;
	}
	public void printRecord( ) {
		super.showRecord( ); 
		System.out.println("Empid : "+this.empid);
		System.out.println("Salary : "+this.salary);
	}
	
}

public class Program {

	public static void main(String[] args) {
		Employee emp = new Employee("Aditya", 31, 1, 1000.00f); 
		emp.printRecord();
	}
	public static void main1(String[] args) {
		Person p1 = new  Person("Aditya", 31); 
		p1.showRecord();
	}
	


}
