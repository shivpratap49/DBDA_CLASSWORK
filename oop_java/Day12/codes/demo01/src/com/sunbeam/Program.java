package com.sunbeam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Program {
	
	/* 
	public static void main(String[] args) {
		Double[ ] arr = {1.1,2.2,3.3,4.4,5.5,6.6,7.7,8.8,9.9,10.0}; 
		Stream<Double> strm = Arrays.stream(arr); 
		
		strm
		.limit(7)
		.skip(2)
		.forEach(e->System.out.println(e));
	}
	*/ 
	/* 
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>( );
		list.add("A sequence of elements supporting sequential and parallel aggregate operations.");
		list.add("In addition to Stream, which is a stream of object references, there are primitive specializations for IntStream.");
		list.add("To perform a computation, stream operations are composed into a stream pipeline.");	
		
		Stream<String> strm = list.stream(); 
		
		strm
		.map(word -> word.toUpperCase())
		.flatMap(line -> Arrays.stream(line.split(" ")))
		.distinct()
		.forEach(e->System.out.println(e));
 	}
 	*/ 
	/* 
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<Integer>( );
		Collections.addAll(set,1,2,3,4,5,6,7,8,9,10); 
		Stream<Integer> strm = set.stream(); 
		
		//Integer res = strm.reduce(0, (a,i) -> a+i);
		Integer res = strm.reduce(0, (a,i) -> {
			System.out.printf("a=%d + i=%d\n",a,i);
			return a+i; 
		});
		
		System.out.println("res" + res);
 	}
 	*/ 
	/* 
	public static void main(String[] args) {
		int n = 5; 
		Stream<Integer> strm = Stream.iterate(1, i->i+1); 
		
		strm
		.map(i -> n * i)
		.limit(10)
		.forEach(e->System.out.println(e));
	}*/ 
	/* 
	public static void main(String[] args) {
		Random r = new Random( ); 
		Stream<Integer> strm = Stream.generate(() -> r.nextInt(30)); 
		
		strm
		.limit(10)
		.distinct()
		.forEach(e -> System.out.println(e));
	}
	*/ 
	/* 
	public static void main(String[] args) {
		Random r = new Random( ); 
		Stream<Integer> strm = Stream.generate(() -> r.nextInt(30)); 
		
		List<Integer> list = strm
		.limit(10)
		.distinct()
		.collect(Collectors.toList()); 
		
		System.out.println(list);
	}
	*/
	/* 
	public static void main(String[] args) {
		Random r = new Random( ); 
		Stream<Integer> strm = Stream.generate(() -> r.nextInt(30)); 
		
		Set<Integer> set = strm
		.limit(10)
		.distinct()
		.collect(Collectors.toSet()); 
		
		System.out.println(set);
	}
	*/
	/* 
	public static void main(String[] args) {
		Random r = new Random( ); 
		Stream<Integer> strm = Stream.generate(() -> r.nextInt(30)); 
		
		Map<Integer, String> map = strm
		.limit(10)
		.distinct()
		.collect(Collectors.toMap(i->i,i->(i%2==0?"Even":"Odd"))); 
		
		System.out.println(map);
	}
	*/ 
	public static void main(String[] args) {
	  //primitive streams are more efficient -- because no boxing/unboxing done for each arithmetic	
		//Stream<Integer> strm = Stream.iterate(1, i -> i+1);
		//Stream<int> strm = Stream.iterate(1, i -> i+1); // NOT OK -- error 
		
		IntStream strm = IntStream.iterate(1, i -> i+1).limit(10);
		int res = strm.reduce(0, (a,i) -> a+i); 
		//System.out.println("res " +res);
		
		IntStream res1 = IntStream.rangeClosed(1, 10);//startInclusive, endInclusive
		//System.out.println(res1.average());
		IntStream res2 = IntStream.range(1, 11);//startInclusive, endExclusive
		System.out.println(res2.summaryStatistics()); 
	}

}
