package com.codedictator.methodreferance;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

interface Messageable {
	public Message getMessage(String msg);
}

class Message {
	Message(String msg) {
		System.out.println("in Message Class consg: " + msg);
	}
}

public class MethodReferenceToAConstructor {
	public static void main(String[] args) {
		Messageable hello = Message::new;
		hello.getMessage("Hello");

		// If the constructor takes no arguments, a Supplier will do the job:
		// Using an anonymous class
		Supplier<List<String>> s1 = new Supplier() {
			public List<String> get() {
				return new ArrayList<String>();
			}
		};
		System.out.println(s1.get());

		// Using a lambda expression
		Supplier<List<String>> s2 = () -> new ArrayList<String>();
		System.out.println(s2.get());

		// Using a method reference
		Supplier<List<String>> s3 = ArrayList::new;
		System.out.println(s3.get());

//		If the constructor takes an argument, we can use the Function interface. 

		// Using an anonymous class
		Function<String, Integer> f1 = new Function<String, Integer>() {
			public Integer apply(String s) {
				return new Integer(s);
			}
		};
		System.out.println(f1.apply("100"));

		// Using a lambda expression
		Function<String, Integer> f2 = s -> new Integer(s);
		System.out.println(f2.apply("200"));

		// Using a method reference
		Function<String, Integer> f3 = Integer::new;
		System.out.println(f3.apply("300"));

//		If the constructor takes two arguments, we use the BiFunction interface:

		// Using a anonymous class
		BiFunction<String, String, Locale> f4 = new BiFunction<String, String, Locale>() {
			public Locale apply(String lang, String country) {
				return new Locale(lang, country);
			}
		};
		System.out.println(f4.apply("Hindi", "India"));

		// Using a lambda expression
		BiFunction<String, String, Locale> f5 = (lang, country) -> new Locale(lang, country);
		System.out.println(f5.apply("Hindi", "India"));

		// Using a method reference
		BiFunction<String, String, Locale> f6 = Locale::new;
		System.out.println(f6.apply("Hindi", "India"));

		// If you have a constructor with three or more arguments, you would have to
		// create your own functional interface.
	}
}

/*
 * (args) -> new ClassName(args)
 * 
 * That can be turned into the following method reference:
 * 
 * ClassName::new
 * 
 * The only thing this lambda expression does is to create a new object and we
 * just reference a constructor of the class with the keyword new. Like in the
 * other cases, arguments (if any) are not passed in the method reference.
 * 
 * Most of the time, we can use this syntax with two (or three) interfaces of
 * the java.util.function package.
 * 
 * If the constructor takes no arguments, a Supplier will do the job:
 * 
 * 
 * If you have a constructor with three or more arguments, you would have to
 * create your own functional interface.
 * 
 * You can see that referencing a constructor is very similar to referencing a
 * static method. The difference is that the constructor "method name" is new.
 * 
 */
