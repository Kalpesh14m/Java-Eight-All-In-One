package com.codedictator.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/*
 * The Consumer Interface is a part of the java.util.function package which has been introduced since Java 8, to implement functional programming in Java. 
 * It represents a function which takes in one argument and produces a result. 
 * However these kind of functions don’t return any value.
 * 
 * Hence this functional interface which takes in one generic namely:-
 * 
 * T: denotes the type of the input argument to the operation
 * 
 * The lambda expression assigned to an object of Consumer type is used to define its accept() which eventually applies the given operation on its argument. 
 * Consumers are useful when it not needed to return any value as they are expected to operate via side-effects. 
 * Functions in Consumer Interface
 * 
 * The Consumer interface consists of the following two functions:
 * 			1. accept()
 * 
 * This method accepts one value and performs the operation on the given argument
 * 
 * 	Syntax:
 * 		void accept(T t)
 * 	Parameters: This method takes in one parameter:
 * 		t– the input argument
 * 		Returns: This method does not return any value.
 * Below is the code to illustrate accept() method:
 * */
public class ConsumerAccept {
	public static void main(String[] args) {

		Consumer<List<Integer>> displayList = list -> list.stream().forEach(i -> System.out.println(i));

		Consumer<List<Integer>> modified = list -> {
			for (int i = 0; i < list.size(); i++)
				list.set(i, 2 * list.get(i));
		};

		List<Integer> myIntList = new ArrayList<>();
		myIntList.add(1);
		myIntList.add(2);
		myIntList.add(3);
		myIntList.add(4);
		myIntList.add(5);

		displayList.accept(myIntList);
		modified.accept(myIntList);
	}
}
