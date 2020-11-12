package com.codedictator.lambda;

@FunctionalInterface
interface Calculation {
	public int operation(int a, int b);
}

//With help of anonymous function
public class AnonymousFunction {
	public static void main(String[] args) {
		Calculation add = new Calculation() {
			@Override
			public int operation(int a, int b) {
				return a + b;
			}
		};
		System.out.println(add.operation(10, 20));
	}
}

/*
 * Anonymous function is a function definition that is not bound to an
 * identifier. These are a form of nested function, in allowing access to
 * variables in the scope of the containing function (non-local functions). This
 * means anonymous functions need to be implemented using closures. Simply,
 * lambda is an anonymous function which can be passed around in a concise way.
 * 
 * A lambda expression represents an anonymous function. It comprises of a set
 * of parameters, a lambda operator (->) and a function body.
 * 
 * 
 * Return Type
 * 
 * When there is a single statement, the return type of the anonymous function
 * is the same as that of the body expression.
 * 
 * When there is more than one statement enclosed in curly brackets then the
 * return type of the anonymous function is the same as the type of the value
 * returned within the code block, or void if nothing is returned.
 * 
 */