package com.sunbeam;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Program08 {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		//Map<Integer, String> map = new LinkedHashMap<>();
		//Map<Integer, String> map = new TreeMap<>();
		//Map<Integer, String> map = new Hashtable<>();
		map.put(415110, "Karad - Satara"); // retruns -- null
		map.put(411052, "Hinjawadi - Pune"); // retruns -- null
		map.put(411046, "Katraj - Pune"); // retruns -- null
		map.put(400027, "Byculla - Mumbai"); // retruns -- null
		map.put(411002, "Bajirao Rd - Pune"); // retruns -- null
		map.put(411037, "Marketyard - Pune"); // retruns -- null
		map.put(411007, "Aundh - Pune"); // retruns -- null
		map.put(411052, "HINJEWADI - Pune"); // when key is duplicate, value is overwritten
			// returns -- old value for the key -- "Hinjawadi - Pune"
		
		/*
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Pin: ");
		int pin = sc.nextInt();
		
		String area = map.get(pin); // returns value of the key OR returns null if key not found
		System.out.println("Area: " + area);
		
		area = map.getOrDefault(pin, "Unknown");
		System.out.println("Area: " + area); //returns value of the key OR returns defaultValue (arg2) if key not found
		*/
		
		Set<Integer> keys = map.keySet();
		System.out.println("Keys (Pins): " + keys.toString());
		
		Collection<String> values = map.values();
		System.out.println("Values (Areas): " + values.toString());
		
		Set<Entry<Integer,String>> entries = map.entrySet();
		for(Entry<Integer,String> en : entries)
			System.out.println(en.getKey() + " --> " + en.getValue());
	}
}
