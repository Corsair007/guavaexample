package com.yeahmobi.rundemo.guavaexample.collections.newtypes;

import com.google.common.collect.MutableClassToInstanceMap;

import static com.yeahmobi.rundemo.guavaexample.utils.PrintUtils.*;

/**
 * @rundemo_name 新集合之ClassToInstanceMap
 *  有的时候，你的map的key并不是一种类型，他们是很多类型，你想通过映射他们得到这种类型，
 *  guava提供了ClassToInstanceMap满足了这个目的。
 * @author root
 *
 */
public class ClassToInstanceMapSample {

	public static void main(String[] args) {
		MutableClassToInstanceMap<Object> numberDefaults = MutableClassToInstanceMap
				.create();
		numberDefaults.putInstance(Integer.class, Integer.valueOf(8));
		System.out.println(numberDefaults.get(Integer.class));

		dividingLine();
		
		MutableClassToInstanceMap<Object> classToInstanceMapString = MutableClassToInstanceMap
				.create();
		MutableClassToInstanceMap<Object> classToInstanceMap = MutableClassToInstanceMap
				.create();
		Person person = new Person("peida", 20);
		System.out
				.println("person name :" + person.name + " age:" + person.age);
		classToInstanceMapString.put(String.class, "peida");
		System.out.println("string:"
				+ classToInstanceMapString.getInstance(String.class));

		classToInstanceMap.putInstance(Person.class, person);
		Person person1 = classToInstanceMap.getInstance(Person.class);
		System.out.println("person1 name :" + person1.name + " age:"
				+ person1.age);

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
