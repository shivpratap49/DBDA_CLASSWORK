package com.sunbeam;

import java.util.Arrays;
import java.util.Comparator;

public class Program03 {
	/*
	public static void main(String[] args) {
		Product[] arr = {
				new Product(3, "Pen", 45.0),
				new Product(1, "Pencil", 5.0),
				new Product(2, "Eraser", 3.0),
				new Product(5, "Paper", 6.0),
				new Product(4, "Notebook", 80.0)
		};
		System.out.println("Before Sort:");
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
		
		class ProductNameComparator implements Comparator<Product> {
			@Override
			public int compare(Product x, Product y) {
				int diff = x.getName().compareTo(y.getName());
				return diff;
			}
		}
		
		ProductNameComparator prodNameComparator = new ProductNameComparator();
		Arrays.sort(arr, prodNameComparator);

		System.out.println(" After Sort:");
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);

	}
	*/
	/*
	public static void main(String[] args) {
		Product[] arr = {
				new Product(3, "Pen", 45.0),
				new Product(1, "Pencil", 5.0),
				new Product(2, "Eraser", 3.0),
				new Product(5, "Paper", 6.0),
				new Product(4, "Notebook", 80.0)
		};
		System.out.println("Before Sort:");
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
		
		class ProductPriceAscComparator implements Comparator<Product> {
			@Override
			public int compare(Product x, Product y) {
				int diff = Double.compare(x.getPrice(), y.getPrice());
				return diff;
			}
		}
		
		Arrays.sort(arr, new ProductPriceAscComparator());

		System.out.println(" After Sort:");
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);

	}
	*/

	public static void main(String[] args) {
		Product[] arr = {
				new Product(3, "Pen", 45.0),
				new Product(1, "Pencil", 5.0),
				new Product(2, "Eraser", 3.0),
				new Product(5, "Paper", 6.0),
				new Product(4, "Notebook", 80.0)
		};
		System.out.println("Before Sort:");
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
		
		class ProductPriceDescComparator implements Comparator<Product> {
			@Override
			public int compare(Product x, Product y) {
				int diff = - Double.compare(x.getPrice(), y.getPrice());
				return diff;
			}
		}
		
		Arrays.sort(arr, new ProductPriceDescComparator());

		System.out.println(" After Sort:");
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);

	}

}







