package com.sunbeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Program03 {
	/*
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Collections.addAll(list, 11, 22, 33, 44, 55);
		// fail-fast iterator
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()) {
			int ele = itr.next();
			System.out.println(ele);
			if(ele == 33)
				list.add(4, 66);
		}
	}
	*/
	
	public static void main(String[] args) {
		List<Integer> list = new CopyOnWriteArrayList<>();
		Collections.addAll(list, 11, 22, 33, 44, 55);
		// fail-safe iterator
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()) {
			int ele = itr.next();
			System.out.println(ele);
			if(ele == 33)
				list.add(4, 66);
		}
		
		System.out.println("\n Updated List: ");
		itr = list.iterator();
		while(itr.hasNext()) {
			int ele = itr.next();
			System.out.println(ele);
		}
	}
}
