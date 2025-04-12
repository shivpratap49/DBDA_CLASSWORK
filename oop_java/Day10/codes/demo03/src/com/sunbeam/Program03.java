package com.sunbeam;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Program03 {
	/*
	public static void main(String[] args) {
		// Elements are retrieved as per priority -- decided by Comparable (Natural Ordering)
		Queue<String> q = new PriorityQueue<>();
		q.offer("I");
		q.offer("N");
		q.offer("F");
		q.offer("O");
		q.offer("T");
		q.offer("E");
		q.offer("C");
		q.offer("H");
		while(!q.isEmpty()) {
			String ele = q.poll();
			System.out.print(ele + ", ");
		}
	}
	*/
	public static void main(String[] args) {
		class StringDescComparator implements Comparator<String> {
			@Override
			public int compare(String x, String y) {
				return - x.compareTo(y);
			}
		}
		// Elements are retrieved as per priority -- decided by given Comparator.
		Queue<String> q = new PriorityQueue<>(new StringDescComparator());
		q.offer("T");
		q.offer("E");
		q.offer("C");
		q.offer("H");
		while(!q.isEmpty()) {
			String ele = q.poll();
			System.out.print(ele + ", ");
		}
	}
}
