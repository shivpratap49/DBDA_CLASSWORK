package com.sunbeam;

import java.time.LocalDate;

class Date implements Cloneable{
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
	protected Date clone() throws CloneNotSupportedException {
		Date other = (Date) super.clone(); //Creates and returns a copy of this object
		return other; 
	}
	
	@Override
	public String toString() {
		return "Date [day=" + day + ", month=" + month + ", year=" + year + "]";
	}
	
}
public class Program {

	public static void main(String[] args) throws CloneNotSupportedException {
		Date dt1 = new Date();
		Date dt2 = dt1.clone();  
		
		System.out.println(dt1.toString());
		System.out.println(dt2.toString());

	}

}
