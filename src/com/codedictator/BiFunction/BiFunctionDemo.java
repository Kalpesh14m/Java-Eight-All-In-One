package com.codedictator.BiFunction;

public class BiFunctionDemo {
	public static void main(String[] args) {

		// a basic apply() example
		MyBiFunction<Integer, Integer, Integer> f1 = (a, b) -> a + b;
		System.out.println(f1.apply(10, 20)); // 30

	}
}

@FunctionalInterface
interface MyBiFunction<T, U, V> {
	V apply(T t, U u);

}

/*
 * In Java 8, BiFunction is a functional interface; it takes two arguments and
 * returns an object. BiFunction.java
 * 
 * Java BiFunction is common use case when we are working with Java HashMap. In
 * HashMap methods compute, computeIfPresent, merge and replaceAll method takes
 * BiFunction as input argument. 1. Java BiFunction methods and Examples
 * 
 * @FunctionalInterface public interface BiFunction<T, U, R> {
 * 
 * R apply(T t, U u);
 * 
 * }
 * 
 * T – Type of the first argument to the function. U – Type of the second
 * argument to the function. R – Type of the result of the function.
 * 
 * default BiFunction andThen(Function after) – Returns a composed function that
 * first applies this function to its input, and then applies the after function
 * to the result.
 */
