package com.sunbeam;

interface A{
	int num1 = 10; 
	int num4 = 20; 
	int num5 = 30; 
}
interface B{
	int num2 = 40; 
	int num4 = 50; 
	int num5 = 60; 
}
//Multiple  Interface inheritance 
interface C extends A , B{
	int num3 = 70; 
	int num4 = 80; 
}

public class Program {

	public static void main(String[] args) {
		System.out.println("num3 : "+C.num3);
		System.out.println("num4 : "+C.num4);
		//System.out.println("num4 : "+C.num5); // NOT OK 
	}
	public static void main2(String[] args) {
		System.out.println("num2 : "+B.num2);
		System.out.println("num4 : "+B.num4);
		System.out.println("num5 : "+B.num5);
	}
	public static void main1(String[] args) {
		System.out.println("num1 : "+A.num1);
		System.out.println("num4 : "+A.num4);
		System.out.println("num5 : "+A.num5);

	}

}
