package com.sunbeam;

import java.util.stream.Stream;

public class Program05 {
	/*
	public static void main(String[] args) {
		// Input: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
		// Step1: square each number : 1, 4, 9, 16, 25, 36, 49, 64, 81, 100
		// Step2: get all odd numbers: 1, 9, 25, 49, 81
		// Step3: prefix with "Java" : "Java1", "Java9", "Java25", "Java49", "Java81"
		// Output: print each element
		
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
			.map(n -> n * n)
			.filter(n -> n % 2 != 0)
			.map(n -> "Java"+n)
			.forEach(s -> System.out.println(s));
	}
	*/

	/*
	public static void main(String[] args) {
		// Input: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
		// Step1: square each number : 1, 4, 9, 16, 25, 36, 49, 64, 81, 100
		// Step2: get all odd numbers: 1, 9, 25, 49, 81
		// Step3: prefix with "Java" : "Java1", "Java9", "Java25", "Java49", "Java81"
		// Output: print each element
		
		Stream<Integer> strm1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
			// 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
		Stream<Integer> strm2 = strm1.map(n -> n * n);
			// 1, 4, 9, 16, 25, 36, 49, 64, 81, 100
		Stream<Integer> strm3 = strm2.filter(n -> n % 2 != 0);
			// 1, 9, 25, 49, 81
		Stream<String> strm4 = strm3.map(n -> "Java"+n);
			// "Java1", "Java9", "Java25", "Java49", "Java81"
		strm4.forEach(s -> System.out.println(s));
	}
	*/
	
	/*
	public static void main(String[] args) {
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
			.map(n -> {
				System.out.println("map() -- square -- " + n);
				return n * n;
			})
			.filter(n -> {
				System.out.println("filter() -- odd nums -- " + n);
				return n % 2 != 0;
			})
			.map(n -> {
				System.out.println("map() -- prefix Java -- " + n);;
				return "Java"+n;
			})
			.forEach(s -> System.out.println("forEach() -- " + s));
		System.out.println("Bye!");
	}
	*/
	
	public static void main(String[] args) {
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
			.map(n -> {
				System.out.println("map() -- square -- " + n);
				return n * n;
			})
			.filter(n -> {
				System.out.println("filter() -- odd nums -- " + n);
				return n % 2 != 0;
			})
			.sorted((x,y) -> {
				System.out.println("sorted() -- " + x + " <> " + y);
				return y - x; // desc sort
			})
			.map(n -> {
				System.out.println("map() -- prefix Java -- " + n);;
				return "Java"+n;
			})
			.forEach(s -> System.out.println("forEach() -- " + s));
		System.out.println("Bye!");
	}
}















