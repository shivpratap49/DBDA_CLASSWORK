import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		//Student : roll , name , marks 
		System.out.print("Enter the roll :: ");  
		int roll = sc.nextInt();  // 10 + '\n'
		System.out.println("Enter the name :: ");
		//String name = sc.nextLine();
		String name = sc.next();
		System.out.println("Enter the marks :: ");
		int marks = sc.nextInt(); 
		
		System.out.println("Name  : "+name);
		System.out.println("Roll : "+roll);
		System.out.println("Marks : "+marks);
	}

}
