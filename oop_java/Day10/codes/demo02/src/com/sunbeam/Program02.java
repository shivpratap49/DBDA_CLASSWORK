package com.sunbeam;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Program02 {
	/*
	public static void main(String[] args) {
		// Deque as Stack
		Deque<Integer> s = new ArrayDeque<>(); //new LinkedList<>();
		s.offerFirst(11);
		s.offerFirst(22);
		s.offerFirst(33);
		s.offerFirst(44);
		while(!s.isEmpty()) {
			Integer ele = s.pollFirst();
			System.out.println("Popped: " + ele);
		}
	}
	*/
	
	public static void main(String[] args) {
		// Deque as Queue
		Deque<Integer> s = new ArrayDeque<>(); //new LinkedList<>();
		s.offerLast(11);
		s.offerLast(22);
		s.offerLast(33);
		s.offerLast(44);
		while(!s.isEmpty()) {
			Integer ele = s.pollFirst();
			System.out.println("Popped: " + ele);
		}
	}
}
