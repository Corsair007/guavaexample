package com.yeahmobi.rundemo.guavaexample.reflection;

import static com.yeahmobi.rundemo.guavaexample.utils.PrintUtils.dividingLine;
import static com.yeahmobi.rundemo.guavaexample.utils.PrintUtils.print;

import java.util.ArrayList;

import com.google.common.collect.Lists;
import com.google.common.reflect.TypeToken;

/**
 * @rundemo_name TypeToken解决泛型运行时类型擦除的问题
 * @author root
 *
 */
public class TypeTokenSample {

	public static void main(String[] args) {
		// 1.用一个例子来说明什么是类型擦除
		// 下面声明了两个泛型的ArrayList类型，一个泛型的类型参数是String，另外一个是Integer；然后输出了两个泛型的Class，并输出两个list的类型是否是同一个list。
		ArrayList<String> stringList = Lists.newArrayList();
		ArrayList<Integer> intList = Lists.newArrayList();
		print("intList type is ", intList.getClass());
		print("stringList type is ", stringList.getClass());
		print("stringList.getClass().isAssignableFrom(intList.getClass())",
				stringList.getClass().isAssignableFrom(intList.getClass()));
		// 输出结果：
		// 前两个输出都是java.util.ArrayList，而第三个输出竟然是true，
		// 也就是认为stringList和intList的类型是一样的。这就是所谓的泛型类型擦除。
		// 运行时我们不知道泛型类型的类型参数是什么了。
		dividingLine();

		// 2. TypeToken可以解决这个问题，请看下面代码：
		@SuppressWarnings("serial")
		TypeToken<ArrayList<String>> typeToken = new TypeToken<ArrayList<String>>() {
		};
		TypeToken<?> genericTypeToken = typeToken.resolveType(ArrayList.class
				.getTypeParameters()[0]);
		print("ArrayList<String>的泛型类型为", genericTypeToken.getType());
		System.out.println(genericTypeToken.getRawType());
		// 上面第一行代码使用了一个空的匿名类。第二行使用了resolveType方法解析出泛型类型，第三行代码打印出泛型类型
		/**
		 * TypeToken的其他方法如下：
		 * 
		 * getRawType() 返回大家熟知的运行时类 
		 * getSubtype(Class<?>) 返回那些有特定原始类的子类型。举个例子，如果这有一个Iterable并且参数是List.class，那么返回将是List。
		 * getSupertype(Class<?>) 产生这个类型的超类，这个超类是指定的原始类型。举个例子，如果这是一个Set并且参数是Iterable.class，结果将会是Iterable。 
		 * isAssignableFrom(type) 如果这个类型是 assignable from 指定的类型，并且考虑泛型参数，返回true。
		 * List<? extends Number>是assignable from List，但List没有. getTypes() 返回一个Set，包含了这个所有接口，子类和类是这个类型的类。返回的Set同样提供了classes
		 * ()和interfaces()方法允许你只浏览超类和接口类。 
		 * isArray() 检查某个类型是不是数组，甚至是<? extends A[]>。 
		 * getComponentType() 返回组件类型数组。
		 */
	}

}
