package com.codedictator.parallelarray;

import java.util.Arrays;

public class ParallelArraySorting {
	public static void main(String[] args) {
		// Creating an integer array
		int[] arr = { 5, 8, 1, 0, 6, 9, 50, -3 };

		// Iterating array elements
		System.out.println("\nArray elements before sorting");
		for (int i : arr) {
			System.out.print(i + " ");
		}
// Sorting array elements parallel
		// Arrays.parallelSort(arr);

// Sorting array elements parallel and passing start, end index
		Arrays.parallelSort(arr, 0, 4);
		System.out.println("\nArray elements after sorting");
		// Iterating array elements
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}
/*
 * Java provides a new additional feature in Array class which is used to sort
 * array elements parallel.New methods has added to java.util.Arrays package
 * that use the JSR 166 Fork/Join parallelism common pool to provide sorting of
 * arrays in parallel.The methods are called parallelSort() and are overloaded
 * for all the primitive data types and Comparable objects.
 * 
 * Advantage : parallelSort() method uses concept of MultiThreading which makes
 * the sorting faster as compared to normal sorting method.
 * 
 * Algorithm of parallelSort()
 * 
 * 1. The array is divided into sub-arrays and that sub-arrays is again divided
 * into their sub-arrays, until the minimum level of detail in a set of array.
 * 
 * 2. Arrays are sorted individually by multiple thread.
 * 
 * 3. The parallel sort uses Fork/Join Concept for sorting.
 * 
 * 4. Sorted sub-arrays are then merged.
 */
