package com.sunbeam;

public class Program07 {
	private static void delay(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		class PrintTable extends Thread {
			private int num;
			public PrintTable(int num) {
				this.num = num;
			}
			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					System.out.printf("%d * %d = %d\n", num, i, num * i);
				//	delay(1000);
				}
			}
		}
		
		PrintTable th1 = new PrintTable(2);
		th1.setPriority(1); // min priority = 1
		th1.start();
		
		PrintTable th2 = new PrintTable(4);
		th2.setPriority(10); // max priority = 10
		th2.start();
		
		
		
		try {
			th1.join(); // calling thread i.e. main will wait for completion given thread i.e. th1
			th2.join(); // calling thread i.e. main will wait for completion given thread i.e. th2
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Bye!");
	}
}
