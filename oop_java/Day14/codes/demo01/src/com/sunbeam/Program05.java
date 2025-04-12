package com.sunbeam;

public class Program05 {
	private static void delay(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// main thread is non-daemon thread (foreground)
	public static void main(String[] args) {
		// thread is by default non-daemon thread (foreground)
		class MyThread extends Thread {
			public void run() {
				for (int i = 1; i <= 7; i++) {
					System.out.println("  My: " + i);
					delay(1000);
				}				
			}
		}
		MyThread th1 = new MyThread();
		th1.setDaemon(false); // default -- non-daemon
		th1.start();

		// daemon (background) threads are for giving services to non-daemon (foreground) threads.
		// when all non-daemon threads in a java process are terminated, the JVM exits.
		// due to this all daemon threads are automatically (forcefully) terminated.
		class YourRunnable implements Runnable {
			public void run() {
				for (int i = 1; i <= 10; i++) {
					System.out.println("Your: " + i);
					delay(1000);
				}				
			}			
		}
		Thread th2 = new Thread(new YourRunnable());
		th2.setDaemon(true); // daemon thread
		th2.start();
		
		for (int i = 1; i <= 5; i++) {
			System.out.println("Main: " + i);
			delay(1000);
		}
	}
}
