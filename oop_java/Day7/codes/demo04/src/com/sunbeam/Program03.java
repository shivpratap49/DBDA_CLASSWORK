package com.sunbeam;

import java.util.ArrayList;
import java.util.Date;

// generic programming -- till Java 1.4
class Box {
	private Object obj;
	public void set(Object obj) {
		this.obj = obj;
	}
	public Object get() {
		return this.obj;
	}
}

public class Program03 {
	/*
	public static void main(String[] args) {
		Box b1 = new Box();
		b1.set(new Double(3.14));
		Double r1 = (Double) b1.get();
		System.out.println("r1 = " + r1);
		
		Box b2 = new Box();
		b2.set(new Date());
		Date r2 = (Date) b2.get();
		System.out.println("r2 = " + r2);
		
		Box b3 = new Box();
		b3.set("123");
		Integer r3 = (Integer) b3.get();
		System.out.println("r3 = " + r3);
	}
	*/
	public static void main(String[] args) {
		// Java collections -- type-safety problem -- till Java 1.4
		ArrayList list = new ArrayList();
		list.add(11);
		list.add(22);
		list.add(33);
		list.add("44");
		for(Object ele : list) {
			Integer num = (Integer) ele;
			System.out.println(num);
		}
	}
}
