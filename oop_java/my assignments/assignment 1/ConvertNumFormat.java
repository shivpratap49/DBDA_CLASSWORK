import java.util.Scanner;
public class ConvertNumFormat {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number: ");
		int num = sc.nextInt();
		
		System.out.println("Given Number: " + num);
		
		System.out.println("Binary Equivalent: " + Integer.toBinaryString(num));
		System.out.println("Octal Equivalent: " + Integer.toOctalString(num));
		System.out.println("HexaDecimal Equivalent: " + Integer.toHexString(num));
		
	}

}
