package com.sunbeam;

public class Program {

	public static void main(String[] args) {
		double[][] arr1 = new double[2][3]; // default values will be 0
		// 2 ROW * 3 COLS

		double[] arr2[] = new double[][] { { 1.1, 2.2, 3.3 }, { 4.1, 4.2, 4.4 } };

		double arr3[][] = { { 1.1, 2.2, 3.3 }, { 4.1, 4.2, 4.4 } };

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(" " + arr3[i][j]);
			}
			System.out.println();
		}

		// Array of arrays
		int[][] rarr = new int[4][]; // default values are 0 

		rarr[0] = new int[1];
		rarr[1] = new int[2];
		rarr[2] = new int[3];
		rarr[3] = new int[4];

		for (int i = 0; i < rarr.length; i++) {
			for (int j = 0; j < rarr[i].length; j++) {
				System.out.print(" " + rarr[i][j]);
			}
			System.out.println();
		}

		int var = 1;
		for (int i = 0; i < rarr.length; i++) {
			for (int j = 0; j < rarr[i].length; j++) {
				rarr[i][j] = var;
				var++;
			}
			System.out.println();
		}
		for (int i = 0; i < rarr.length; i++) {
			for (int j = 0; j < rarr[i].length; j++) {
				System.out.print(" " + rarr[i][j]);
			}
			System.out.println();
		}

	}

}
