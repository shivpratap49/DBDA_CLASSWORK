package com.sunbeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class Program04 {
	public static void main(String[] args) {
		//ArrayList<Double> list = new ArrayList<>();
		//LinkedList<Double> list = new LinkedList<>();
		Vector<Double> list = new Vector<>();
		
		Collections.addAll(list, 1.1, 2.2, 3.3, 4.4, 5.5);
		// works for all "Collection".
		System.out.println("Traversal using for-each loop: ");
		for(Double ele:list)
			System.out.print(ele + ", ");
		System.out.println("\n");
		
		// works for all "Collection".
		System.out.println("Traversal using Iterator: ");
		Iterator<Double> itr = list.iterator();
		while(itr.hasNext()) {
			Double ele = itr.next();
			System.out.print(ele + ", ");
		}
		System.out.println("\n");
		
		// works for all "List".
		System.out.println("Traversal using for loop - with index: ");
		for(int i = 0; i < list.size(); i++) {
			Double ele = list.get(i);
			System.out.print(ele + ", ");
		}
		System.out.println("\n");

		// works for "Vector".
		System.out.println("Traversal using Enumeration (Vector): ");
		Enumeration<Double> en = list.elements();
		while(en.hasMoreElements()) {
			Double ele = en.nextElement();
			System.out.print(ele + ", ");
		}
		System.out.println("\n");
		
		
	}
}
