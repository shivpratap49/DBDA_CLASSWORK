package com.sunbeam;
public class Program {
	// java 5.0 => variable arity method
	public static double arraySum(double... arr1) {
		double total = 0.0; 
		for (int i = 0; i < arr1.length; i++) {
			total = total + arr1[i]; 
		}
		return total; 
		
	}
	public static void print(Object... arr1) {
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		} 
		
	}
	public static void main(String[] args) {
		double r1 = arraySum(1.1,2.1,3.1);
		System.out.println("r1 : "+r1);
		
		double r2 = arraySum(5.1,5.2); 
		System.out.println("r2 : "+r2);
		
		print(10 , 10.2 , "Hello"); 
	}
}

/* 
public class Program {
	public static double arraySum(double[] arr1) {
		double total = 0.0; 
		for (int i = 0; i < arr1.length; i++) {
			total = total + arr1[i]; 
		}
		return total; 
		
	}
	public static void main(String[] args) {
		double[ ] arr1 = {1.1,2.2,3.3,4.4}; // Named array 
		double res = arraySum(arr1); 
		System.out.println("Res : "+res);
		
		double[ ] arr2 = {1.1,2.2,3.3}; // Named array
		res = arraySum(arr2);  
		System.out.println("Res : "+res);
		
		res = arraySum(new double[] {5.1,5.2,5.3} ); //Anonymous array 
		System.out.println("Res : "+res);
	}

	

	

}
*/ 
/* 
public class Program {
	//method overloading ==> same name but different number of arguments 
	private static void add(int i, int j) {
		int res = i + j; 
		System.out.println("res : "+ res );
		
	}
	private static void add(int i, int j , int k ) {
		int res = i + j + k; 
		System.out.println("res : "+ res );
		
	}
	private static void add(int i, int j , int k , int l  ) {
		int res = i + j + k + l; 
		System.out.println("res : "+ res );
		
		
	}
	public static void main(String[] args) {
		add(10,20);
		add(10,20,30);
		add(10,20,30,40);

	}

	

}
*/ 