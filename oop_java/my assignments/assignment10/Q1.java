package assignment10;

import java.io.File;
import java.io.IOException;

public class Q1 {
	
public static void main(String[] args) throws IOException {
File f1 = new File("hello.txt");
	
	if(!f1.exists()) {
		System.out.println("File not exists ! Creating new file");
		boolean success = f1.createNewFile();
		System.out.println("File created successfully");
	}
	else {
		System.out.println("File found !");
		System.out.println(f1.getPath());
	}

}	
}
