package assignment10;

import java.io.File;
public class Q4 {

	public static void main(String[] args) {
		
		
		String path = "C:\\Users\\Admin\\Documents\\workspace-spring-tool-suite-4-4.26.0.RELEASE\\Assignments Java\\src\\assignment10\\file.txt";
		
		File f = new File(path);
		
		System.out.println("Is file hidden -> "+f.isHidden());
		

	}

}
