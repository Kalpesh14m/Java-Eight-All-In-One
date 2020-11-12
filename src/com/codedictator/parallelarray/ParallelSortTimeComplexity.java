package com.codedictator.parallelarray;

import java.util.Arrays;
import java.util.Random;

// Time Complexity is O(nlogn)

public class ParallelSortTimeComplexity {
	public static void main(String[] args) {
		// Creating an array
		int[] numbers = new int[100];
		long startTime1 = 0, startTime2 = 0, endTime1 = 0, endTime2 = 0;

		// Iterating Loop till i = 1000
		// with interval of 10
		for (int i = 0; i < 1000; i += 10) {

			// Random Int Array Generation
			Random rand = new Random();
			for (int j = 0; j < 100; j++) {
				numbers[j] = rand.nextInt();
			}

			// Start Time of Arrays.sort()
			startTime1 = System.nanoTime();
			// Performing Serial Sort
			Arrays.sort(numbers);
			// End Time of Arrays.sort()
			endTime1 = System.nanoTime();

			// Start Time of Arrays.parallelSort()
			startTime2 = System.nanoTime();
			// Performing Parallel Sort
			Arrays.parallelSort(numbers);
			// End Time of Arrays.parallelSort()
			endTime2 = System.nanoTime();

		}
		// Printing result of Serial Sort
		System.out.println("Start and End Time in Serial (in ns): " + startTime1 + ":" + endTime1);
		System.out.println("Time taken by Serial Sort(in ns): " + (endTime1 - startTime1));
		System.out.println();
		// Printing result of Parallel Sort
		System.out.println("Start and End Time in parallel (in ns): " + startTime2 + ":" + endTime2);
		System.out.println("Time taken by Parallel Sort(in ns): " + (endTime2 - startTime2));
		System.out.println();

	}
}
