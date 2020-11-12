package com.codedictator.predicate;

import java.util.function.Predicate;

public class PredicateInFunction {
	static void pred(int number, Predicate<Integer> predicate) {
		if (predicate.test(number)) {
			System.out.println("Number " + number);
		}
	}

	public static void main(String[] args) {
		pred(10, (i) -> i > 7);
	}
}
