package com.codedictator.lambda;

public class LambdaExpAsFI {
	interface IntegerMath {
		int operation(int a, int b);

		default IntegerMath swap() {
			return (a, b) -> operation(b, a);
		}
	}

	private static int apply(int a, int b, IntegerMath op) {
		return op.operation(a, b);
	}

	public static void main(String... args) {
		IntegerMath addition = (a, b) -> a + b;
		IntegerMath subtraction = (a, b) -> a - b;
		System.out.println("40 + 2 = " + apply(40, 2, addition));
		System.out.println("20 - 10 = " + apply(20, 10, subtraction));
		System.out.println("10 - 20 = " + apply(20, 10, subtraction.swap()));
	}
}
/*
 * Interfaces that contain only one abstract method in addition to one or more
 * default or static methods.
 * 
 * Here IntegerMath is a functional interface with default method swap. Lambda
 * expressions that implement IntegerMath are passed to the apply() method to be
 * executed.
 */