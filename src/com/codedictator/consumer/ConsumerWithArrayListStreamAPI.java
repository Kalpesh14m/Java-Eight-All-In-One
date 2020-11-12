package com.codedictator.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerWithArrayListStreamAPI {
	public static void main(String[] args) {
		// Add 10 to every integer of the list
		Consumer<List<Integer>> updatedList = list -> {
			for (int i = 0; i < list.size(); i++)
				list.set(i, 10 + list.get(i));
		};

		// Display a list of integers
		Consumer<List<Integer>> printList = list -> list.stream().forEach(a -> System.out.print(a + "\n"));

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		updatedList.andThen(printList).accept(list);
	}
}
