
public class Program {

	public static void main(String[] args) {
		int a = 10; 
		String str = String.valueOf(a); // Boxing 
		System.out.println("str : "+str);
		
		String strNumber = "123"; 
		int b = Integer.parseInt(strNumber); // unboxing 
		System.out.println("b : "+b);
	}

}
