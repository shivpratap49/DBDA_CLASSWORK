package com.sunbeam;

public class Program02 {
	public static void main(String[] args) {
		try {
			Time t1 = new Time();
			t1.setHrs(10);
			t1.setMins(13);
			t1.setSecs(65);
			System.out.println("t1 -- " + t1.toString());
		} catch (InvalidTimeException e) {
			System.out.println("Exception Message: " + e.getMessage());
			System.out.println("Invalid Time Field: " + e.getInvalidField());
			System.out.println("Invalid Field Value: " + e.getInvalidValue());
		}
	}
}
