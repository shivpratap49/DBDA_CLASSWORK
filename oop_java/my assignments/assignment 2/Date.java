package assginment2;

import java.util.Calendar;
import java.util.Scanner;

public class Date {
	int day;
	int month;
	int year;
	

	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Date(int day, int date, int year) {
		super();
		this.day = day;
		this.month = date;
		this.year = year;
	}

	public void displayDate() {
		System.out.println(getDay()+"/"+getMonth()+"/"+getYear());
	}

	public static void main(String[] args) {
		 
		Scanner sc = new Scanner(System.in);
		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DAY_OF_MONTH);
		int month = c.get(Calendar.MONTH);
		int year = c.get(Calendar.YEAR);
		
		Date today = new Date(day, month, year);
		System.out.print("Todays Date = ");
		today.displayDate();
		
		System.out.print("\nDo you wish to change the date ?  1 for Yes, 0 for No => ");
		int choice = sc.nextInt();
		
		if(choice == 0 )
			System.out.println("Okay bye...");
		else if(choice ==1) {
			
			System.out.print("Enter day = ");
			int new_day = sc.nextInt();
			today.setDay(new_day);
			
			System.out.print("Enter month = ");
			int new_month = sc.nextInt();
			today.setMonth(new_month);
			
			System.out.print("Enter year = ");
			int new_year = sc.nextInt();
			today.setYear(new_year);
		}
		else
			System.out.println("Invalid , bbye!");
		
		System.out.print("\nTodays Changed  Date = ");
		today.displayDate();
		
	}
	

}
