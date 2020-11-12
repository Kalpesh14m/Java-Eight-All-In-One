package com.codedictator.consumer;

import java.util.function.Consumer;

public class ConsumerWithClassObj {
	public static void main(String[] args) {

		Consumer<Student> consumerListObj = student -> System.out
				.println("Student details: \n" + "\nName: \n" + student.getName() + "\n\nAge:\n" + student.getAge());

		Student student = new Student(1, "Kalpesh");

		consumerListObj.accept(student);
	}
}
