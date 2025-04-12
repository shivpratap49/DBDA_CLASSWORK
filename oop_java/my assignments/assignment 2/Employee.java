package assginment2;
import java.util.Scanner;
public class Employee {
	
	String firstName;
	String lastName;
	double monthSalary;
	
	public Employee() {
		this.firstName = "";
		this.lastName = "";
		this.monthSalary=0;
	}
	
	
		
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public double getSalary() {
		return monthSalary;
	}
	public void setSalary(double salary) {
		if(salary>=0) {
			this.monthSalary = salary;
			return;
		}
		System.out.println("You entered salary less than 0, you ain't employee !");
	}

 static void empDetails(Employee emp) {
	Scanner sc  = new Scanner(System.in);
	
	emp = new Employee();
	
	System.out.println("Enter first name = ");
	String fname = sc.next();
	emp.setFirstName(fname);
	
	System.out.println("Enter last name = ");
	String lname = sc.next();
	emp.setFirstName(lname);
	
	System.out.println("Enter month salary = ");
	int monthSalary = sc.nextInt();
	emp.setSalary(monthSalary);
			
	sc.close();
}
 
 void employeeTest(Employee emp) {
	 double tenPer = emp.monthSalary*0.1;
	 double  new_sal = emp.monthSalary+tenPer; 
	 System.out.println(emp.firstName +" "+emp.lastName+", "+"Old monthly salary = "+ emp.monthSalary+ ", now after 10% raise its =  "+new_sal);
 }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of employees: ");
		int empCount = sc.nextInt();
		
		Employee[] arr = new Employee[empCount];
		
		int i=0;
 		int n = arr.length;
 		while(n>0) {
 		empDetails(arr[i]);
 		n--;	
 		i++;
 		}
 		
 		n = arr.length;
 		i=0;
 		while(n>0) {
 			arr[i].employeeTest(arr[i]);
 		
 			n--;
 			i++;
 		}
 		
 		
 		sc.close();
	}

}
