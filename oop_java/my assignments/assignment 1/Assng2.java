import java.util.Scanner;
public class Assng2 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	System.out.print("Enter first value: ");
	if(!sc.hasNextDouble()) {
		System.out.print("Not a double!");
		return;
	}
	double num1 = sc.nextDouble();
	if(!sc.hasNextDouble()) {
		System.out.print("Not a double!");
		return;
	}
	double num2 = sc.nextDouble();
	
	double avg = (num1+num2)/2;
	System.out.print(avg);

}
}
