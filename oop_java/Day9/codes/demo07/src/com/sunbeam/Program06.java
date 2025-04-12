package com.sunbeam;

import java.util.Stack;

public class Program06 {
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(11);
		s.push(22);
		s.push(33);
		s.push(44);
		s.push(55);
		
		Integer ele = s.peek(); // 55
		System.out.println("Topmost Ele: " + ele);
		
		while(!s.isEmpty()) {
			Integer num = s.pop();
			System.out.println("Popped: " + num);
		}
	}
}
