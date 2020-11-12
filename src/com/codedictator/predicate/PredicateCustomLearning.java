package com.codedictator.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateCustomLearning {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		list.forEach(i -> System.out.println(i));

		// My Customize Predicate with FunctionalInterface
		System.out.println("My own Predicate Print all list elements: ");
		MyPredicate p = (i) -> {
			if (i % 2 == 0)
				System.out.println(i);
		};
		for (Integer i : list) {
			p.test(i);
		}

		// Predicate passing as an argument in method
		System.out.println("Print all list elements: Condition 1: ");
		displayElements(list, n -> n % 2 == 0);

		System.out.println("Print all list elements: Condition 2: ");
		displayElements(list, n -> n > 3);

		System.out.println("Print all list elements: Condition 3: ");
		displayElements(list, n -> n % 3 == 0);

		// Predicate with stream()
		System.out.println("Print all list elements with stream(): ");
		list.stream().filter(n -> n % 2 == 0).forEach(i -> {
			if (i < list.size()) {
				i = i + 2;
				list.set(i - 1, 10);
				System.out.println(i);
			}
		});

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) % 2 == 0) {
				System.out.println(list.get(i));
			}
		}

	}

	private static void displayElements(List<Integer> list, Predicate<Integer> predicate) {
		for (Integer i : list) {
			if (predicate.test(i))
				System.out.println(i);
		}
	}

}

@FunctionalInterface
interface MyPredicate {
	public void test(int i);
}

/*
 * 
 * Functional Interface: An Interface that contains exactly one abstract method
 * is known as functional interface. It can have any number of default, static
 * methods but can contain only one abstract method. It can also declare methods
 * of object class.
 * 
 * Functional Interface is also known as Single Abstract Method Interfaces or
 * SAM Interfaces. It is a new feature in Java, which helps to achieve
 * functional programming approach.
 * 
 * There are some predefined functional interface in Java like
 * 
 * Predicate, consumer, supplier etc.
 * 
 * The return type of a Lambda function (introduced in JDK 1.8) is a also
 * functional interface.</p>
 * 
 * isEqual(Object targetRef): return a predicate that tests if two arguments are
 * equal according to Objects.equals(Object, Object).
 * 
 * static Predicate isEqual(Object targetRef)
 * 
 * @return a predicate that tests if two arguments are equal according to
 * Objects.equals(Object, Object). T : the type of arguments to the predicate
 * 
 * @param targetRef : the object reference with which to compare for equality,
 * which may be null
 * 
 * @return a predicate that tests if two arguments are equal according to
 * Objects.equals(Object, Object)
 * 
 * and(Predicate other) : Returns a composed predicate that represents a
 * short-circuiting logical AND of this predicate and another.
 * 
 * default Predicate and(Predicate other) Returns a composed predicate that
 * represents a short-circuiting logical AND of this predicate and another.
 * Parameters: other: a predicate that will be logically-ANDed with this
 * predicate Returns : a composed predicate that represents the short-circuiting
 * logical AND of this predicate and the other predicate Throws:
 * NullPointerException - if other is null
 * 
 * negate() : Returns a predicate that represents the logical negation of this
 * predicate.
 * 
 * default Predicate negate() Returns:a predicate that represents the logical
 * negation of this predicate
 * 
 * or(Predicate other) : Returns a composed predicate that represents a
 * short-circuiting logical OR of this predicate and another.
 * 
 * default Predicate or(Predicate other) Parameters: other : a predicate that
 * will be logically-ORed with this predicate Returns: a composed predicate that
 * represents the short-circuiting logical OR of this predicate and the other
 * predicate Throws : NullPointerException - if other is null
 * 
 * test(T t) : Evaluates this predicate on the given argument.boolean test(T t)
 * 
 * test(T t) Parameters: t - the input argument Returns: true if the input
 * argument matches the predicate, otherwise false
 * 
 * 
 */
