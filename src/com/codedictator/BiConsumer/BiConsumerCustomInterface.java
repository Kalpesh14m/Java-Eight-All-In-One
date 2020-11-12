package com.codedictator.BiConsumer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BiConsumerCustomInterface {

	static void showDetails(String name, Integer age) {
		System.out.println(name + " " + age);
	}

	static void showDetails(Map<Integer, String> map, String mapName) {
		System.out.println("----------" + mapName + " records-----------");
		map.forEach((key, val) -> System.out.println(key + " " + val));
	}

	public static void main(String[] args) {
		// Referring method
		MyBiConsumer<String, Integer> biCon = BiConsumerCustomInterface::showDetails;
		biCon.accept("Rama", 20);
		biCon.accept("Shyam", 25);

		// Using lambda expression
		MyBiConsumer<String, Integer> biCon2 = (name, age) -> System.out.println(name + " " + age);
		biCon2.accept("Peter", 28);

		Map<Integer, String> map = new HashMap<>();
		map.put(100, "Mohan");
		map.put(110, "Sujeet");
		map.put(115, "Tom");
		map.put(120, "Danish");

		// Referring method
		MyBiConsumer<Map<Integer, String>, String> biCon1 = BiConsumerCustomInterface::showDetails;
		biCon1.accept(map, "Student");

		// Custom andThen method
		MyBiConsumer<String, String> first = (t, u) -> System.out.println(t.toUpperCase() + u.toUpperCase());
		MyBiConsumer<String, String> second = (t, u) -> System.out.println(t.toLowerCase() + u.toLowerCase());
		MyBiConsumer<String, String> third = (t, u) -> System.out.println(t.length() + u.length());
		first.andThen(second).andThen(third).accept("Again", " and again");

	}
}

@FunctionalInterface
interface MyBiConsumer<T, U> {
	public void accept(T t, U u);

	default MyBiConsumer<T, U> andThen(MyBiConsumer<? super T, ? super U> after) {
		Objects.requireNonNull(after);
		return (l, r) -> {
			accept(l, r);
			after.accept(l, r);
		};
	}
}

/*
 * BiConsumer Interface accepts two input arguments and does not return any
 * result.
 * 
 * This is the two-arity specialization of Consumer interface. It provides a
 * functional method accept(Object, Object) to perform custom operations.
 * 
 * Java BiConsumer Interface Methods
 * 
 * void accept(T t, U u) : It performs this operation on the given arguments.
 * 
 * default BiConsumer<T,U> andThen(BiConsumer<? super T,? super U> after) : It
 * returns a composed BiConsumer that performs, in sequence, this operation
 * followed by the after operation. If performing either operation throws an
 * exception, it is relayed to the caller of the composed operation. If
 * performing this operation throws an exception, the after operation will not
 * be performed.
 * 
 * 
 */