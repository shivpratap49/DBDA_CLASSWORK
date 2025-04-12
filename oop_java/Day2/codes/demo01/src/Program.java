
public class Program {

	public static void main(String[] args) {
		//Converting primitive type to wrapper type is called as Boxing 
		int a = 10; 
		Integer b = new Integer(a);  
		
		//Converting wrapper into primitive is called as unboxing 
		int c = b.intValue();  
		
		System.out.println(" a "  + a  + " b "  + b + " c " + c );
	}

}
