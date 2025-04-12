package tester;
import com.app.geometry.Point2D;

import java.util.Scanner;



public class TestPoint {

	public static void main(String[] args) {
				Scanner sc = new Scanner(System.in);

				System.out.print("Enter X cords = ");
				double x  = sc.nextDouble();

				System.out.print("Enter Y cords = ");
				double y  = sc.nextDouble();
				
				Point2D cord1 = new Point2D(x,y);
				
				System.out.println(cord1.getDetails());
				
				
				System.out.print("\nEnter other's X cords = ");
				double x2  = sc.nextDouble();

				System.out.print("Enter others's Y cords = ");
				double y2  = sc.nextDouble();
				
				
				
				if (cord1.isEqual(x2,y2)) 
					System.out.println("P1 and P2 are located at same position");
				else
					System.out.println("Distance b/w these two Points is = " + cord1.caculateDistance(x2, y2));
				
				
				
		
	}

}

