package com.codedictator.methodreferance;

import java.util.function.BiFunction;

//referring non-static methods. You can refer methods by class object and anonymous object.

class Arithmetic1 {
	public int add(int a, int b) {
		return a + b;
	}
}

interface Sayable1 {
	void say();
}

interface TriFunction<T, U, V, R> {
	R apply(T t, U u, V v);
}

class Sum {
	Integer doSum(String s1, String s2) {
		return Integer.parseInt(s1) + Integer.parseInt(s1);
	}
}

public class MethodReferenceToAnInstanceMethod {
	public void saySomething() {
		System.out.println("Hello, this is non-static method.");
	}

	public void printnMsg() {
		System.out.println("Hello, this is instance method");
	}

	public static void main(String[] args) {
		MethodReferenceToAnInstanceMethod methodReference = new MethodReferenceToAnInstanceMethod(); // Creating object
		// Referring non-static method using reference
		Sayable1 sayable = methodReference::saySomething;
		// Calling interface method
		sayable.say();
		// Referring non-static method using anonymous object
		Sayable1 sayable2 = new MethodReferenceToAnInstanceMethod()::saySomething; // You can use anonymous object also
		// Calling interface method
		sayable2.say();

		Thread t2 = new Thread(new MethodReferenceToAnInstanceMethod()::printnMsg);
		t2.start();

		BiFunction<Integer, Integer, Integer> adder = new Arithmetic1()::add;
		int result = adder.apply(10, 20);
		System.out.println(result);

		System.out.println("\nTriFunction: ");
//		We can wrap the doSum() method within a TriFunction implementation by using an anonymous class:
		TriFunction<Sum, String, String, Integer> anon = new TriFunction<Sum, String, String, Integer>() {
			@Override
			public Integer apply(Sum s, String arg1, String arg2) {
				return s.doSum(arg1, arg1);
			}
		};
		System.out.println(anon.apply(new Sum(), "1", "4"));

//		Or by using a lambda expression:

		TriFunction<Sum, String, String, Integer> lambda = (Sum s, String arg1, String arg2) -> s.doSum(arg1, arg1);
		System.out.println(lambda.apply(new Sum(), "1", "4"));

//		Or just by using a method reference:

		TriFunction<Sum, String, String, Integer> mRef = Sum::doSum;
		System.out.println(mRef.apply(new Sum(), "1", "4"));

		/*
		 * Here:
		 * 
		 * The first type parameter of TriFunction is the object type that contains the
		 * method to execute.
		 * 
		 * The second type parameter of TriFunction is the type of the first parameter.
		 * 
		 * The third type parameter of TriFunction is the type of the second parameter.
		 * 
		 * The last type parameter of TriFunction is the return type of the method to
		 * execute.
		 * 
		 * Notice how this is omitted (inferred) in the lambda expression and the method
		 * reference. It may seem odd to just see the interface, the class, and how they
		 * are used with a method reference; but this becomes more evident when you see
		 * the anonymous class or even the lambda version.
		 * 
		 * From:
		 * 
		 * (Sum s, String arg1, String arg2) -> s.doSum(arg1, arg1)
		 * 
		 * To
		 * 
		 * Sum::doSum
		 * 
		 */
	}
}

/*
 *
 * Instance method reference of an object of a particular type
 * 
 * In this case, we have a lambda expression like the following:
 * 
 * (obj, args) -> obj.instanceMethod(args)
 * 
 * Where an instance of an object is passed, and one of its methods is executed
 * with some optional(s) parameter(s).
 * 
 * This can be turned into the following method reference:
 * 
 * ObjectType::instanceMethod
 * 
 * This time, the conversion is not that straightforward. First, in the method
 * reference, we don't use the instance itself—we use its type.
 * 
 * Second, the other argument of the lambda expression, if any, is not used in
 * the method reference, but it's passed behind the curtains like in the static
 * method case.
 */
