package com.sunbeam;

import java.util.Scanner;

public class Emp {
	private int id;
	private String name;
	private double sal;
	private Date joining;
	public Emp() {
		this.id = 0;
		this.name = "";
		this.sal = 0.0;
		//this.joining = null; // ref type fields are auto-initialized to null
		this.joining = new Date();
	}
	public Emp(int id, String name, double sal, Date joining) {
		this.id = id;
		this.name = name;
		this.sal = sal;
		this.joining = joining;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public Date getJoining() {
		return joining;
	}
	public void setJoining(Date joining) {
		this.joining = joining;
	}
	
	public void accept() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Id: ");
		this.id = sc.nextInt();
		sc.nextLine(); // discards \n in input buffer
		System.out.print("Name: ");
		this.name = sc.nextLine();
		System.out.print("Sal: ");
		this.sal = sc.nextDouble();
		System.out.print("Joining ");
		this.joining.accept();
	}
	public void display() {
		System.out.printf("Id: %d\nName: %s\nSal: %f\n", this.id, this.name, this.sal);
		//System.out.printf("Joining Date: %d-%d-%d\n", this.joining.getDay(), this.joining.getMonth(), this.joining.getYear());
		System.out.printf("Joining ");
		this.joining.display();
	}
}
