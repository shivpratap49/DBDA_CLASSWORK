package demo09;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {
	
	/* 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter the path :: ");
		String path = sc.next(); 
		File file = new File(path); 
		
		boolean success = file.mkdir(); 
		System.out.println("Directory Created " + success);
	}
	*/
	/* 
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter the path :: ");
		String path = sc.next(); 
		File file = new File(path); 
		
		boolean success = file.createNewFile();  
		System.out.println("File Created " + success);
	}
	*/ 
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter the path :: ");
		String path = sc.next(); 
		File file = new File(path); 
		
		boolean success = file.delete();   
		System.out.println("Deleted" + success);
	}

}
