package com.sunbeam;

import java.time.LocalDate;

class Date{
	private int day; 
	private int month;
	private int year;
	public Date() {
		LocalDate ld = LocalDate.now(); 
		this.day = ld.getDayOfMonth(); 
		this.month = ld.getMonthValue(); 
		this.year = ld.getYear(); 
	}
	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
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
	@Override
	public String toString() {
		return "Date [day=" + day + ", month=" + month + ", year=" + year + "]";
	}
	
}
public class Program {

	public static void main(String[] args) {
		Date dt1 = new Date();
		Date dt2 = dt1; //shallow copy of references 
		System.out.println(dt1.toString());
		System.out.println(dt2.toString());

	}

}
