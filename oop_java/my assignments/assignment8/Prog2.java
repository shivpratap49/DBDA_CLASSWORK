package assignment8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Prog2 {

	public static void main(String[] args) {

		 ArrayList<String> colors = new ArrayList<>();

	        colors.add("Red");
	        colors.add("Blue");
	        colors.add("Green");
	        colors.add("Yellow");
	        colors.add("Purple");
	        colors.add("Orange");

	        System.out.println("Original list of colors:");
	        System.out.println(colors);

	        Collections.sort(colors);

	        System.out.println("\nSorted list of colors:");
	        System.out.println(colors);
	    }

	}
	


