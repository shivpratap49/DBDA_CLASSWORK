import java.util.Scanner;

class Employee{
	//Fields 
	private String name; //Instance variable 
	private int empid; //Instance variable
	private float salary; //Instance variable
	
	//this = emp1 
	//setter / mutator 
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	//this = emp1 
	//getter / inspector 
	public float getSalary() {
		return this.salary;
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

	//this = emp2
	public void acceptRecord( ) {
		Scanner sc = new Scanner(System.in); 
		System.out.print("Name : ");
		this.name = sc.nextLine(); 
		System.out.print("Empid : ");
		empid = sc.nextInt();
		System.out.print("Salary : ");
		salary = sc.nextFloat(); 
 	}
	//Faciliatator 
	//this = emp1 
	public void printRecord( ) {
		System.out.println("Name : "+this.name);
		System.out.println("Empid : "+empid);
		System.out.println("Salary : "+salary);
	}
}

public class Program {
	
	public static void main(String[] args) {
		Employee emp1 = new Employee(); 
		
		emp1.acceptRecord();//emp1.acceptRecord(emp1);
		emp1.printRecord();//emp1.printRecord(emp1);
		emp1.setSalary(10000.00f);//emp1.setSalary(emp1, 10000.00f);
		emp1.printRecord();
		System.out.println("Updated salary is :: "+emp1.getSalary());//emp1.getSalary(emp1)
		
	}
	

}


