package com.sunbeam;

import java.util.HashSet;
import java.util.Set;

public class Program07 {
	public static void main(String[] args) {
		Box b = new Box(5, 4, 3);
		System.out.println("Hash Code: " + b.hashCode());
		
		Set<Box> set = new HashSet<>();
		set.add(new Box(5, 4, 3));
		set.add(new Box(3, 3, 3));
		set.add(new Box(10, 8, 6));
		set.add(new Box(5, 4, 3)); // duplicated -- hashCode() and equals() is implemented
		System.out.println("Size: " + set.size()); // 3
		
		for (Box box : set)
			System.out.println(box);
	}
}
