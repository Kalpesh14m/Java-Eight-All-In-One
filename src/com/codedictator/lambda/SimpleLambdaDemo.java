package com.codedictator.lambda;

public class SimpleLambdaDemo {
	public static void main(String[] args) {

		// Lambda Expression Rules:

		// 1. A lambda expression can have zero, one or more parameters.
		Msg m = () -> "This is Java 8";
		System.out.println(m.display());

		// 2. The type of the parameters can be explicitly declared or it can be
		// inferred from the context.
		Calculate add = (double a, double b) -> a + b;
		System.out.println(add.operation(10, 20));

		// 3. Multiple parameters are enclosed in mandatory parentheses and separated by
		// commas.
		// Empty parentheses are used to represent an empty set of parameters.
		Calculate sub = (a, b) -> {
			return (int) a - b;
		};
		System.out.println(sub.operation(10, 20));

		// 4. The body of the lambda expressions can contain zero, one or more
		// statements.
		Multiplication mul = a -> a * a;
		System.out.println(mul.multiplication(20));

		// 5. If a body of lambda expressions has a single statement, curly brackets are
		// not mandatory and the return type of the anonymous function is the same as
		// that of the body expression.
		// When there is more than one statement in the body than these must be enclosed
		// in curly brackets.
		Multiplication multi = (a) -> {
			a *= a;
			a += 10;
			return a;
		};
		System.out.println(multi.multiplication(20));
	}
}

@FunctionalInterface
interface Calculate {
	public double operation(double a, double b);
}

@FunctionalInterface
interface Msg {
	public String display();
}

@FunctionalInterface
interface Multiplication {
	public int multiplication(int b);
}

/*
 * Lambda Expression In Java programming language, a Lambda expression (or
 * function) is just an anonymous function, i.e. a function with no name and
 * without being bound to an identifier.
 * 
 * They are written exactly in the place where it’s needed, typically as a
 * parameter to some other function.
 * 
 * The basic syntax of a lambda expression is:
 * 
 * either (parameters) -> expression
 * 
 * or
 * 
 * (parameters) -> { statements; }
 * 
 * or () ->
 * 
 * expression A typical lambda expression example will be like this:
 * 
 * (x, y) -> x + y //This function takes two parameters and returns their sum.
 * 
 * Please note that based on type of x and y, method may be used in multiple
 * places. Parameters can match to int, or Integer or simply String also. Based
 * on context, it will either add two integers or concat two strings.
 * 
 * Examples
 * 
 * Zero parameter
 * 
 * () -> System.out.println("No Params");
 * 
 * One Parameter
 * 
 * (param) -> System.out.println("One parameter: " + param);
 * 
 * or without parenthesis;
 * 
 * param -> param (Identity function example)
 * 
 * Multiple parameters
 * 
 * (param1, param2) -> param1 + param2;
 * 
 * Parameter Types
 * 
 * (int i, String name) -> System.out.println("id:" + i + " name:" + name);
 * 
 * Code block
 * 
 * (param1, param2) -> { return param1 + param2; }
 * 
 * 
 */
