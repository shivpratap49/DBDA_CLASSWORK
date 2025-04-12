package com.sunbeam;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Program04 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		//Set<String> set = new LinkedHashSet<>();
		//Set<String> set = new TreeSet<>();
		
		set.add("India"); // return true
		set.add("Japan"); // return true
		set.add("India"); // return false - already exists
		set.add("Gemany"); // return true
		set.add("Africa"); // return true
		set.add("India"); // return false - already exists
		set.add("USA"); // return true
		set.add("Japan"); // return false - already exists
		
		System.out.println("Size: " + set.size());
		
		for (String str : set)
			System.out.println(str);
	}
}
