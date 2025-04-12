package com.sunbeam;

import java.util.Iterator;

public class Program09 {
	/*
	// race condition -- when deposit() and withdraw() methods are not declared synchronized
	public static void main(String[] args) throws Exception {
		Account acc = new Account(1, "Saving", 10000);
		
		class DepositThread extends Thread {
			@Override
			public void run() {
				for (int i = 1; i <= 100; i++) {
					acc.deposit(100);
					System.out.println("Balance After Deposit: " + acc.getBalance());
				}
			}
		}		
		DepositThread dt = new DepositThread();
		
		class WithdrawThread extends Thread {
			@Override
			public void run() {
				for (int i = 1; i <= 100; i++) {
					acc.withdraw(100);
					System.out.println("Balance After Withdraw: " + acc.getBalance());
				}
			}
		}		
		WithdrawThread wt = new WithdrawThread();
		
		dt.start();
		wt.start();
		
		dt.join();
		wt.join();
		
		System.out.println("Final Balance: " + acc.getBalance());
	}
	*/

	/*
	// avoid race condition -- when deposit() and withdraw() methods are not declared synchronized
	// using "synchronized" block
	public static void main(String[] args) throws Exception {
		Account acc = new Account(1, "Saving", 10000);
		
		class DepositThread extends Thread {
			@Override
			public void run() {
				for (int i = 1; i <= 100; i++) {
					synchronized (acc) 
					{ // lock the "acc"
						acc.deposit(100);
						System.out.println("Balance After Deposit: " + acc.getBalance());
					} // unlock the "acc"
				}
			}
		}		
		DepositThread dt = new DepositThread();
		
		class WithdrawThread extends Thread {
			@Override
			public void run() {
				for (int i = 1; i <= 100; i++) {
					synchronized(acc)
					{ // lock the "acc"
						acc.withdraw(100);
						System.out.println("Balance After Withdraw: " + acc.getBalance());
					} // unlock the "acc"
				}
			}
		}		
		WithdrawThread wt = new WithdrawThread();
		
		dt.start();
		wt.start();
		
		dt.join();
		wt.join();
		
		System.out.println("Final Balance: " + acc.getBalance());
	}
	*/
	
	// avoid race condition -- declare deposit() and withdraw() methods are as synchronized
	public static void main(String[] args) throws Exception {
		Account acc = new Account(1, "Saving", 10000);
		
		class DepositThread extends Thread {
			@Override
			public void run() {
				for (int i = 1; i <= 100; i++) {
					acc.deposit(100); // lock "this" object i.e. "acc"
					System.out.println("Balance After Deposit: " + acc.getBalance());
				}
			}
		}		
		DepositThread dt = new DepositThread();
		
		class WithdrawThread extends Thread {
			@Override
			public void run() {
				for (int i = 1; i <= 100; i++) {
					acc.withdraw(100); // lock "this" object i.e. "acc"
					System.out.println("Balance After Withdraw: " + acc.getBalance());
				}
			}
		}		
		WithdrawThread wt = new WithdrawThread();
		
		dt.start();
		wt.start();
		
		dt.join();
		wt.join();
		
		System.out.println("Final Balance: " + acc.getBalance());
	}
	
}
