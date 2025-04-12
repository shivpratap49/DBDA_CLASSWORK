
public class Program {

	public static void main(String[] args) {
		//Converting primitive to wrapper is called as Boxing 
		int a = 10; 
		Integer b = new Integer(a); //Boxing 
		Integer c = a; //auto-boxing 
		
		//converting wrapper into primitive is called as unboxing 
		int d = b.intValue(); //unboxing  
		int e = c;//auto-unboxing  

	}

}
