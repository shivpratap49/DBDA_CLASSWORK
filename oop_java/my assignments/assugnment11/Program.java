package assugnment11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {

	public static void main(String[] args) {
		
		List<Product> list = new ArrayList<Product>();
		Collections.addAll(list, 
				new Product(1,"HP Laptop",25000f),
				new Product(2,"Dell Laptop",30000f),
				new Product(3,"Lenevo Laptop",28000f),
				new Product(4,"Sony Laptop",28000f),
				new Product(5,"Apple Laptop",90000f )
				);
		
		System.out.println("//		Q1: Print all the product which have price less than  30000.");

		Stream<Product> strm = list.stream();
//		strm.filter(obj-> obj.getPrice()<30000f)
//		.forEach(System.out::println);
		
	        for (Product product : list) {
	            if (product.getPrice() < 30000) {
	                System.out.println(product);
	            }
	        }
		
		
		
		System.out.println("\n//		Q2:  Print all the product name only which have price equel to  90000f.");
//		strm = list.stream();
//		strm.filter(obj -> obj.getPrice()==90000f)
//		.forEach(System.out::println);
		 for (Product product : list) {
	            if (product.getPrice() == 90000) {
	                System.out.println(product.getName());
	            }
	        }
		
		
		System.out.println("\n//           Q3:Find  the sum of price of all products.");
		strm = list.stream();
		
		float sum = strm.map(Product::getPrice)
				.reduce(0f, Float::sum);
		System.out.println(sum);

		
		System.out.println("\n//            Q4: Sum of prices of all products using Collectors:");
		
		Double summ = list.stream()
				.collect(Collectors.summingDouble(Product :: getPrice));
		System.out.println(summ);
	
		
		System.out.println("\n//            Q5: finds min and max product price by using stream.");

		Optional<Float> minp = list.stream()
		.map(Product::getPrice)
		.min(Float::compareTo);
		
		Optional<Float> maxp = list.stream()
				.map(Product::getPrice)
				.max(Float::compareTo);
		
		System.out.println("min = "+minp+",  max = "+maxp);
		
		System.out.print("Min = ");
		minp.ifPresent(System.out::print);
		
		System.out.print("\nMax = ");
		maxp.ifPresent(System.out::print);
		
		

		System.out.println("\n//            Q6: Print the count of product which r having price less than 30000f");
		long count = list.stream()
				.filter(obj->obj.getPrice()<30000)
				.count();
		System.out.println(count);
		
		

		System.out.println("\n//            Q7:  Converting product List into Set by adding   product having price less than 30000f in set");
		 Set<Product> set =  list.stream()
				 .filter(obj ->obj.getPrice() < 30000)
				 .collect(Collectors.toSet());
				 
		 set.forEach(System.out::println);
		 
		 
		 

			System.out.println("\n//            Q8:  Convert List into Map of key value pair where key = id and price =name");
		
			Map<Integer,String> mp = list.stream()
					.collect(Collectors.toMap(Product::getId,Product::getName));
		
				mp.forEach((id,name)->System.out.println("Key  = "+id+" --> Value = "+name));
	}

}
