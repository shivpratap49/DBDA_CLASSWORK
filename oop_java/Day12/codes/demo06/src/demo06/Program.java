package demo06;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Program {
	
	// get class metadata -- java.lang.Class object
	// String className; --> c = Class.forName(className);
	//inspect metadata(Class.forName(className))

	public static void main(String[] args) throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter the ClassName ");
		String className = sc.next(); 
		Class<?> c = Class.forName(className); 
		
		System.out.println("Name : "+c.getName());
		System.out.println("Super-class : " + c.getSuperclass());
		
		Class<?>[] intfs = c.getInterfaces(); 
		for (Class<?> intf : intfs) {
			System.out.println("Interfaces :: " + intf.getName());
		}	
		
		Field[] fields = c.getDeclaredFields(); 
		for (Field field : fields) {
			System.out.println("Fields : " + field.toString());
		}
		Method[] methods = c.getDeclaredMethods();  
		for (Method method : methods) {
			System.out.println("Methods :: " + method.toString());
		}
		Constructor<?>[] ctors = c.getDeclaredConstructors(); 
		for (Constructor<?> ctr : ctors) {
			System.out.println("Constructors : " + ctr.toString());
		}
		
	}

}
