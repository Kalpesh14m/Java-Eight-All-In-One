package com.codedictator.reduce;

import java.util.Arrays;
import java.util.List;

/*
 * Here we will pass three arguments identity, accumulator and combiner in reduce() method. 
 * The identity value must be an identity for the combiner function. 
 * This method with three arguments is used in parallel processing. 
 * Combiner works with parallel stream only, otherwise there is nothing to combine.
 * 
 * reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
*/
public class ReduceWithIdentityAndAccumulatorAndCombiner {
	public static void main(String[] args) {
		List<Integer> list2 = Arrays.asList(5, 6, 7);
		int res = list2.parallelStream().reduce(1, (s1, s2) -> s1 * s2, (p, q) -> p * q);
		System.out.println(res);
	}
}
