package assignment5;

public class NumbOfWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "hello awesome whats up";
		
		String arr = str.trim();
		if(arr.isEmpty())
			System.out.println("Empty string");
		else {
			String[] word = arr.split("\\s+");
			
			int count = word.length;
			
			System.out.println("total words : "+count);
		}
		}

}
