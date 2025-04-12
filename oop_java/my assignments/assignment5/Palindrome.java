package assignment5;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "awewa";
		 String reverseStr = "";
	        
	        int strLength = str.length();
	        
	        for (int i = (strLength - 1); i >= 0; --i) {
	            reverseStr += str.charAt(i);
	        }
	        
	        if (str.equalsIgnoreCase(reverseStr)) {
	            System.out.println(str + ": is a Palindrome String.");
	        } else {
	            System.out.println(str + ": is not a Palindrome String.");
	        }

	}

}
