package com.codedictator.consumer;

import java.util.function.Consumer;

public class ConsumerWithStringAndThen {
	public static void main(String[] args) {

		Consumer<String> consumerObj = a -> System.out.println(a.length());

		consumerObj.andThen(consumerObj).accept("CodeDictator");
	}
}
