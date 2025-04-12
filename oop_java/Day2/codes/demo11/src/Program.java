import java.util.BitSet;
import java.util.Calendar;
import java.util.Scanner;

//Step 1 : Understand requirement and Declare the class 
//Step 2: Declare the fields 
//step3 : Creating the instance 
//Step 4: access modifiers 
//step5:: calling methods

//step1 
class Date {
	// step2:
	// Fields
	private int day;
	private int month;
	private int year;

	
	public Date() {
		System.out.println("Parameterless constructed called...");
		Calendar c = Calendar.getInstance();
		day = c.get(Calendar.DATE);
		month = c.get(Calendar.MONTH) + 1;
		year = c.get(Calendar.YEAR);
	}
	
	//this = dt1 
	public Date(int day, int month, int year) {
		 System.out.println("Parametrized constructor");
		 this.day = day; 
		 this.month = month; 
		 this.year = year; 
	}

	// this = dt1
	public void acceptRecord() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Day : ");
		this.day = sc.nextInt();
		System.out.println("Month : ");
		this.month = sc.nextInt();
		System.out.println("Year : ");
		this.year = sc.nextInt();
	}

	public void prinRecord() {
		System.out.println(day + " / " + month + " / " + year);
	}
}

public class Program {
	
	public static void main(String[] args) {
		Date dt1 = new Date(); //on dt1 parameterless ctor will get called 
		dt1.prinRecord();
		Date dt2 = new Date();//on dt2 parameterless ctor will get called 
		dt2.prinRecord();
		Date dt3 = new Date(1, 1, 2010); //on dt3 parameterized ctor will get called
		dt3.prinRecord();
	}
	public static void main3(String[] args) {
		Date dt1 = new Date(1,1,2000); 
		dt1.prinRecord();
	}
	public static void main2(String[] args) {
		Date dt2 = new Date(); 
	}
	public static void main1(String[] args) {
		// step3:
		Date dt1 = new Date();
		dt1.prinRecord();

	}

}
