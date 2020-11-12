package com.codedictator.BiFunction;

import java.util.function.BiFunction;
import java.util.function.Function;

// This example converts the above method into a generic method:
public class BiFunctionAndThenWithGenerics {

	public static void main(String[] args) {

		// Take two Integers, pow it into a Double, convert Double into a String.
		String result = convert(2, 4, (a1, a2) -> Math.pow(a1, a2), (r) -> "Pow : " + String.valueOf(r));
		System.out.println("result: " + result); // Pow : 16.0

		// Take two Integers, multiply into an Integer, convert Integer into a String.
		String result2 = convert(2, 4, (a1, a2) -> a1 * a1, (r) -> "Multiply : " + String.valueOf(r));
		System.out.println("result2: " + result2); // Multiply : 4

		// Take two Strings, join both, join "cde"
		String result3 = convert("a", "b", (a1, a2) -> a1 + a2, (r) -> r + "cde"); // abcde
		System.out.println("result3: " + result3);

		// Take two Strings, join both, convert it into an Integer
		Integer result4 = convert("100", "200", (a1, a2) -> a1 + a2, (r) -> Integer.valueOf(r));
		System.out.println("result4: " + result4); // 100200

	}

	public static <A1, A2, R1, R2> R2 convert(A1 a1, A2 a2, BiFunction<A1, A2, R1> func, Function<R1, R2> func2) {

		return func.andThen(func2).apply(a1, a2);

	}
}
