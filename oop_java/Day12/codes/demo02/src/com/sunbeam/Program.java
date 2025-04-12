package com.sunbeam;

import java.util.Comparator;
import java.util.Date;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;

//lambda expr = short-hand implementation of SAM (functional interface)
//method ref = short-hand of lambda expr
public class Program {

	public static void main(String[] args) {
		//BinaryOperator<Integer> op = (a,b) -> Integer.sum(a, b); //static
		
		BinaryOperator<Integer> op = Integer::sum; 
		//static method of a class --> ClassName.method(arg1, arg2); i.e. static method called on ClassName
		int a = 10 , b = 5; 
		int r = op.apply(a, b); 
		//System.out.println("Res " + r);
		
		
		//Comparator<String> cmp = (x,y) -> x.compareTo(y); 
		Comparator<String> cmp = String::compareTo; 
		String s1 = "Sunbeam" , s2 = "SunBeam"; 
		//System.out.println("Res " + cmp.compare(s1, s2));
			//non-static method of a class --> arg1.method(arg2); i.e. non-static method called on arg1
	
		//Consumer<Double> c = d -> System.out.println(d);
		Consumer<Double> c = System.out::println; 
		// non-static method to call on obj --> obj.method(arg); i.e. non-static method called on given object
		Double d = 11.33; 
		c.accept(d);
		
		//Supplier<Date> dt = () -> new Date( );
		Supplier<Date> dt = Date::new;   
		//// param-less constructor is called after creating object of given class.
		System.out.println("Current Date  :: " +dt.get());
	}

}
