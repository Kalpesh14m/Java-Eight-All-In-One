package com.codedictator.optionalclass;

public class WhyOptionalNeeded {
	public static void main(String[] args) {
		String[] str = new String[10];
		String lowercaseString = str[5].toLowerCase();
		System.out.print(lowercaseString);// null
	}

}
/*
 * The introduction of the Optional class was a major improvement in the design
 * of the Java language, but this improvement has been controversial. Prior the
 * Optional class, many developers used either null or exceptions to denote when
 * a desired value was not present; using the Optional class, however, allows us
 * to explicitly state when a value may or may not be present. Despite this
 * improvement, the Optional class can be applied inappropriately and cause more
 * harm than good.
 * 
 * You must import java.util package to use this class. It provides methods
 * which are used to check the presence of value for particular variable.
 * 
 * public static <T> Optional<T> empty(): It returns an empty Optional object.
 * No value is present for this Optional.
 * 
 * public static <T> Optional<T> of(T value): It returns an Optional with the
 * specified present non-null value.
 * 
 * public static <T> Optional<T> ofNullable(T value): It returns an Optional
 * describing the specified value, if non-null, otherwise returns an empty
 * Optional.
 * 
 * public T get(): If a value is present in this Optional, returns the value,
 * otherwise throws NoSuchElementException.
 * 
 * public boolean isPresent(): It returns true if there is a value present,
 * otherwise false.
 * 
 * public void ifPresent(Consumer<? super T> consumer): If a value is present,
 * invoke the specified consumer with the value, otherwise do nothing.
 * 
 * public Optional<T> filter(Predicate<? super T> predicate): If a value is
 * present, and the value matches the given predicate, return an Optional
 * describing the value, otherwise return an empty Optional.
 * 
 * public <U> Optional<U> map(Function<? super T,? extends U> mapper): If a
 * value is present, apply the provided mapping function to it, and if the
 * result is non-null, return an Optional describing the result. Otherwise
 * return an empty Optional.
 * 
 * public <U> Optional<U> flatMap(Function<? super T,Optional<U> mapper): If a
 * value is present, apply the provided Optional-bearing mapping function to it,
 * return that result, otherwise return an empty Optional.
 * 
 * public T orElse(T other): It returns the value if present, otherwise returns
 * other.
 * 
 * public T orElseGet(Supplier<? extends T> other): It returns the value if
 * present, otherwise invoke other and return the result of that invocation.
 * 
 * public <X extends Throwable> T orElseThrow(Supplier<? extends X>
 * exceptionSupplier) throws X extends Throwable: It returns the contained
 * value, if present, otherwise throw an exception to be created by the provided
 * supplier.
 * 
 * public boolean equals(Object obj): Indicates whether some other object is
 * "equal to" this Optional or not.
 * 
 * The other object is considered equal if:
 * 
 * It is also an Optional and;
 * 
 * Both instances have no value present or;
 * 
 * the present values are "equal to" each other via equals().
 * 
 * public int hashCode(): It returns the hash code value of the present value,
 * if any, or returns 0 (zero) if no value is present.
 * 
 * public String toString(): It returns a non-empty string representation of
 * this Optional suitable for debugging. The exact presentation format is
 * unspecified and may vary between implementations and versions.
 */
