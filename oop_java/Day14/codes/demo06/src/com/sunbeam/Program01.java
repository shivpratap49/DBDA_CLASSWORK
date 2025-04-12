package com.sunbeam;

public class Program01 {
	public static void delay(int ms) {
		try {
			Thread.sleep(ms);
		} catch (Exception e) {
		}
	}
	public static void main(String[] args) {
		Object obj = new Object();
		
		class SunbeamThread extends Thread {
			@Override
			public void run() {
				synchronized (obj) 
				{ // obj - lock
					String str = "SUNBEAM ";
					for (int i = 0; i < str.length(); i++) {
						System.out.print(str.charAt(i));
						System.out.flush();
						delay(100);
					}
					obj.notify();
				} // obj - unlock
				// ...
			}
		}
		SunbeamThread st = new SunbeamThread();
		
		class InfotechThread extends Thread {
			@Override
			public void run() {
				synchronized (obj) 
				{ // obj - lock
					try {
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					String str = "INFOTECH";
					for (int i = 0; i < str.length(); i++) {
						System.out.print(str.charAt(i));
						System.out.flush();
						delay(100);
					}
				} // obj - unlock
				// ...
			}
		}
		InfotechThread it = new InfotechThread();

		it.start();
		st.start();
	}
}
