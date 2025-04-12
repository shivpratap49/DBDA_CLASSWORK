package com.sunbeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class Program02 {
	public static void main(String[] args) {
		List<Book> list = new ArrayList<>();
		
		Collections.addAll(list, 
			    new Book(4, "The Alchemist", "Novel", 493.23),
			    new Book(1, "The Archer", "Novel", 723.53),
			    new Book(5, "The Fountainhead", "Novel", 652.73),
			    new Book(2, "Atlas Shrugged", "Novel", 872.94),
			    new Book(6, "Harry Potter", "Novel", 423.68),
			    new Book(3, "Lord of Rings", "Novel", 621.53)
			);
		
		// random access -- get(), set(), add(), remove()
		int index = 3;
		Book b = list.get(index);
		System.out.println(index + "th Index Element: " + b.toString());
	
		// bi-directional traversal -- reverse and forward
		System.out.println("List is Reverse order: ");
		ListIterator<Book> trav = list.listIterator(list.size());
		while(trav.hasPrevious()) {
			Book ele = trav.previous();
			System.out.println(ele);
		}
		
		// searching -- find given element -- indexOf(), lastIndexOf(), contains(), remove(obj)
		//	to function these methods correctly, the element class (like Book) must have overridden equals() method
		//	and equals() should compare on desired fields (like id).
		int id = 5; // sc.nextInt();
		Book key = new Book();
		key.setId(id);
		int idx = list.indexOf(key);
		if(idx != -1) {
			Book ele = list.get(idx);
			System.out.println("Found at Index: " + idx + " " + ele.toString());
		}
		else
			System.out.println("Book Not Found.");
		
		Collections.sort(list); // natural ordering -- Comparable in Book
		System.out.println("Asc Sorted Books (using Comparable -- Collections.sort())");
		for (Book bk : list)
			System.out.println(bk);
		
		System.out.println("Asc Sorted Books (using Comparator -- Collections.sort())");
		class BookNameComparator implements Comparator<Book> {
			@Override
			public int compare(Book x, Book y) {
				int diff = x.getName().compareTo(y.getName());
				return diff;
			}
		}
		Collections.sort(list, new BookNameComparator());
		for (Book bk : list)
			System.out.println(bk);
		
		System.out.println("Asc Sorted Books (using Comparator -- list.sort())");
		class BookPriceComparator implements Comparator<Book> {
			@Override
			public int compare(Book x, Book y) {
				int diff = Double.compare(x.getPrice(), y.getPrice());
				return diff;
			}
		}
		list.sort(new BookPriceComparator());
		for (Book bk : list)
			System.out.println(bk);

		
	}
}















