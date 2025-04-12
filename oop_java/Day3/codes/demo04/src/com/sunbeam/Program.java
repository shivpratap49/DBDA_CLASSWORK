package com.sunbeam;

public class Program {

	public static void main(String[] args) {
		Human[ ] arr = new Human[3]; 
		
		arr[0] = new Human(31, 66, 160);
		arr[1] = new Human(33, 76, 170);
		arr[2] = new Human(35, 88, 192); 
		
		for (int i = 0; i < arr.length; i++) {
			 arr[i].display();
		}

	}

}
