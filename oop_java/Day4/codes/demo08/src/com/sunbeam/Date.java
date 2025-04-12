package com.sunbeam;

public class Date extends Object {
	private int day, month, year;
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
	@Override
	public String toString() {
		return this.day + "-" + this.month + "-" + this.year;
	}
}
