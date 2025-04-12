import java.util.BitSet;
import java.util.Scanner;

//Step 1 : Understand requirement and Declare the class 
//Step 2: Declare the fields 
//step3 : Creating the instance 
//Step 4: access modifiers 
//step5:: calling methods

//step1 
class Date{
	//step2: 
	//Fields 
	private int day; 
	private int month; 
	private int year;
	
	//this = dt1 
	public void acceptRecord() {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Day : ");
		this.day = sc.nextInt(); 
		System.out.println("Month : ");
		this.month = sc.nextInt(); 
		System.out.println("Year : ");
		this.year = sc.nextInt(); 
	} 
	public void prinRecord(  ) {
		System.out.println(day + " / " + month + " / " + year );
	}
}

public class Program {

	public static void main(String[] args) {
		//step3: 
		Date dt1 = new Date();
		//step5: 
		dt1.acceptRecord( ); // dt1.acceptRecord(dt1); 
		dt1.prinRecord(); //dt1.prinRecord(dt1);
		
		Date birthDate = new Date();//Instantiation 
		birthDate.acceptRecord();//birthDate.acceptRecord(birthdate);
		birthDate.prinRecord();//birthDate.prinRecord(birthdate); 
		  

	}

}
