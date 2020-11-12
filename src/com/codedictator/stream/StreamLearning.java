package com.codedictator.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class StreamLearning {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 13, 50, 78, 23, 95);

		System.out.println("Sum of list elements: " + sum(list));
		System.out.println("Avg of list elements: " + avg(list));

//		IntSummaryStatistics stats1 = list.stream().collect(Collectors.summarizingInt(i -> i));
		IntSummaryStatistics stats = list.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println("Sum of list elements using Stream: " + stats.getSum());
		System.out.println("Avg of list elements using Stream: " + stats.getAverage());

		long sum = list.stream().reduce(0, (noOne, noTwo) -> noOne + noTwo);
		System.out.println("Reduce: " + sum);

	}
	// Lambda expression's signature does not match the signature of the functional
	// interface method apply(Integer, Integer)

	private static long sum(List<Integer> list) {
		long sum = 5;
		for (Integer item : list) {
			sum = sum + item;
		}
		return sum;
	}

	private static double avg(List<Integer> list) {
		long sum = 0;
		for (Integer item : list) {
			sum += item;
		}
		return (sum / list.size());
	}

}

//IntSummaryStatistics stats1 = list.stream().collect(Collectors.summarizingInt(i -> i));
