package com.sunbeam;

public class Program {

	/* 
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append("Nilesh"); 
		sb.append(40); 
		sb.append('M'); 
		sb.append(75.45); 
		String str = sb.toString(); 
		System.out.println(str);
	}
	*/ 
	/* 
	public static void main(String[] args) {
		// capacity is size of internal char array
		// length is number of chars stored in that array
		StringBuffer sb = new StringBuffer(); 
		System.out.println("Capacity: " + sb.capacity() + ", Length: " + sb.length()); // Capacity: 16, Length: 0
		sb.append("0123456789");
		System.out.println("Capacity: " + sb.capacity() + ", Length: " + sb.length()); // Capacity: 16, Length: 10
		sb.append("ABCDEF");
		System.out.println("Capacity: " + sb.capacity() + ", Length: " + sb.length()); // Capacity: 16, Length: 16
		sb.append("GHIJKL");
		System.out.println("Capacity: " + sb.capacity() + ", Length: " + sb.length()); // Capacity: 34, Length: 22
	}*/ 
	/* 
	public static void main(String[] args) {
		String str = "Sunbeam"; 
		StringBuffer sb = new StringBuffer(str);
		sb.reverse(); 
		System.out.println(str);// "Sunbeam"
		System.out.println(sb.toString());// "maebnuS"
		
	}
	*/ 
	/* 
	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer("Sunbeam");
		StringBuffer sb2 = new StringBuffer("Sunbeam");
		System.out.println("sb1 == sb2 : " + (sb1 == sb2)); // false
		System.out.println("sb1.equals(sb2) : " + (sb1.equals(sb2))); // false
		// equals() is not overridden in StringBuffer class.
				//	So Object.equals() is called, that compares references.
	}
	*/ 
	public static void main(String[] args) {
		// StringBuffer (since Java 1.0) is thread-safe.
		// 	Internally uses synchronization objects, which slow down the execution.
		// StringBuilder (since Java 5.0) is not thread-safe.
		//	Not using synchronization objects, due to which it is faster than StringBuffer.
		// StringBuilder methods are same as StringBuffer methods.
		String str = "Sunbeam";
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		System.out.println(str);			// Sunbeam
		System.out.println(sb.toString());	// maebnuS
	}
}
