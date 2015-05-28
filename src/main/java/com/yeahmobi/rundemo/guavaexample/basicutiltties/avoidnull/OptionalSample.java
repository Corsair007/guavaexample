package com.yeahmobi.rundemo.guavaexample.basicutiltties.avoidnull;

import java.util.List;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;

/**
 * @rundemo_name
 * @author root
 *
 */
public class OptionalSample {
	public static void main(String[] args) {

	}

	public void should_get_total_age_for_all_employees() throws Exception {
		final List<Employee> list = Lists.newArrayList(new Employee("em1", 30),
				new Employee("em2", 40), null, new Employee("em4", 18));
		int sum = 0;
		for (Employee employee : list) {
			if (employee != null) {
				sum += employee.getAge();
			}
		}
		System.out.println(sum);
	}

	public void testOptional() throws Exception {
		final List<Employee> list = Lists.newArrayList(new Employee("em1", 30),
				new Employee("em2", 40), null, new Employee("em4", 18));
		int sum = 0;
		for (Employee employee : list) {
			sum += Optional.fromNullable(employee).or(new Employee("dummy", 0))
					.getAge();
		}
		System.out.println(sum);
	}

	private class Employee {
		private final String name;
		private final int age;

		public Employee(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}
	}
}
