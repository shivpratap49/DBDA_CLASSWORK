package assignment8;

import java.util.ArrayList;

public class prog3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Date");
        fruits.add("Elderberry");

        System.out.println("Original list of fruits:");
        System.out.println(fruits);

        String newFruit = "Blueberry";

        if (fruits.size() > 1) {
            fruits.set(1, newFruit);
        } else {
            System.out.println("The list does not have a second element to replace.");
        }

        System.out.println("\nModified list of fruits:");
        System.out.println(fruits);
    }
	

}
