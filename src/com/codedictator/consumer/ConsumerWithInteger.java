package com.codedictator.consumer;

import java.util.function.Consumer;

public class ConsumerWithInteger {
	public static void main(String[] args) {

		Consumer<Integer> consumerObj = a -> System.out.println(a * 5);

		consumerObj.accept(10);
	}
}
