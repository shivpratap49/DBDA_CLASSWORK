package com.sunbeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class Program01 {
	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
		l.add("India");
		l.add("Japan");
		l.add("Italy");
		l.add("USA");
		l.add("Africa");
		l.add("Australia");
		l.add("Germany");
		System.out.println("Size: " + l.size()); // 7
		System.out.println("List: " + l.toString());
		
		// random access -- add new element at index
		l.add(3, "England");
		System.out.println("Size: " + l.size()); // 8
		
		System.out.println("List: " + l.toString());
		
		// random access -- get element at index
		int index = 5;
		String e5 = l.get(index);
		System.out.println("Element at 5th Index: " + e5);
		
		// random access -- set/overwrite element at index
		e5 = e5.toUpperCase();
		l.set(index, e5);
		System.out.println("List: " + l.toString());
		
		// random access -- delete element at index
		l.remove(index);
		System.out.println("List: " + l.toString());
		
		// check if element is present in list/collection -- Collection.contains()
		String find = "USA";
		boolean found = l.contains(find);
		if(found)
			System.out.println("contains() - Element Found: " + find);
		else
			System.out.println("contains() - Element Not Found: " + find);
		
		// find element and access it -- indexOf() -- internally does linear search from 0 to n-1 indices
		int idx = l.indexOf(find);
		if(idx != -1)
			System.out.println("indexOf() - Element Found: " + l.get(idx) + " at index: " + idx);
		else
			System.out.println("indexOf() - Element Not Found: " + find);
		
		// find element and access it -- lastIndexOf() -- internally does linear search from n-1 to 0 indices
		idx = l.lastIndexOf(find);
		if(idx != -1)
			System.out.println("lastIndexOf() - Element Found: " + l.get(idx) + " at index: " + idx);
		else
			System.out.println("lastIndexOf() - Element Not Found: " + find);
		
		// bi-directional traversal -- forward direction
		System.out.print("FWD Order: ");
		// itr is by default refers to first element
		ListIterator<String> trav = l.listIterator();
		while(trav.hasNext()) {
			String ele = trav.next();
			System.out.print(ele + ", ");
		}
		System.out.println();
		
		// bi-directional traversal -- reverse direction
		System.out.print("REV Order: ");
		// itr should refer to after the last element
		trav = l.listIterator(l.size());
		while(trav.hasPrevious()) {
			String ele = trav.previous();
			System.out.print(ele + ", ");
		}
		System.out.println();
		
		l.clear(); // delete all
		
		Collections.addAll(l, "Nitin", "Nilesh", "Rohan", "Akshita", "Amit");
		System.out.println("List: " + l.toString());
		
		Collections.sort(l); // natural ordering
		System.out.println("Asc Sorted List: " + l.toString());

		//Collections.sort(l, comparator);
		
		Collections.shuffle(l);
		System.out.println("Shuffled List: " + l.toString());
		
		class StringComparator implements Comparator<String> {
			@Override
			public int compare(String s1, String s2) {
				int diff = - s1.compareTo(s2);
				return diff;
			}
		}
		l.sort(new StringComparator()); // sort by given comparator
		System.out.println("Desc Sorted List: " + l.toString());
	
	}
}





















