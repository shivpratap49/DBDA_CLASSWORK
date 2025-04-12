package com.sunbeam;

public class Program03 {
	public static void main(String[] args) {
		Emp e1 = new Emp();
		e1.display();
		System.out.println();
		
		Date d2 = new Date(1, 5, 2004);
		Emp e2 = new Emp(3, "Nilesh Ghule", 50000.0, d2);
		e2.display();
		System.out.println();
		
		Emp e3 = new Emp();
		e3.accept();
		e3.display();
	}
}
