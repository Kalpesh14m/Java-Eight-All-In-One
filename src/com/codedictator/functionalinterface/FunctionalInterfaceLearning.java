package com.codedictator.functionalinterface;

@FunctionalInterface
interface Msg {
	public void display(String msg);
}

public class FunctionalInterfaceLearning implements Msg {

	public static void main(String[] args) {
		FunctionalInterfaceLearning f = new FunctionalInterfaceLearning();
		f.display("This is Functional Interface Demo");
	}

	@Override
	public void display(String msg) {
		System.out.println(msg);
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
 * From Java 8, SAM Interfaces will also be referred to as functional
 * interfaces. Java 8 enforces the rule of single responsibility by marking
 * these interfaces with a new annotation i.e.
 * 
 * @FunctionalInterface.
 * 
 * For example, new definition of Calculator interface is like this:
 * 
 * @FunctionalInterface Interface Msg{
 * 
 * Public String display();
 * 
 * }
 * 
 * If we try to add a new method in any functional interface, the compiler would
 * not allow you to do this and will throw a compile-time error.
 * 
 * We know that Lambda expressions are anonymous functions with no name and they
 * are passed (mostly) to other functions as parameters. Well, in Java method
 * parameters always have a type and the type information is looked for to
 * determine which method needs to be called in case of method overloading or
 * even simple method calling. So, basically every lambda expression also must
 * be convertible to some ‘type’ to be accepted as method parameters.
 * 
 * Well, the type in which lambda expressions are converted, are always of
 * functional interface type. Two good examples of functional interface type are
 * Consumer and BiConsumer interfaces.
 * 
 * Java Predefined-Functional Interfaces
 * 
 * Java provides predefined functional interfaces to deal with functional
 * programming by using lambda and method references.
 * 
 * You can also define your own custom functional interface.
 */