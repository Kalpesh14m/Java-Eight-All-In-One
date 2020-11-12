package com.codedictator.consumer;

import java.util.HashMap;
import java.util.function.Consumer;

public class ConsumerWithHashMap {
	public static void main(String[] args) {

		Consumer<HashMap<Integer, String>> consumerListObj = map -> System.out.println(map);

		HashMap<Integer, String> hashMap = new HashMap<>();

		hashMap.put(1, "Kalpesh");
		hashMap.put(3, "Bunny");

		consumerListObj.accept(hashMap);
	}
}
