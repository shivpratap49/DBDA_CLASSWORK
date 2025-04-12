package com.sunbeam;

import java.util.Collections;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Program06 {
	public static void main(String[] args) {
		TreeSet<String> set = new TreeSet<>();
		Collections.addAll(set, "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K");
		System.out.println("set = " + set);
		System.out.println("first: " + set.first()); // A
		System.out.println("last: " + set.last()); // K
		
		System.out.println("headSet: " + set.headSet("D")); // A, B, C -- D is excluded
		System.out.println("tailSet: " + set.tailSet("I")); // I, J, K -- I is included
		System.out.println("subSet: " + set.subSet("D", "G")); // D, E, F -- start included, end excluded
		
		System.out.println("higher: " + set.higher("D")); // E
		System.out.println("lower: " + set.lower("D")); // C
		
		// traverse set in reverse direction
		System.out.print("Rev Travsersal: ");
		Iterator<String> itr = set.descendingIterator();
		while (itr.hasNext()) {
			String ele = (String) itr.next();
			System.out.print(ele + ", ");
		}
		System.out.println();
		
		// get the descending set (new set)
		NavigableSet<String> descSet = set.descendingSet();
		System.out.println("Reversed Set: " + descSet);
	}
}
