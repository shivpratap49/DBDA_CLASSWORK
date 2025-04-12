package tester;

public class Ques3 {

	public static void main(String[] args)  {
			String[] array = {"atul","sharma","jai","hang","jai","in","jail","awesome","atul"};

			System.out.print("Duplicates => " );
			for (int i = 0; i < array.length - 1; i++) {
	            for (int j = i + 1; j < array.length; j++) {
	                if (array[i].equals(array[j]) && i != j) {
	                    System.out.print(array[j] + ", ");
	                }
	            }
	        }
 	
}
}
