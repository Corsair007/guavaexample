package com.yeahmobi.rundemo.guavaexample.basicutiltties.objectmethods;

import java.util.Comparator;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

import static com.yeahmobi.rundemo.guavaexample.utils.PrintUtils.*;

/**
 * @rundemo_name Object通用方法
 * @desc Objects类提供适用于所有对象，如equals, hashCode等辅助函数
 * @author root
 *
 */
public class ObjectMethodsSample {

	public static void main(String[] args) {
		/**
		 * 1.equals()方法 equals是一个经常需要覆写的方法，
		 * 当我们要覆写的类中某些值可能为null的时候，就需要对null做很多判断和分支处理。
		 * 使用Guava的Objects.equal方法可以避免这个问题， 使得equals的方法的覆写变得更加容易， 而且可读性强，简洁优雅。
		 */
		print("Objects.equal(\"a\", \"a\")", Objects.equal("a", "a"));
		print("Objects.equal(null, \"a\")", Objects.equal(null, "a"));
		print("Objects.equal(\"a\", null)", Objects.equal("a", null));
		print("Objects.equal(null, null)", Objects.equal(null, null));

		dividingLine();

		ObjectMethodsSample sample = new ObjectMethodsSample();
		sample.equalPersonTest();

		dividingLine();
		/**
		 * 2.hashCode()
		 * 当覆写（override）了equals()方法之后，必须也覆写hashCode()方法，反之亦然。这个方法返回一个整型值
		 * （hashcode value），如果两个对象被equals()方法判断为相等，那么它们就应该拥有同样的hash
		 * code。Object类的hashCode()方法为不同的对象返回不同的值，Object类的hashCode值表示的是对象的地址。
		 * Guava提供给我们了一个更加简单的方法--Objects.hashCode(Object...)，
		 * 这是个可变参数的方法，参数列表可以是任意数量，所以可以像这样使用Objects.hashCode(field1， field2， ...，
		 * fieldn)。非常方便和简洁
		 */
		print("Objects.hashCode(\"a\")", Objects.hashCode("a"));
		print("Objects.hashCode(\"a\")", Objects.hashCode("a"));
		print("Objects.hashCode(\"a\",\"b\")", Objects.hashCode("a", "b"));
		print("Objects.hashCode(\"b\",\"a\")", Objects.hashCode("b", "a"));
		print("Objects.hashCode(\"a\",\"b\",\"c\")",
				Objects.hashCode("a", "b", "c"));

		Person person3 = new Person("peida", 23);
		print("Objects.hashCode(person3)", Objects.hashCode(person3));

		dividingLine();
		/**
		 * 3.toString()
		 */
		print("Objects.toStringHelper(Person.class).add(\"x\", 1).toString()",
				Objects.toStringHelper(Person.class).add("x", 1).toString());
		print("Objects.toStringHelper(ObjectMethodsSample.class).add(\"x\", 1).toString()",
				Objects.toStringHelper(ObjectMethodsSample.class).add("x", 1)
						.toString());

		Person person = new Person("peida", 23);
		String result = Objects.toStringHelper(Person.class)
				.add("name", person.name).add("age", person.age).toString();
		print("Objects.toStringHelper(Person.class).add(\"name\", person.name).add(\"age\", person.age).toString()",
				result);
		dividingLine();
		/**
		 * 4.compare/compareTo 
		 * 使用ComparisonChain做了优化，它是一个lazy的比较过程，当比较结果为0的时候，即相等的时候，
		 * 会继续比较下去， 出现非0的情况，就会忽略后面的比较。ComparisonChain实现的compare和compareTo在代码可读性和性能上都有很大的提高。
		 */
		Student student1 = new Student("Andy", 18, 80);
		Student student2 = new Student("Andy", 18, 80);
		Student student3 = new Student("Andy", 18, 78);
		Student student4 = new Student("Jack", 18, 80);

		print("student1.compareTo(student2)", student1.compareTo(student2));
		print("student1.compareTo(student3)", student1.compareTo(student3));
		print("student1.compareTo(student4)", student1.compareTo(student4));
	}

	public void equalPersonTest() {
		Person person1 = new Person("peida", 23);
		Person person2 = new Person("peida", 23);
		print("Objects.equal(person1, person2)",
				Objects.equal(person1, person2));
		Person person = new Person("peida", 23);
		print("Objects.equal(person, person)", Objects.equal(person, person));
	}

}

class Person {
	public String name;
	public int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

class Student implements Comparable<Student> {
	public String name;
	public int age;
	public int score;

	Student(String name, int age, int score) {
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public int compareTo(Student other) {
		return ComparisonChain.start().compare(name, other.name)
				.compare(age, other.age)
				.compare(score, other.score, Ordering.natural().nullsLast())
				.result();
	}
}

class StudentComparator implements Comparator<Student> {
	public int compare(Student s1, Student s2) {
		return ComparisonChain.start().compare(s1.name, s2.name)
				.compare(s1.age, s2.age).compare(s1.score, s2.score).result();
	}
}
