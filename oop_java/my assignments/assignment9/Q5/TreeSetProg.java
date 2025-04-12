package assignment9.Q5;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetProg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<String> treeset = new TreeSet<>();
		 Collections.addAll(treeset, 
				 "red",
				 "pink",
				 "yellow");
		 
		 treeset.forEach(System.out::println);

	}

}
