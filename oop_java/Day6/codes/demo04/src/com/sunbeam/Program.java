package com.sunbeam;
class Employee{
	private String name; 
	private int empid; 
	private float salary; 
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(String name, int empid, float salary) {
		super();
		this.name = name;
		this.empid = empid;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	//this = emp1 
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
		 return false; 
		if(this == obj)
		  return true; 
		if( !(obj instanceof Employee))
		  return false; 
		Employee other = (Employee) obj;
		if(this.empid == other.empid)
			return true; 
		return false; 
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", empid=" + empid + ", salary=" + salary + "]";
	}
	
}
public class Program {

	public static void main(String[] args) {
		Employee emp1 = new Employee("Aditya", 1, 1000.00f); 
		Employee emp2 = new Employee("Aditya", 1, 1000.00f); 
		
		if(emp1.equals("ABC"))  
			System.out.println("Equal");
		else 
			System.out.println("Not equal");
	}
	

}
