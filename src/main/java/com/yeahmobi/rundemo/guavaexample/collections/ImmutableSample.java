package com.yeahmobi.rundemo.guavaexample.collections;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;

import static com.yeahmobi.rundemo.guavaexample.utils.PrintUtils.*;

/**
 * @rundemo_name 不可变集合Immutable
 * @desc 不可变集合，即集合是不可被修改的。集合的数据项是在创建的时候提供，并且在整个生命周期中都不可改变。
 * @author root
 *
 */
public class ImmutableSample {

	public static void main(String[] args) {
		/**
		 * 为什么要用immutable对象？immutable对象有以下的优点：
		 * 1.对不可靠的客户代码库来说，它使用安全，可以在未受信任的类库中安全的使用这些对象
		 * 2.线程安全的：immutable对象在多线程下安全，没有竞态条件 　　　　 3.不需要支持可变性, 可以尽量节省空间和时间的开销.
		 * 所有的不可变集合实现都比可变集合更加有效的利用内存 (analysis)
		 * 4.可以被使用为一个常量，并且期望在未来也是保持不变的immutable对象可以很自然地用作常量，
		 * 因为它们天生就是不可变的对于immutable对象的运用来说，它是一个很好的防御编程（defensive
		 * programming）的技术实践。
		 */
		// 1.JDK中实现immutable集合
		/**
		 * 在JDK中提供了Collections.unmodifiableXXX系列方法来实现不可变集合,但是存在一些问题:
		 * 1.它用起来笨拙繁琐你不得不在每个防御性编程拷贝的地方用这个方法
		 * 2.它不安全：如果有对象reference原始的被封装的集合类，这些方法返回的集合也就不是正真的不可改变。
		 * 3.效率低：因为它返回的数据结构本质仍旧是原来的集合类，所以它的操作开销，包括并发下修改检查，hash
		 * table里的额外数据空间都和原来的集合是一样的。 通过下面我们先看一个具体实例：
		 */
		testJDKImmutable();
		/**
		 * 由上述实例发现Collections.unmodifiableList实现的不是真正的不可变集合，当原始集合修改后，不可变集合也发生变化。
		 * 不可变集合不可以修改集合数据，当强制修改时会报错，实例中的最后两个add会直接抛出不可修改的错误。
		 */
		dividingLine();
		// 2.Guava的immutable集合
		testGuavaImmutable();
	}

	public static void testGuavaImmutable() {
		/**
		 * 一个immutable集合可以有以下几种方式来创建： 　　
		 * 1.用copyOf方法, 譬如, ImmutableSet.copyOf(set) 　　
		 * 2.使用of方法，譬如，ImmutableSet.of("a", "b","c")或者ImmutableMap.of("a", 1, "b", 2) 　　
		 * 3.使用Builder类
		 * 对于排序的集合来说有例外，因为元素的顺序在构建集合的时候就被固定下来了。譬如，ImmutableSet.of("a", "b", "c", "a", "d", "b")，对于这个集合的遍历顺序来说就是"a", "b", "c", "d"。
		 */
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		System.out.println("list：" + list);

		ImmutableList<String> imlist = ImmutableList.copyOf(list);
		System.out.println("imlist：" + imlist);

		ImmutableList<String> imOflist = ImmutableList.of("peida", "jerry",
				"harry");
		System.out.println("imOflist：" + imOflist);

		ImmutableSortedSet<String> imSortList = ImmutableSortedSet.of("a", "b",
				"c", "a", "d", "b");
		System.out.println("imSortList：" + imSortList);

		list.add("baby");
		System.out.println("list add a item after list:" + list);
		System.out.println("list add a item after imlist:" + imlist);

		ImmutableSet<Color> imColorSet = ImmutableSet.<Color> builder()
				.add(new Color(0, 255, 255)).add(new Color(0, 191, 255))
				.build();

		System.out.println("imColorSet:" + imColorSet);
	}

	public static void testJDKImmutable() {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		System.out.println(list);

		List<String> unmodifiableList = Collections.unmodifiableList(list);
		System.out.println(unmodifiableList);

		List<String> unmodifiableList1 = Collections.unmodifiableList(Arrays
				.asList("a", "b", "c"));
		System.out.println(unmodifiableList1);

		String temp = unmodifiableList.get(1);
		System.out.println("unmodifiableList [0]：" + temp);

		list.add("baby");
		System.out.println("list add a item after list:" + list);
		System.out.println("list add a item after unmodifiableList:"
				+ unmodifiableList);

		/*
		 * unmodifiableList1.add("bb");
		 * System.out.println("unmodifiableList add a item after list:" +
		 * unmodifiableList1);
		 * 
		 * unmodifiableList.add("cc");
		 * System.out.println("unmodifiableList add a item after list:" +
		 * unmodifiableList);
		 */
	}
}
