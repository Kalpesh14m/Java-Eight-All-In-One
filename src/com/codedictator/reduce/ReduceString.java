package com.codedictator.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceString {
	public static void main(String[] args) {

		// The lambda expression passed to reduce() method takes two Strings and returns
		// the longer String.
		// The result of the reduce() method is an Optional because the list on which
		// reduce() is called may be empty.
		List<String> list = Arrays.asList("Kalpesh", "Sunil", "Venkat", "Pooja", "Ram", "Bunny");
		Optional<String> maybeElements = list.stream()
				.reduce((str1, str2) -> str1.length() > str2.length() ? str1 : str2);
		System.out.println(maybeElements);

		Optional<String> String_combine = list.stream().reduce((str1, str2) -> str1 + "-" + str2);

		// Displaying the combined String
		if (String_combine.isPresent()) {
			System.out.println(String_combine.get());
		}
	}
}
