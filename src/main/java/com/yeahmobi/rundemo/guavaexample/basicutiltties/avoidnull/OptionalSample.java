package com.yeahmobi.rundemo.guavaexample.basicutiltties.avoidnull;

import java.util.List;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;

import static com.yeahmobi.rundemo.guavaexample.utils.PrintUtils.*;

/**
 * @rundemo_name NULL值的处理
 * @desc Optional用于包含非空对象的不可变对象。
 *       Optional对象，用于不存在值表示null。这个类有各种实用的方法，以方便代码来处理为可用或不可用，而不是检查null值。
 * @author root
 *
 */
public class OptionalSample {
	public static void main(String[] args) throws Exception {

		Integer value1 = null;
		Integer value2 = new Integer(10);
		// Optional.fromNullable - allows passed parameter to be null.
		// 创建指定引用的Optional实例，若引用为null则表示缺失
		Optional<Integer> a = Optional.fromNullable(value1);
		// Optional.of - throws NullPointerException if passed parameter is null
		// 创建指定引用的Optional实例，若引用为null则快速失败
		Optional<Integer> b = Optional.of(value2);

		print("value1+value2 ", sum(a, b));

		dividingLine();

		// 通常处理null的方法
		oldTreatmentMethod();
		// Optional处理方法
		testOptional();
		// 从上面可以清晰看出，我们不在担心对象对空了，利用Optional的fromNullable创建了一个可空对象，
		// 并将其or上一个dummy的员工信息，所以在这里我们不在担心NullPointerExceptiond。
		/**
		 * OptionalObject.isPresent(): 返回对象是否有值。
		 * 
		 * Optional.absent(): 返回一个空Optional对象,isPresent() 将会返回false
		 * 
		 * Optional.of(): 创Optional对象，输入参数不能为null
		 * 
		 * Optional.fromNullable(): 创Optional对象，输入可以为null
		 * 
		 * OptionalObject.asSet(): 和Optional对象值合并，如果为null则返回size为0的Set
		 * 
		 * OptionalObject.or(): 和Optional对象值合并，如果为null为空加则返回or参数作为默认值
		 * 
		 * OptionalObject.orNull(): 和Optional对象值合并，如果为null为空加则返回Null作为默认值
		 * 
		 * 上面的api都是我们在使用Optional的时候最常用的方法属性方法，注意如果我们创建了Optional对象，
		 * 但是没有判断isPresent()是否存在，就直接get这是会抛异常的，这属于乱用Optional情况，和直接用Null并没什么差别。
		 */
	}

	public static Integer sum(Optional<Integer> a, Optional<Integer> b) {
		// Optional.isPresent - checks the value is present or not
		System.out.println("First parameter is present: " + a.isPresent());

		System.out.println("Second parameter is present: " + b.isPresent());

		// Optional.or - returns the value if present otherwise returns
		// the default value passed.
		Integer value1 = a.or(new Integer(0));

		// Optional.get - gets the value, value should be present
		Integer value2 = b.get();

		return value1 + value2;
	}

	public static void oldTreatmentMethod() throws Exception {
		List<Employee> list = Lists.newArrayList(new Employee("em1", 30),
				new Employee("em2", 40), null, new Employee("em4", 18));
		int sum = 0;
		for (Employee employee : list) {
			if (employee != null) {
				sum += employee.getAge();
			}
		}
		print("oldTreatmentMethod", Integer.valueOf(sum));
	}

	public static void testOptional() throws Exception {
		List<Employee> list = Lists.newArrayList(new Employee("em1", 30),
				new Employee("em2", 40), null, new Employee("em4", 18));
		int sum = 0;
		for (Employee employee : list) {
			sum += Optional.fromNullable(employee).or(new Employee("dummy", 0))
					.getAge();
		}
		print("testOptional", Integer.valueOf(sum));
	}

	static class Employee {
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
