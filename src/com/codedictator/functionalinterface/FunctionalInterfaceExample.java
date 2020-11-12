package com.codedictator.functionalinterface;

//interface sayable {
//	void say(String msg); // abstract method
//}
//
//@FunctionalInterface
//interface Doable extends sayable {
//	// Invalid '@FunctionalInterface' annotation; Doable is not a functional
//	// interface
//	void doIt();
//}

/*
 * A functional interface can extends another interface only when it does not
 * have any abstract method.
 * 
 * compile-time error
 */

interface Doable {
	default void doIt() {
		System.out.println("Do it now");
	}
}

@FunctionalInterface
interface Sayable2 extends Doable {
	void tell(String msg); // abstract method
}

public class FunctionalInterfaceExample implements Sayable2 {

	public void tell(String msg) {
		System.out.println(msg);
	}

	public static void main(String[] args) {
		FunctionalInterfaceExample fie1 = new FunctionalInterfaceExample();
		fie1.tell("Hello Tell");
		fie1.doIt();
	}
}
/*
 * An Interface that contains exactly one abstract method is known as functional
 * interface. It can have any number of default, static methods but can contain
 * only one abstract method. It can also declare methods of object class.
 * 
 * Functional Interface is also known as Single Abstract Method Interfaces or
 * SAM Interfaces. It is a new feature in Java, which helps to achieve
 * functional programming approach.
 * 
 */