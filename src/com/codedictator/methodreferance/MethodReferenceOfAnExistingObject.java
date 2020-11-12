package com.codedictator.methodreferance;

import java.util.function.Consumer;

public class MethodReferenceOfAnExistingObject {
	public static void main(String[] args) {
		final Mechanic mechanic = new Mechanic();
		Car car = new Car();

		// Using an anonymous class
		car.setId(1);
		mechanic.execute(car, new Consumer<Car>() {
			public void accept(Car c) {
				mechanic.fix(c);
			}
		});

		// Using a lambda expression
		car.setId(2);
		mechanic.execute(car, c -> mechanic.fix(c));

		// Using a method reference
		car.setId(3);
		mechanic.execute(car, mechanic::fix);
	}
}

class Car {
	private int id;
	private String color;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}

class Mechanic {
	public void fix(Car c) {
		System.out.println("Fixing car " + c.getId());
	}

	public void execute(Car car, Consumer<Car> c) {
		c.accept(car);
	}

}

/*
 * In this case, we have a lambda expression like the following:
 * 
 * (args) -> obj.instanceMethod(args)
 * 
 * This can be turned into the following method reference:
 * 
 * obj::instanceMethod
 * 
 * This time, an instance defined somewhere else is used, and the arguments (if
 * any) are passed behind the curtains like in the static method case.
 * 
 * The key, in this case, is to use any object visible by an anonymous
 * class/lambda expression and pass some arguments to an instance method of that
 * object.
 */
