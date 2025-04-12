import java.util.Scanner;

class Employee{
	//Fields 
	private String name; //Instance variable 
	private int empid; //Instance variable
	private float salary; //Instance variable
	
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
		
		//Employee emp2 = new Employee(); 
		//emp2.acceptRecord();//emp2.acceptRecord(emp2);
	}
	public static void main3(String[] args) {
		Employee emp; //Object reference 
		//emp.acceptRecord();//NOT OK 
		new Employee(); // anonymous instance 
	}
	public static void main2(String[] args) {
		//emp1 , emp2 , emp3 are reference will get memory on java stack 
		 Employee emp1 = new Employee();
		 Employee emp2 = new Employee();
		 Employee emp3 = new Employee();
	}
	public static void main1(String[] args) {
		Employee emp = new Employee(); 
		//emp : Object reference 
		//new Employee() => Instance 
		emp.acceptRecord();//message passing 
		emp.printRecord();//message passing 
	}

}


