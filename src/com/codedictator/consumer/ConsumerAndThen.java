package com.codedictator.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/*
 * It returns a composed Comsumer wherein the parameterized Consumer will be executed after the first one. 
 * If evaluation of either function throws an error, it is relayed to the caller of the composed operation.
 * 
 * Note: The function being passed as the argument should be of type Consumer.
 * 
 * Syntax:
 * 		default Consumer <T> 
 *        	andThen(Consumer<? super T> after)
 *       	Parameters: This method accepts a parameter after which is the Consumer to be applied after the current one.
 *
 * Return Value: This method returns a composed Consumer that first applies the current Consumer first and then the after operation.
 * 
 * Exception: This method throws NullPointerException if the after operation is null.
 * 
 * Below is the code to illustrate andThen() method:
*/
public class ConsumerAndThen {
	public static void main(String[] args) {
		// Consumer to multiply 2 to every integer of a list
		Consumer<List<Integer>> modify = list -> {
			for (int i = 0; i < list.size(); i++)
				list.set(i, 2 * list.get(i));
		};

		// Consumer to display a list of integers
		Consumer<List<Integer>> dispList = list -> list.stream().forEach(a -> System.out.print(a + " "));

		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(1);
		list.add(3);

		// using addThen()
		modify.andThen(dispList).accept(list);

		// demonstrate when NullPointerException is returned.
		try {
			// using addThen()
			modify.andThen(null).accept(list);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}

		// demonstrate how an Exception in the after function is returned and handled.
		// using addThen()
		try {
			dispList.andThen(modify).accept(list);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}
