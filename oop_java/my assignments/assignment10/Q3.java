package assignment10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.util.Optional;

// longest word in text fileeeeeeee

public class Q3 {

	public static void main(String[] args) {
	
		List<String> lines = new ArrayList<>();
		
		String path = "C:\\Users\\Admin\\Documents\\workspace-spring-tool-suite-4-4.26.0.RELEASE\\Assignments Java\\src\\assignment10\\file.txt";
		
	try(BufferedReader br = new BufferedReader(new FileReader(path))) {
		
		String line;
		while((line = br.readLine()) != null) {
			lines.add(line);
		}
		
	}catch(Exception e){
			System.err.println("No such file !" + e.getMessage());
		}
	
	lines.forEach(System.out::println);
	
	System.out.println("\n----Longest word in this file is---- \n");
	
	Optional<String> longestWord = lines.stream()
            .flatMap(line -> Arrays.stream(line.split("\\s+"))) 
            .max((word1, word2) -> Integer.compare(word1.length(), word2.length())); 
        
        if (longestWord.isPresent()) {
            System.out.println(longestWord.get());
        } else {
            System.out.println("No words found in the file.");
        }
	
	}

}
