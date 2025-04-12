package tester;
import java.awt.Point;
import java.util.Scanner;
import com.app.geometry.Point2D;

public class TestPointArray1 {
	
	static void displayMenu() {
		System.out.println("\n1) Display details of a specific point");
		System.out.println("2) Display x, y co-ordinates of all points");
		System.out.println("3) User i/p : 2 indices for the points , validate the indices");
		System.out.println("4) Exit");
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of points you want to plot => ");
		int points = sc.nextInt();
		
		Point2D[] arr = new Point2D[points];
		
		int i =0;
		int n = points;
		
		while(n>0) {
			System.out.print("for new point Enter X cords = ");
			double x  = sc.nextDouble();

			System.out.print("for new point  Enter Y cords = ");
			double y  = sc.nextDouble();
			
			arr[i] = new Point2D(x,y);
			
			n--;
			i++;
			System.out.println();
		}
 		System.out.println("All points are saves succesfully !\n");
 		
 		while(true) {
 			displayMenu();
 			System.out.print("Enter choice => ");
 			int key = sc.nextInt();
 			
 			if (key==4) {
 				System.out.println("Bye....");
 				break;
 			}
 			
 		switch (key) {
 			
			case 1:
				System.out.print("Enter index => ");
				int index = sc.nextInt();
				if(index< arr.length) {
					 System.out.println(arr[index].getDetails());
				}
				else
					System.out.println("Invalid index, please retry.");
				break;
				
			case 2:
				System.out.println("====Displaying all points co-ordinates===");
				for(Point2D curr_point : arr) {
					System.out.println(curr_point.getDetails());
				}
				break;
			
			case 3:
				
				System.out.print("Enter Index of first point = >");
				int ind1 = sc.nextInt();
				if(ind1>=arr.length) {
					 System.out.println("Invalid index number!");
					 return;
				}

				System.out.print("Enter Index of Second point = >");
				int ind2 = sc.nextInt();
				
				if(ind2>=arr.length) {
					 System.out.println("Invalid index number!");
					 return;
				}
				
				Point2D.calculateDistanceOfTwoPoints(arr[ind1],arr[ind2]);
				break;
			case 4:
				System.out.println("Bye bye...");
				return;
				
			default:
				System.out.println("Invalid choice !");
				break;
			}
 		}
		
	}

}
