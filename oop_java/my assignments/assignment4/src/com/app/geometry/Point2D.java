package com.app.geometry;
import java.lang.Math;

public class Point2D {

		double x;
		double y;
		
	public Point2D() {
		this(0,0);                   // constructor chaining
	}	
	
	public Point2D(double x, double y) {
			this.x = x;
			this.y = y;
		}


	public String getDetails() {
		return "Point2D [ x = "+x+", y = "+y+" ]";
	}


	public boolean isEqual(double x2,double y2) {
		return x==x2 && y==y2;
	}
	
	public double  caculateDistance(double x2,double y2) {
		return Math.sqrt(Math.pow((x2-x), 2) + Math.pow((y2-y), 2));
	}
	
	public static boolean  isEqualPoint(Point2D firstPoint, Point2D secondPoint) {
		return firstPoint.x == secondPoint.x && firstPoint.y == secondPoint.y;
	}
	
	public static void  calculateDistanceOfTwoPoints(Point2D firstPoint, Point2D secondPoint) {
		if (isEqualPoint(firstPoint,secondPoint)) 
			System.out.println("P1 and P2 are located at same position");
		else {
			double distance = Math.sqrt(Math.pow((secondPoint.x-firstPoint.x), 2) + Math.pow((secondPoint.y-firstPoint.y), 2));
			System.out.println("Distance b/w these two Points is = " + distance);
		}
	}
	
	public static void main(String[] args) {
		

	}

}
