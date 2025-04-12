package com.sunbeam;

public class Employee extends Person{
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