package com.sunbeam;

class Person{
	String name; 
	int age; 
	
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
    int empid; 
	float salary; 
	
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
		Person p = new Person("Aditya", 31); 
		Employee emp = (Employee) p; 
	}
	public static void main6(String[] args) {
		Person p = new Employee("Aditya", 31, 1, 1000.00f); //upcasting 
		System.out.println("Name : "+p.name);
		System.out.println("Age : "+p.age);
		Employee emp = (Employee) p; // downcasting  
		System.out.println("Age : "+emp.age);
		System.out.println("Name : "+emp.name);
		System.out.println("Empid : "+emp.empid);
		System.out.println("Salary : "+emp.salary);
	}
	public static void main5(String[] args) {
		Employee emp = new Employee("Aditya", 31, 1, 1000.00f);
		Person p = emp; // upcasting 
		
		System.out.println("Name : "+p.name);
		System.out.println("Age : "+p.age);
		emp = (Employee) p;//downcasting  
		System.out.println("Age : "+emp.age);
		System.out.println("Name : "+emp.name);
		System.out.println("Empid : "+emp.empid);
		System.out.println("Salary : "+emp.salary);
	}
	public static void main4(String[] args) {
		Employee emp = new Employee("Aditya", 31, 1, 1000.00f); 
//		System.out.println("Age : "+emp.age);
//		System.out.println("Name : "+emp.name);
//		System.out.println("Empid : "+emp.empid);
//		System.out.println("Salary : "+emp.salary);
//		
		//Person p = (Person)emp;
		Person p = emp; // upcasting 
		System.out.println("Name : "+p.name);
		System.out.println("Name : "+p.age);
		//System.out.println("empid : "+p.empid); //NOT OK 
		//System.out.println("salary : "+p.salary);// NOT OK 
	}
	public static void main3(String[] args) {
		Person p1 = new Person("Aditya", 31); 
		System.out.println("Name : "+p1.name);
		System.out.println("Age : "+p1.age);
		//System.out.println("Empid : "+p1.empid);
		//System.out.println("Salary : "+p1.salary);
	}
	public static void main2(String[] args) {
		Employee emp = new Employee("Aditya", 31, 1, 1000.00f); 
		System.out.println("Age : "+emp.age);
		System.out.println("Name : "+emp.name);
		System.out.println("Empid : "+emp.empid);
		System.out.println("Salary : "+emp.salary);
		
		
	}
	public static void main1(String[] args) {
		Person p1 = new  Person("Aditya", 31); 
		System.out.println("Name : "+p1.name);
		System.out.println("Age : "+p1.age);
		
	}
	


}
