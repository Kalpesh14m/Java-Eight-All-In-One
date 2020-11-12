package com.codedictator.reduce;

import java.util.Arrays;

/*
 * Many times, we need to perform operations where a stream reduces to single resultant value, for example, maximum, minimum, sum, product, etc. Reducing is the repeated process of combining all elements.
 * 
 * reduce operation applies a binary operator to each element in the stream where the first argument to the operator is the return value of the previous application and second argument is the current stream element.
 * 
 * 	Syntax :
 * 		T reduce(T identity, BinaryOperator<T> accumulator);
 * 
 * Where, identity is initial value of type T and accumulator is a function for combining two values.
 * 
 * sum(), min(), max(), count() etc. are some examples of reduce operations. reduce() explicitly asks you to specify how to reduce the data that made it through the stream. 
*/
public class ReduceDemo1 {
	public static void main(String[] args) {

		int[] array = { 23, 43, 56, 97, 32 };
		Arrays.stream(array).reduce((x, y) -> x + y).ifPresent(s -> System.out.println(s));
		Arrays.stream(array).reduce(Integer::sum).ifPresent(s -> System.out.println(s));
		Arrays.stream(array).reduce(StatisticsUtility::addIntData).ifPresent(s -> System.out.println(s));

	}
}

class StatisticsUtility {
	public static int addIntData(int num1, int num2) {
		return num1 + num2;
	}
}
