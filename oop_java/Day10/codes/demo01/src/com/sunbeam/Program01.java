package com.sunbeam;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Program01 {
	/*
	public static void main(String[] args) {
		//Queue<String> q = new LinkedList<>();
		Queue<String> q = new ArrayDeque<>();
		q.offer("One");
		q.offer("Two");
		q.offer("Three");
		q.offer("Four");
		System.out.println("First Element: " + q.peek());
		while(!q.isEmpty()) {
			String ele = q.poll();
			System.out.println("Popped: "  +ele);
		}
		System.out.println("Popped from Empty Queue: " + q.poll()); // null
	}
	*/
	
	public static void main(String[] args) {
		//Queue<String> q = new LinkedList<>();
		Queue<String> q = new ArrayDeque<>();
		q.add("One");
		q.add("Two");
		q.add("Three");
		q.add("Four");
		System.out.println("First Element: " + q.element());
		while(!q.isEmpty()) {
			String ele = q.remove();
			System.out.println("Popped: "  +ele);
		}
		System.out.println("Popped from Empty Queue: " + q.remove()); // exception
	}
}
