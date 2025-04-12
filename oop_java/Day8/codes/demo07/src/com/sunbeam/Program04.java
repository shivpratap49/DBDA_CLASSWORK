package com.sunbeam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class Program04 {
	// Collection interface
	public static void main(String[] args) {
		Collection<String> c = new LinkedList<>();
		c.add("India");
		c.add("Africa");
		c.add("England");
		c.add("USA");
		c.add("India");
		c.add("Australia");
		c.add("West Indies");
		System.out.println("Size: " + c.size()); // 7
		System.out.println("toString(): " + c.toString());
		// for-each loop
		for(String ele : c)
			System.out.println(ele);
		c.remove("USA");
		System.out.println("toString(): " + c.toString()); // [India, Africa, England, India, Australia, West Indies]
		c.remove("India");
		System.out.println("toString(): " + c.toString()); // [Africa, England, India, Australia, West Indies]
		// traverse the collection -- using Iterator
		Iterator<String> trav = c.iterator();
		while(trav.hasNext()) {
			String ele = trav.next();
			System.out.println(ele);
		}
		c.clear();
		System.out.println("Size: " + c.size()); // 0
	}
}
