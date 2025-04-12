package assignment10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q2 {

	public static void main(String[] args) {
		
		ArrayList<String> lines = new ArrayList<>();
		
		
		String path = "C:\\Users\\Admin\\Documents\\workspace-spring-tool-suite-4-4.26.0.RELEASE\\Assignments Java\\src\\assignment10\\file.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(path));) {
			String line;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
		} catch (Exception e) {
			System.err.println("Error reading the file: " + e.getMessage());
		}
		
		String[] linesArray = lines.toArray(new String[0]);
		
		List<String> ls = Arrays.asList(linesArray);
		ls.forEach(System.out::println);
	}

}
