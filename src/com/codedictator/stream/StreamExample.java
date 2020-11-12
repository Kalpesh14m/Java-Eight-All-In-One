package com.codedictator.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
	private int id;
	private String name, dep;
	private float price;

	public Employee(int id, String name, float price, String dep) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.dep = dep;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}

	public String getDep() {
		return dep;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dep=" + dep + ", price=" + price + "]";
	}

}

public class StreamExample {
	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(1, "Sunil", 1000f, "Comp"));
		empList.add(new Employee(2, "Venkat", 1200f, "It"));
		empList.add(new Employee(3, "Kalpesh", 800f, "Civil"));
		empList.add(new Employee(4, "Pooja", 500f, "Comp"));
		empList.add(new Employee(5, "Varsha", 1400f, "It"));

//		empList.stream().forEach(emp -> System.out.println("Employee: " + emp));
//		empList.stream().filter(emp -> emp.getPrice() > 1000).forEach(emp -> System.out.println(emp));

//		double totalSalary = empList.stream().map(emp -> emp.getPrice()).reduce(0.0f, (sum, price) -> sum + price);

//		double totalSalary1 = empList.stream().map(Employee::getPrice).reduce(0.0f, (sum, price) -> sum + price);
//		System.out.println(totalSalary1);
//
//		double totalSalary2 = empList.stream().reduce(0.0f, (sum, price) -> sum + price.getPrice(), Float::sum);
//		System.out.println(totalSalary2);

//		double totalSalary3 = empList.stream().map(emp -> emp.getPrice()).reduce(0.0f, Float::sum);
//		System.out.println(totalSalary3);

//		Set<Employee> listToSet = empList.stream().collect(Collectors.toSet());
//		listToSet.forEach(i -> System.out.println(i));

//		Map<Integer, String> listToMap = empList.stream()
//				.collect(Collectors.toMap(Employee::getId, emp -> emp.getName()));
//		System.out.println(listToMap);

		Map<String, List<Employee>> listMap = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDep, Collectors.toList()));
		listMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

	}

}
