package assignment9.Q4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class VariousList {

	public static void main(String[] args) {
		
		List<String> fruits = new ArrayList<>();
		Collections.addAll(fruits, 
				"Apple",
				"Banana",
				"Mango");
		System.out.println(fruits);
		fruits.forEach(e-> System.out.println(e));
		
		System.out.println("-----------------------");
		
		List<String> cities = new LinkedList<>();
        cities.add("New York");
        cities.add("Los Angeles");
        cities.add("Chicago");
        System.out.println(cities); 

        Vector<String> vector = new Vector<>();
        vector.add("One");
        vector.add("Two");
        vector.add("Three");
        System.out.println(vector);
        
        System.out.println("-------------");
        
        Stack<Integer> st = new Stack<>();
        st.push(33);
        st.push(45);
        st.push(12);
        st.pop();
        st.forEach(System.out::println);
	}

}
