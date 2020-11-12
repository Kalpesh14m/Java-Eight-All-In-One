package com.codedictator.reduce;

import java.util.Arrays;
import java.util.List;

public class ReduceListAndArrayToString {
	public static void main(String[] args) {
		// Reduce Array to String.
		String[] array = { "Bhushan", "Kalpesh", "Bunny" };
		Arrays.stream(array).reduce((x, y) -> x + "," + y).ifPresent(s -> System.out.println("Array to String: " + s));

		// Reduce List to String.
		List<String> list = Arrays.asList("Bhushan", "Kalpesh", "Bunny");
		list.stream().reduce((x, y) -> x + "," + y).ifPresent(s -> System.out.println("List to String: " + s));
	}
}
