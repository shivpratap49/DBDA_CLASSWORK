package com.sunbeam;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Program {
	
	
	static final String EMP_FILE = "C:/Users/sunbeam/Desktop/java_demos_dbda/Day13/demo05/emp.csv";
	/* 
	public static void main(String[] args) {
		try(FileInputStream fin = new FileInputStream(EMP_FILE)){
			try(Scanner sc = new Scanner(fin)){
				while(sc.hasNext()) {
					String line = sc.next(); 
					System.out.println(line);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}*/ 
	
	private static Emp parseEmp(String line) {
		String[] parts = line.split(","); 
		int empno = Integer.parseInt(parts[0]);
		String ename = parts[1]; 
		String job = parts[2]; 
		int mgr; 
		try {
			mgr = Integer.parseInt(parts[3]);
		} catch (NumberFormatException e) {
			mgr = 0; 
		} 
		String hire = parts[4]; 
		int sal = (int) Double.parseDouble(parts[5]);  
		int comm; 
		try {
			comm = (int) Double.parseDouble(parts[6]);
		} catch (NumberFormatException e) {
			comm = 0; 
		}  
		int deptno = Integer.parseInt(parts[7]); 
		Emp e = new Emp(empno, ename, job, mgr, hire, sal, comm, deptno); 
		return e; 
		
	}
	/* 
	public static void main(String[] args) {
		List<Emp> list = new ArrayList<Emp>(); 
		try(FileInputStream fin = new FileInputStream(EMP_FILE)){
			try(Scanner sc = new Scanner(fin)){
				while(sc.hasNext()) {
					String line = sc.next(); 
					Emp e = parseEmp(line); 
					//System.out.println(line);
					list.add(e); 
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		int total = 0; 
		for (Emp e : list) {
			if(e.getJob().equals("MANAGER")) {
				total = total + e.getSal(); 
			}
		}
		System.out.println("Total Sal" + total);

	}
	*/ 
	public static void main(String[] args) {
		Path path = Paths.get(EMP_FILE); 
		try(Stream<String> strm = Files.lines(path)){
			int total = strm
						.map(line -> parseEmp(line))
						.filter(line -> line.getJob().equals("MANAGER"))
						.mapToInt(e -> e.getSal())
						.sum(); 
			System.out.println("Total " + total);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
