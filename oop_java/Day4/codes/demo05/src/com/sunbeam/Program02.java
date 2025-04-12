package com.sunbeam;

public class Program02 {
	public static void main(String[] args) {
		//Singleton s = new Singleton(); // error: The constructor Singleton() is not visible
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		if(s1 == s2)
			System.out.println("Same obj");
		else
			System.out.println("Different obj");
	}
}
