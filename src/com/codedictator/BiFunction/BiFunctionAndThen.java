package com.codedictator.BiFunction;

import java.util.function.BiFunction;
import java.util.function.Function;

//BiFunction<T, U, R> + Function<T, R>

public class BiFunctionAndThen {

	public static void main(String[] args) {

		// This BiFunction takes two Integer and returns a Double,and uses andThen()to
		// chain it with a Function to convert the Double into a String.
		// Math.pow(a1, a2) returns Double
		BiFunction<Integer, Integer, Double> func1 = (a1, a2) -> Math.pow(a1, a2);

		// takes Double, returns String
		Function<Double, String> func2 = (input) -> "Result : " + String.valueOf(input);
		String result = func1.andThen(func2).apply(2, 4);
		System.out.println(result);

		// This example converts the above program into a method that accepts BiFunction
		// and Function as arguments and chains it together.
		String result1 = powToString(2, 4, (a1, a2) -> Math.pow(a1, a2), (r) -> "Result : " + String.valueOf(r));
		System.out.println(result1); // Result : 16.0

	}

	public static <R> R powToString(Integer a1, Integer a2, BiFunction<Integer, Integer, Double> func,
			Function<Double, R> func2) {
		return func.andThen(func2).apply(a1, a2);
	}
}
