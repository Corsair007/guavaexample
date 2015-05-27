package com.yeahmobi.rundemo.guavaexample.collections.newtypes;

import java.util.Collection;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import static com.yeahmobi.rundemo.guavaexample.utils.PrintUtils.*;

/**
 * @rundemo_name 新集合之MultiMap
 * @desc MultiMap实现了把一个键对应到多个值的数据结构,即数据类型Map<K,Collection<V>>
 * @use scene 假如现在有一份日志记录，每条记录的内容是一个 url对应一个访客的 userid，我想得到每个url对应的pv、uv数据
 * @author root
 *
 */

public class MultiMapSample {
	public static void main(String[] args) {
		Multimap<String, String> myMultimap = ArrayListMultimap.create();

		// 1. Adding some key/value
		myMultimap.put("Fruits", "Bannana");
		myMultimap.put("Fruits", "Apple");
		myMultimap.put("Fruits", "Pear");
		myMultimap.put("Fruits", "Pear");
		myMultimap.put("Vegetables", "Carrot");

		dividingLine();

		// 2. Getting the size
		int size = myMultimap.size();
		System.out.println(size); // 5

		dividingLine();

		// 3. Getting values
		/**
		 * get方法返回的是一个collection而不是list，这是因为collection会更加有用。
		 * 如果你需要基于multimap直接操作list或者set，那么可以使用在定义类型的时候使用子类名称：
		 * ListMultimap，SetMultimap和SortedSetMultimap。
		 */
		Collection<String> fruits = myMultimap.get("Fruits");
		System.out.println(fruits); // [Bannana, Apple, Pear, Pear]
		System.out.println(ImmutableSet.copyOf(fruits));// [Bannana, Apple,
														// Pear]
		// Set<Foo> set = Sets.newHashSet(list);
		// Set<Foo> foo = new HashSet<Foo>(myList);

		dividingLine();

		Collection<String> vegetables = myMultimap.get("Vegetables");
		System.out.println(vegetables); // [Carrot]

		dividingLine();

		// 4. Iterating over entire Mutlimap
		for (String value : myMultimap.values()) {
			System.out.println(value);
		}

		dividingLine();

		// 5. Removing a single value
		myMultimap.remove("Fruits", "Pear");
		System.out.println(myMultimap.get("Fruits")); // [Bannana, Apple, Pear]

		dividingLine();

		// 6. Remove all values for a key
		myMultimap.removeAll("Fruits");
		System.out.println(myMultimap.get("Fruits")); // [] (Empty Collection!)

		//
	}

}
