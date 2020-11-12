package com.codedictator.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Emp {
	String name, role;

	Emp(String a, String b) {
		name = a;
		role = b;
	}

	String getRole() {
		return role;
	}

	String getName() {
		return name;
	}

	public String toString() {
		return "User Name : " + name + ", Role :" + role;
	}
}

public class PredicateInStreamAPI {

	public static void main(String args[]) {
		List<User> users = new ArrayList<User>();
		users.add(new User("Kalpesh", "admin"));
		users.add(new User("Mali", "member"));

// This line uses Predicates to filter out the list of users with the role "admin".
//		List admins = process(users, (User u) -> u.getRole().equals("admin"));

// Replacing it with the following line using Stream API and lambda functions produces the same output

// the input to the filter() is a lambda expression that returns a predicate: a boolean value for each user encountered (true if admin, false otherwise)
		List admins = users.stream().filter((user) -> user.getRole().equals("admin")).collect(Collectors.toList());

		System.out.println(admins);
	}
}
