package com.codedictator.lambda;

//Achieved Abstraction with interface
public class WithoutLambda {
	public static void main(String[] args) {
		Calculator add = new CalculatorProvider();
		System.out.println("Add: " + add.operation(10, 20));
	}
}

@FunctionalInterface
interface Calculator {
	public int operation(int a, int b);
}

class CalculatorProvider implements Calculator {

	@Override
	public int operation(int a, int b) {
		return a + b;
	}

}