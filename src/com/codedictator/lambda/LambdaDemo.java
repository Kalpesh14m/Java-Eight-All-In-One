package com.codedictator.lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaDemo {
	public static void main(String[] args) {
		List<String> pointList = new ArrayList<>();
		pointList.add("Kalpesh");
		pointList.add("Krushna");
		pointList.add("Bhushan");
		pointList.add("Akshy");
		pointList.add("Vivek");

		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(40);
		list.add(60);
		list.add(20);
		list.add(3);

		pointList.forEach(p -> System.out.println("Name : " + p));

		list.forEach(l -> System.out.println("id : " + l));

		list.forEach(n -> {
			if (n > 30) {
				System.out.println("N > " + n);
			}
		});
	}

	// As objects : the lambda expression is assigned to variable, and finally it is
	// invoked by invoking the interface method it implements
	MyComparator myComparator = (a1, a2) -> a1 > a2;
	boolean result = myComparator.compare(2, 5);

}

@FunctionalInterface
interface MyComparator {
	public boolean compare(int a1, int a2);
}