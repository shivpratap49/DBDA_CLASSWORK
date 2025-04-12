package assignment6.com.app.fruits;
import java.util.Scanner;
import java.util.ArrayList;

public class FruitBasket {
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
 		
		System.out.println("-------------Add Fruit inFruit Basket-------------");
		System.out.println("1. Add Mango\n2. Add Orange\n3. Add Apple\n4. Display name of all fruits\n5. Display all FruitBasket Details\n6. Display tastes of all stale(not fresh) fruits in the basket\n7. Mark a fruit as stale\n8. Mark all sour fruits stale\n9. Exit");
		System.out.println("----------------------------------------------------------");
		int n=0;
		
		ArrayList<Fruit> basket = new ArrayList<>();
		
		int counter =0;
		int nm,weight,color;
		boolean flag = true;
		while(flag) {
		System.out.print("\nEnter Choice: ");
		n = sc.nextInt();
		switch(n) {
		case 1:
			basket.add(new Mango("Mango",2,"Yellow"));
			System.out.println("1 mango added");
			break;
		case 2:
			basket.add( new Orange("Orange",3,"Orange"));
			System.out.println("1 Orange added");
			break;
		case 3:
			basket.add(new Apple("Apple",5,"Red"));
			System.out.println("1 Apple added");
			break;
		case 4:
			System.out.print("All fruits you picked in order -> ");
			for (Fruit obj : basket) {
				System.out.print(obj.name+ ", ");
			}
			System.out.println();
			break;	
		case 5:
			for (Fruit obj : basket) {
				System.out.println(obj.toString());
			}
			break;
			
			
		case 9:
			flag = false;
			break;
		 default:
			 System.out.println("invalid input! ");
			 break;
		}
		
		}
		System.out.println("All the Fruits are succesfully added to fruit basked !\n");
		
	}

}
