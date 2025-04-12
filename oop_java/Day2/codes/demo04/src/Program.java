import java.util.ArrayList;

public class Program {

	public static void main(String[] args) {
		//primitive to wrapper
		int a = 10; 
		Integer b = new Integer(a); //Boxing 
		Integer c = a; // auto-boxing 
		
		//wrapper to primitive
		int d = b.intValue(); //unboxing 
		int e = c; // auto-unboxing 
		
		//System.out.println("a " + a + " b " + b + " c " + c + " d " + d + " e " + e);
		
		//Boxing and unboxing takes time and memory 
		//not efficient
		Integer x = 10; //auto-boxing 
		Integer y = 20; //auto-boxing
		Integer z = x + y; 
		//x is auto-unboxed to 10 (primitive)
		//y is auto-unboxed to 20 (primitive)
		// now add => 10 + 20 => 30 
		// z is auto-boxed to 30 
		//System.out.println("z : "+z);
		
		//java collections works with only objects 
		ArrayList list = new ArrayList(); 
		list.add(x); 
		list.add(y); 
		list.add(new Integer(a));// Boxing 
		list.add(a); //auto-boxing 
		
		//System.out.println("List : "+list);
		
		int p = 10; 
		Integer q = p; //auto-boxing 
		
		//System.out.println("ByteValue : "+q.byteValue());
		//System.out.println("Double : "+q.doubleValue());
		//System.out.println("Float : "+q.floatValue());
		//System.out.println("Short : "+q.shortValue());
			
		  System.out.println("Size : "+Integer.SIZE);
		  System.out.println("Max : "+Integer.MAX_VALUE);
		  System.out.println("Max : "+Integer.MIN_VALUE);

	}

}
