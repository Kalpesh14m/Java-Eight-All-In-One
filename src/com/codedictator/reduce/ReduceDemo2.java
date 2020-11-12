package com.codedictator.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ReduceDemo2 {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(5, 2, 13, 50, 78, 23, 95);

		for (Integer item : list) {
			System.out.println("List item: " + item);
		}

		long multiplication = list.stream().reduce(1, (a, b) -> a * b);
		System.out.println("Reduce: " + multiplication);

		MyReduce myAddition = (a, b) -> a + b;
		int addition = 0;
		System.out.println("Addition: " + addition);
		myAddition.apply(10, 20);

		// find factorial of a number with rangeClosed
		long result = IntStream.rangeClosed(1, 5).reduce(1, (a, b) -> a * a);
		System.out.println("Factorial: " + result);

		// To get the product of all elements in given range excluding the rightmost
		// element
		int product = IntStream.range(2, 8).reduce((num1, num2) -> num1 * num2).orElse(-1);
		System.out.println("The product is : " + product);

	}
}

@FunctionalInterface
interface MyReduce {
	public int apply(int one, int two);
}