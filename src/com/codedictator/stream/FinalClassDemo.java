package com.codedictator.stream;

final class Student {
	final int ROLL_NUMBER;

	public Student(int rollNumber) {
		this.ROLL_NUMBER = rollNumber;
	}

	public void printRollNumber() {
		System.out.println("Roll Number: " + ROLL_NUMBER);
	}
}

public class FinalClassDemo {
	public static void main(String[] args) {
		Student s1 = new Student(1234);
		s1.printRollNumber();

		Student s2 = new Student(007);
		s2.printRollNumber();

		Student s3 = new Student(14785);
		s3.printRollNumber();

	}

}
