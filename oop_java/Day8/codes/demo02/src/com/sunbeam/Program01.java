package com.sunbeam;

class Fraction{
	private int n; 
	private int d;
	public Fraction(int n, int d) {
		this.n = n;
		this.d = d;
	} 
	private double value( ){
		return n/d; 
	}
	//this = f1
	// obj = f2 
	@Override
	public boolean equals(Object obj) {
		Fraction other = (Fraction) obj;
		if(this.value() == other.value())
			return true; 
		else 
			return false;  
	}
}

public class Program01 {
	public static void main(String[] args) {
			Fraction f1 = new Fraction(10, 2);
			Fraction f2 = new Fraction(10, 2);
			boolean b1 = f1.equals(f2); 
			System.out.println(b1);
			f1.equals("123"); //class cast exception 
	}		
}
