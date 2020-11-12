package com.codedictator.CollectorsClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Product {
	private int id;
	private String name, dept;
	private float price;

	public Product(int id, String name, float price, String dept) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.dept = dept;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDept() {
		return dept;
	}

	public float getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", dept=" + dept + ", price=" + price + "]";
	}

}

public class CollectorsExample {
	public static void main(String[] args) {
		// List of Products
		List<Product> productsList = new ArrayList<>();

		// Adding Products
		productsList.add(new Product(1, "HP Laptop", 25000f, "IT"));
		productsList.add(new Product(2, "Dell Laptop", 30000f, "COMP"));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f, "CIVIL"));
		productsList.add(new Product(4, "Sony Laptop", 28000f, "COMP"));
		productsList.add(new Product(5, "Apple Laptop", 90000f, "IT"));

		// Fetching data as a List
		System.out.println("List To List : ProductList to PriceList");
		List<Float> productPriceList = productsList.stream().map(x -> x.getPrice()) // fetching price
				.collect(Collectors.toList()); // collecting as list
		System.out.println(productPriceList);

		// Converting Data as a Set
		System.out.println("List To Set : ProductList to PriceSet");
		Set<Float> listToSet = productsList.stream().map(x -> x.getPrice()) // fetching price
				.collect(Collectors.toSet()); // collecting as list
		System.out.println(listToSet);

		// Convert List into Map
		System.out.println("List To Map : ProductList to Map with id and name");
		Map<Integer, String> listToMap = productsList.stream()
				.collect(Collectors.toMap(Product::getId, Product::getName));
		System.out.println(listToMap);

		// Convert List into Map
		System.out.println("List To Map : ProductList to Map with id and Product Object");
		Map<String, List<Product>> listMap = productsList.stream()
				.collect(Collectors.groupingBy(Product::getDept, Collectors.toList()));
		listMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

		// using sum method
		Double sumPrices = productsList.stream().collect(Collectors.summingDouble(x -> x.getPrice())); // collecting as
																										// list
		System.out.println("Sum of prices: " + sumPrices);

		// Getting Product Average Price
		Double average = productsList.stream().collect(Collectors.averagingDouble(p -> p.getPrice()));
		System.out.println("Average price is: " + average);

		// Counting Elements
		Long noOfElements = productsList.stream().collect(Collectors.counting());
		System.out.println("Total elements : " + noOfElements);
	}
}

/*
 * A final class that is extended by the object class are collectors to provide
 * operations on reduction like an accumulation of elements into the collection,
 * based on different criteria elements are summarized, etc. and the elements
 * are dealt by using the methods available in Java collectors class and this
 * class is a member of a utility class java.util.stream package which is
 * consisting of many static methods.
 * 
 * 
 * Syntax to Declare Java Collectors is as follows:
 * 
 * Interface collector <T,A,R>
 * 
 * Where,
 * 
 * T indicates the input elements type on which the reduction operation is to be
 * performed.
 * 
 * A indicates the reduction operations’ accumulation type and it is mutable.
 * 
 * R indicates the reduction type’s result.
 * 
 * 
 * Syntax to import java collectors is as follows:
 * 
 * import static java.util.stream.Collectors.*;
 * 
 * There are different types of collectors and the syntax to import the
 * collectors of different types is as follows:
 * 
 * import static java.util.stream.Collectors.toList.
 * 
 * import static java.util.stream.Collectors.toMap.
 * 
 * import static java.util.stream.Collectors.toSet.
 * 
 * 
 * Working of Collectors in Java 8
 * 
 * The java.util.stream.collectors class provides thirty-seven different
 * collectors which are further divided into three groups namely:
 * 
 * - A single value or collection type is reduced or summarized.
 * 
 * - Joining() method can be used to join the strings, new collections can be
 * created using toset(), the new features like numeric streams summary can be
 * leveraged using summarizingInt().
 * 
 * - Grouping: GroupingBy() method can be used in three different ways and
 * parallel or concurrent processing using another three.
 * 
 * - Partitioning.
 * 
 * 
 * 
 * Two methods like partitionBy() are available. We can create our own
 * collectors if we need unique handling.
 * 
 * There are no restrictions on the provided collectors.
 * 
 * The interface collector <T, A, R> is implemented by every collector where,
 * 
 * T indicates the input elements type on which the reduction operation is to be
 * performed.
 * 
 * A indicates the reduction operations’ accumulation type and it is mutable.
 * 
 * R indicates the reduction type’s result.
 * 
 * 
 * 
 * Methods of Java 8 Collectors
 * 
 * The methods supported by the collector are:
 * 
 * 1. Supplier(): New instances of the objects of the accumulator are created
 * using supplier<A> provided by the supplier() method.
 * 
 * 2. Combiner(): Multiple objects of the accumulator are created by the
 * collector when working with parallel processing of stream and these multiple
 * objects can be merged by using the functionality provided by the combiner()
 * method.
 * 
 * 3. Finisher(): The transformation of the accumulator object to return type R
 * while finishing the collection process is done by this finisher() method.
 * 
 * 4. Characteristics(): The characteristics of the collector are described
 * using this characteristic () method.
 * 
 */
