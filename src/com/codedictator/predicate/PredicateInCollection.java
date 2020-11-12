package com.codedictator.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class User {
	String name, role;

	User(String a, String b) {
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

public class PredicateInCollection {

	public static void main(String args[]) {
		List<Emp> users = new ArrayList<Emp>();
		users.add(new Emp("Kalpesh", "admin"));
		users.add(new Emp("Bunny", "member"));
		List admins = process(users, (Emp u) -> u.getRole().equals("admin"));
		System.out.println(admins);
	}

	public static List<Emp> process(List<Emp> users, Predicate<Emp> predicat) {
		List<Emp> result = new ArrayList<Emp>();
		for (Emp user : users)
			if (predicat.test(user))
				result.add(user);
		return result;
	}
}
