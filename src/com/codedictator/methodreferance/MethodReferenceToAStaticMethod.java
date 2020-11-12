package com.codedictator.methodreferance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

interface Sayable {
	void say();
}

class Arithmetic {
	public static int add(int a, int b) {
		return a + b;
	}

	public static float add(int a, float b) {
		return a + b;
	}

	public static float mul(float a, float b) {
		return a * b;
	}

	public static boolean isMoreThanFifty(int n1, int n2) {
		return (n1 + n2) > 50;
	}

	public static List<Integer> findNumbers(List<Integer> l, BiPredicate<Integer, Integer> p) {
		List<Integer> newList = new ArrayList<>();
		for (Integer i : l) {
			if (p.test(i, i + 10)) {
				newList.add(i);
			}
		}
		return newList;
	}

}

public class MethodReferenceToAStaticMethod {
	public static void saySomething() {
		System.out.println("Hello, this is static method.");
	}

	public static void ThreadStatus() {
		System.out.println("Thread is running...");
	}

	public static void main(String[] args) {
		// Referring static method
		Sayable sayable = MethodReferenceToAStaticMethod::saySomething;
		// Calling interface method
		sayable.say();

		Thread t = new Thread(MethodReferenceToAStaticMethod::ThreadStatus);
		t.start();

		BiFunction<Integer, Integer, Integer> adder1 = Arithmetic::add;
		int result1 = adder1.apply(10, 20);
		System.out.println("Add(int, int): " + result1);

		BiFunction<Integer, Float, Float> adder2 = Arithmetic::add;
		float result2 = adder2.apply(10, 20.0f);
		System.out.println("Add(int, float): " + result2);

		BiFunction<Float, Float, Float> adder3 = Arithmetic::mul;
		float result3 = adder3.apply(10.0f, 20.0f);
		System.out.println("Mul(float, float): " + result3);

		System.out.println("");
		List<Integer> list = Arrays.asList(12, 5, 45, 18, 33, 24, 40);

		// Using an anonymous class
		Arithmetic.findNumbers(list, new BiPredicate<Integer, Integer>() {
			public boolean test(Integer i1, Integer i2) {
				return Arithmetic.isMoreThanFifty(i1, i2);
			}
		});

		// Using a lambda expression
		Arithmetic.findNumbers(list, (i1, i2) -> Arithmetic.isMoreThanFifty(i1, i2));

		// Using a method reference
		Arithmetic.findNumbers(list, Arithmetic::isMoreThanFifty);
	}
}

/*
 * Static method reference
 * 
 * In this case, we have a lambda expression like the one below:
 * 
 * (args) -> Class.staticMethod(args)
 * 
 * This can be turned into the following method reference:
 * 
 * Class::staticMethod
 * 
 * Notice that between a static method and a static method reference, instead of
 * the . operator, we use the :: operator, and that we don't pass arguments to
 * the method reference.
 * 
 * In general, we don't have to pass arguments to method references. However,
 * arguments are treated depending on the type of method reference.
 * 
 * In this case, any arguments (if any) taken by the method are passed
 * automatically behind the curtains.
 * 
 * Where ever we can pass a lambda expression that just calls a static method,
 * we can use a method reference. For example, assuming this class:
 * 
 * 
 */
