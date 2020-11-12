package com.codedictator.consumer;

public class CustomConsumerWithInteger {
	public static void main(String[] args) {

		MyConsumer<Integer> consumerObj = a -> System.out.println(a * 5);

		consumerObj.accept(10);
	}
}

@FunctionalInterface
interface MyConsumer<T> {
	public void accept(T t);
}
