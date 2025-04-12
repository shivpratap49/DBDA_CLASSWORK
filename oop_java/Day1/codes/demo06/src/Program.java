
public class Program {
	public static void main1(String[] args) {
		double a = 10.00; 
		int b = (int) a; //narrowing 
		System.out.println("b :" +b);
		System.out.println("a :" +a);
	}
	public static void main(String[] args) {
		 int a = 10; 
		 //double b = (double)a;
		 double b = a; // widening 
		 System.out.print("a : "+a);
		 System.out.println();
		 System.out.print("b : "+b);
	}
}
