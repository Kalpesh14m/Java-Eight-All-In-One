package com.codedictator.methodreferance;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceDemo {
	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<>();
		intList.add(10);
		intList.add(20);
		intList.add(30);
		intList.add(40);
		intList.add(50);

		intList.forEach(System.out::println);
	}
}

/*
 * A method reference is the shorthand syntax for a lambda expression that
 * executes just ONE method.
 * 
 * Here's the general syntax of a method reference:
 * 
 * Object :: methodName
 * 
 * We know that we can use lambda expressions instead of using an anonymous
 * class. But sometimes, the lambda expression is really just a call to some
 * method, for example:
 * 
 * Consumer<String> c = s -> System.out.println(s);
 * 
 * To make the code clearer, you can turn that lambda expression into a method
 * reference:
 * 
 * Consumer<String> c = System.out::println;
 * 
 * In a method reference, you place the object (or class) that contains the
 * method before the :: operator and the name of the method after it without
 * arguments.
 * 
 * How we can use Reference Method:
 * 
 * First of all, a method reference can't be used for any method. They can only
 * be used to replace a single-method lambda expression.
 * 
 * So to use a method reference, you first need a lambda expression with one
 * method. And to use a lambda expression, you first need a functional
 * interface, an interface with just one abstract method.
 *
 *
 * In other words:
 * 
 * Instead of using
 * 
 * AN ANONYMOUS CLASS
 * 
 * you can use
 * 
 * A LAMBDA EXPRESSION
 * 
 * And if this just calls one method, you can use
 * 
 * A METHOD REFERENCE
 * 
 * 
 * There are four types of method references:
 * 
 * A method reference to a static method.
 * 
 * A method reference to an instance method of an object of a particular type.
 * 
 * A method reference to an instance method of an existing object.
 * 
 * A method reference to a constructor.
 * 
 */
