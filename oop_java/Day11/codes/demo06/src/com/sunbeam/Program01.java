package com.sunbeam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Program01 {
	/*
	public static void main(String[] args) {
		Double arr[] = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9 };
		Stream<Double> strm = Arrays.stream(arr);
		strm
			.skip(2)
			.limit(4)
			.forEach(e -> System.out.println(e)); // 3.3, 4.4, 5.5, 6.6
	}
	*/
	
	/*
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("A sequence of elements supporting sequential and parallel aggregate operations.");
		list.add("In addition to Stream, which is a stream of object references, there are primitive specializations for IntStream.");
		list.add("To perform a computation, stream operations are composed into a stream pipeline.");
		
		Stream<String> strm = list.stream();
		strm
			.map(line -> line.toLowerCase())
			.flatMap(line -> Arrays.stream(line.split("[ ,\\.]"))) // needs a lambda expr: input is one element, and output is stream of elements.
			.distinct()
			.forEach(word -> System.out.println(word));
	}
	*/
	
	/*
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<>();
		Collections.addAll(set, 1, 2, 3, 4, 5, 6);
		
		Stream<Integer> strm = set.stream();
		//strm.forEach(e -> System.out.println(e));
		
		//Integer res = strm.reduce(0, (a,i)->a + i);
		Integer res = strm.reduce(0, (a,i)->{
			System.out.printf("a=%d + i=%d\n", a, i);
			return a + i;
		});
		System.out.println("Sum: " + res);
	}
	*/

	/*
	public static void main(String[] args) {
		int num = 5;
		Stream<Integer> strm = Stream.iterate(1, i->i+1);
		strm
			.limit(10)
			.map(i -> i * num)
			.forEach(e -> System.out.println(e));
	}
	*/
	
	/*
	public static void main(String[] args) {
		Random r = new Random();
		//Math.random(); // generates random number from 0.0 to 1.0
		//r.nextDouble(); // generates random number from 0.0 to 1.0
		//r.nextInt(100); // generates random number from 0 to 100
		Stream<Integer> strm = Stream.generate(() -> r.nextInt(100));
		strm
			.distinct()
			.limit(20)
			.forEach(e -> System.out.println(e));
	}
	*/
	/*
	public static void main(String[] args) {
		Random r = new Random();
		Stream<Integer> strm = Stream.generate(() -> r.nextInt(100));
		List<Integer> list = strm
			.distinct()
			.limit(10)
			.collect(Collectors.toList());
		//Collectors.toList() returns a Collector object that can collect stream elements into a List.
		System.out.println(list.toString());
	}
	*/
	/*
	public static void main(String[] args) {
		Random r = new Random();
		Stream<Integer> strm = Stream.generate(() -> r.nextInt(100));
		Set<Integer> set = strm
			.distinct()
			.limit(10)
			.collect(Collectors.toSet());
		//Collectors.toSet() returns a Collector object that can collect stream elements into a Set.
		System.out.println(set.toString());
	}
	*/
	
	