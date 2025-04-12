package com.sunbeam;

import java.util.Scanner;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date() {
		this(1, 1, 2000);
	}
	public Date(int day, int month, int year) {
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
	
	public void accept() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Date (day month year): ");
		this.day = sc.nextInt();
		this.month = sc.nextInt();
		this.year = sc.nextInt();
	}
	public void display() {
		System.out.printf("Date: %d-%d-%d\n", this.day, this.month, this.year);
	}
}
