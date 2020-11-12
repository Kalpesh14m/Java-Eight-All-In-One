package com.codedictator.optionalclass;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalClassLearning {
	public static void main(String[] args) {
// we used the isPresent() method to check if there is a value inside the
// Optional object. A value is present only if we have created Optional with a
// non-null value.
		Optional<String> empty = Optional.empty();

// When we have an Optional object returned from a method or created by us, we can check if there is a value in it or not with the isPresent() method:
		System.out.println("empty(): " + empty.isPresent());

// the argument passed to the of() method can't be null. Otherwise, we'll get a
// NullPointerException
		String name = "codedictator";
		Optional<String> opt = Optional.of(name);
		System.out.println("of(): " + opt.isPresent());

		opt = Optional.of("codedictator");
		System.out.println("of() empty(): " + opt.empty());

//		name = null;
//		opt = Optional.of(name);
//		System.out.println(opt.isPresent());// requireNonNull 

// if we pass in a null reference, it doesn't throw an exception but rather returns an empty Optional object:
		opt = Optional.ofNullable(null);
		System.out.println("ofNullable(): " + opt.isPresent());

		opt = Optional.ofNullable(null);
		System.out.println("ofNullable() empty(): " + opt.empty());

// Conditional Action With ifPresent()
// The ifPresent() method enables us to run some code on the wrapped value if it's found to be non-null. Before Optional, 
// This code checks if the name variable is null or not before going ahead to execute some code on it. This approach is lengthy, and that's not the only problem — it's also prone to error.
		if (name != null) {
			System.out.println(name.length());
		}
		opt = Optional.of("codedictator");
		opt.ifPresent(varName -> System.out.println(varName.length()));

// Default Value With orElse()
// The orElse() method is used to retrieve the value wrapped inside an Optional instance. It takes one parameter, which acts as a default value. The orElse() method returns the wrapped value if it's present, and its argument otherwise
		String nullName = null;
		name = Optional.ofNullable(nullName).orElse("kalpesh");
		System.out.println("orElse(): " + name);

// Default Value With orElseGet()
// The orElseGet() method is similar to orElse(). However, instead of taking a value to return if the Optional value is not present, it takes a supplier functional interface, which is invoked and returns the value of the invocation

		nullName = null;
		name = Optional.ofNullable(nullName).orElseGet(() -> "Kalpesh");
		System.out.println("orElseGet(): " + name);

// However, there's a subtle but very important difference between the two that can affect the performance of our code drastically if not well understood.
		OptionalClassLearning o = new OptionalClassLearning();
		o.testDemo();

// Exceptions With orElseThrow()
// The orElseThrow() method follows from orElse() and orElseGet() and adds a new approach for handling an absent value. Instead of returning a default value when the wrapped value is not present, it throws an exception

//		nullName = null;	
//		name = Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new);
//		System.out.println(name);

// Java 10 introduced a simplified no-arg version of orElseThrow() method. In case of an empty Optional it throws a NoSuchElelementException:
//		nullName = null;
//		name = Optional.ofNullable(null).orElseThrow();
//		System.out.println(name);

// Returning Value With get()
// The final approach for retrieving the wrapped value is the get() method:
		opt = Optional.of("codedictator");
		System.out.println("get(): " + opt.get());

//// However, unlike the previous three approaches, get() can only return a value if the wrapped object is not null; otherwise, it throws a no such element exception:
//		opt = Optional.ofNullable(null);
//		System.out.println("get(null): " + opt.get());

//Conditional Return With filter()
// We can run an inline test on our wrapped value with the filter method. It takes a predicate as an argument and returns an Optional object. If the wrapped value passes testing by the predicate, then the Optional is returned as-is.
		Integer year = 2016;
		Optional<Integer> yearOptional = Optional.of(year);
		System.out.println("Year is 2016: " + yearOptional.filter(y -> y == 2016).isPresent());

		System.out.println("\nReal Time Example");
// Without filter : Pay attention to how much code we have to write to achieve this, especially in the if condition. The only part of the if condition that is critical to the application is the last price-range check; the rest of the checks are defensive
		System.out.println(priceIsInRange1(new Modem(10.0)));
		System.out.println(priceIsInRange1(new Modem(9.9)));
		System.out.println(priceIsInRange1(new Modem(null)));
		System.out.println(priceIsInRange1(new Modem(15.5)));
		System.out.println(priceIsInRange1(null));
// Optional With Filter() : First of all, if a null object is passed to this method, we don't expect any problem.
// 		Secondly, the only logic we write inside its body is exactly what the method name describes — price-range check. Optional takes care of the rest 
// The map call is simply used to transform a value to some other value. Keep in mind that this operation does not modify the original value.
		System.out.println(priceIsInRange2(new Modem(10.0)));
		System.out.println(priceIsInRange2(new Modem(9.9)));
		System.out.println(priceIsInRange2(new Modem(null)));
		System.out.println(priceIsInRange2(new Modem(15.5)));
		System.out.println(priceIsInRange2(null));

//Transforming Value With map()
// we wrap a list of strings inside an Optional object and use its map method to perform an action on the contained list. The action we perform is to retrieve the size of the list.
// The map method returns the result of the computation wrapped inside Optional. We then have to call an appropriate method on the returned Optional to retrieve its value.
// Notice that the filter method simply performs a check on the value and returns a boolean. The map method however takes the existing value, performs a computation using this value, and returns the result of the computation wrapped in an Optional object
		List<String> companyNames = Arrays.asList("paypal", "oracle", "", "microsoft", "", "apple");
		Optional<List<String>> listOptional = Optional.of(companyNames);

		int size = listOptional.map(List::size).orElse(0);
		System.out.println("Map() | size: " + size);

// chain map and filter together to do something more powerful.
		String password = " password ";
		Optional<String> passOpt = Optional.of(password);
		boolean correctPassword = passOpt.map(String::trim).filter(pass -> pass.equals("password")).isPresent();
		System.out.println("valid Pass: " + correctPassword);

// Transforming Value With flatMap()
//Just like the map() method, we also have the flatMap() method as an alternative for transforming values. The difference is that map transforms values only when they are unwrapped whereas flatMap takes a wrapped value and unwraps it before transforming it.

// Previously, we created simple String and Integer objects for wrapping in an Optional instance. However, frequently, we will receive these objects from an accessor of a complex object.

//Notice now that when we wrap a Person object, it will contain nested Optional instances:
		Person person = new Person("Kalpesh", 26, "ABCD");
		Optional<Person> personOptional = Optional.of(person);

//The only difference is that getName() returns an Optional rather than a String as did the trim() operation. This, coupled with the fact that a map transformation wraps the result in an Optional object, leads to a nested Optional.
		Optional<Optional<String>> nameOptionalWrapper = personOptional.map(Person::getName);
		Optional<String> nameOptional = nameOptionalWrapper.orElseThrow(IllegalArgumentException::new);
		name = nameOptional.orElse("");
		System.out.println("Name: " + name);

// While using map() method, therefore, we need to add an extra call to retrieve the value before using the transformed value. This way, the Optional wrapper will be removed. 
// This operation is performed implicitly when using flatMap.
		String name1 = personOptional.flatMap(Person::getName).orElse("");
		System.out.println("Name: " + name1);

// Chaining Optionals in Java 8

		// Without Java 8 Option
		System.out.println("Without Optional Chaining: " + createOptional("found"));

		// With Java 8 Option
		Optional<String> found = Stream.of(getEmpty(), getHello(), getBye()).filter(Optional::isPresent)
				.map(Optional::get).findFirst();
		System.out.println("Optional Chaining: " + found);
	}

	private static Optional<String> getEmpty() {
		return Optional.empty();
	}

	private static Optional<String> getHello() {
		return Optional.of("hello");
	}

	private static Optional<String> getBye() {
		return Optional.of("bye");
	}

	private static Optional<String> createOptional(String input) {
		if (input == null || "".equals(input) || "empty".equals(input)) {
			return Optional.empty();
		}
		return Optional.of(input);
	}

	static class Person {
		private String name;
		private int age;
		private String password;

		public Person(String name, int age, String password) {
			this.name = name;
			this.age = age;
			this.password = password;
		}

		public Optional<String> getName() {
			return Optional.ofNullable(name);
		}

		public Optional<Integer> getAge() {
			return Optional.ofNullable(age);
		}

		public Optional<String> getPassword() {
			return Optional.ofNullable(password);
		}

	}

	static class Modem {
		private Double price;

		public Modem(Double price) {
			this.price = price;
		}

		public Double getPrice() {
			return price;
		}
	}

	public static boolean priceIsInRange1(Modem modem) {
		boolean isInRange = false;
		if (modem != null && modem.getPrice() != null && (modem.getPrice() >= 10 && modem.getPrice() <= 15)) {
			isInRange = true;
		}
		return isInRange;
	}

	public static boolean priceIsInRange2(Modem modem2) {
		return Optional.ofNullable(modem2).map(Modem::getPrice).filter(p -> p >= 10 && p <= 15).isPresent();
	}

	public void testDemo() {
// Let's see two tests and observe their side effects to establish both where orElse() and orElseGet() overlap and where they differ
		System.out.println("\n");

		String text = null;

		String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
		System.out.println(defaultText);

		defaultText = Optional.ofNullable(text).orElse(getMyDefault());
		System.out.println(defaultText);
//In the above example, we wrap a null text inside an Optional object and attempt to get the wrapped value using each of the two approaches.
// The side effect is: 
//		Getting Default Value
//		Default Value
//		Getting Default Value
//		Default Value

// The getMyDefault() method is called in each case. It so happens that when the wrapped value is not present, then both orElse() and orElseGet() work exactly the same way.

// Now let's run another test where the value is present, and ideally, the default value should not even be created:

		text = "codedictator";
		System.out.println("\n");
		defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
		System.out.println(defaultText);

		defaultText = Optional.ofNullable(text).orElse(getMyDefault());
		System.out.println(defaultText);
// In the above example, we are no longer wrapping a null value, and the rest of the code remains the same.

// Now let's take a look at the side effect of running this code:
//		codedictator
//		Getting Default Value
//		codedictator
// Notice that when using orElseGet() to retrieve the wrapped value, the getMyDefault() method is not even invoked since the contained value is present.

//However, when using orElse(), whether the wrapped value is present or not, the default object is created. So in this case, we have just created one redundant object that is never used.

// In this simple example, there is no significant cost to creating a default object, as the JVM knows how to deal with such. However, when a method such as getMyDefault() has to make a web service call or even query a database, the cost becomes very obvious.
	}

	public String getMyDefault() {
		System.out.println("Getting Default Value");
		return "Default Value";
	}

}
