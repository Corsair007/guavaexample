package com.yeahmobi.rundemo.guavaexample.collections.utilityclasses;

import static com.yeahmobi.rundemo.guavaexample.utils.PrintUtils.dividingLine;
import static com.yeahmobi.rundemo.guavaexample.utils.PrintUtils.print;

import java.util.Map;

import com.google.common.base.Function;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.TreeMultimap;
import com.google.common.primitives.Ints;

/**
 * @rundemo_name 集合工具类之Multimaps用法
 * @author root
 *
 */
public class MultimapsSample {
	public static void main(String[] args) {
		/**
		 * 1.Multimaps.index(Iterable, Function)
		 * 通常针对的场景是：有一组对象，它们有共同的特定属性，我们希望按照这个属性的值查询对象，但属性值不一定是独一无二的。
		 * 
		 * 比方说，我们想把字符串按长度分组。
		 */
		ImmutableSet<String> digits = ImmutableSet.of("zero", "one", "two",
				"three", "four", "five", "six", "seven", "eight", "nine");
		Function<String, Integer> lengthFunction = new Function<String, Integer>() {
			public Integer apply(String string) {
				return string.length();
			}
		};
		ImmutableListMultimap<Integer, String> digitsByLength = Multimaps
				.index(digits, lengthFunction);
		print("Multimaps.index(digits, lengthFunction)", digitsByLength);
		/*
		 * digitsByLength maps: 
		 * 3 => {"one", "two", "six"} 
		 * 4 => {"zero", "four","five", "nine"} 
		 * 5 => {"three", "seven", "eight"}
		 */
		dividingLine();

		//2.鉴于Multimap可以把多个键映射到同一个值（译者注：实际上这是任何map都有的特性），也可以把一个键映射到多个值，反转Multimap也会很有用。Guava 提供了invertFrom(Multimap toInvert,
		//Multimap dest)做这个操作，并且你可以自由选择反转后的Multimap实现。
		ArrayListMultimap<String, Integer> multimap = ArrayListMultimap
				.create();
		multimap.putAll("b", Ints.asList(2, 4, 6));
		multimap.putAll("a", Ints.asList(4, 2, 1));
		multimap.putAll("c", Ints.asList(2, 5, 3));
		TreeMultimap<Integer,String> treemap = TreeMultimap.create();
		TreeMultimap<Integer, String> inverse = Multimaps.invertFrom(multimap, treemap);
		print("Multimaps.invertFrom(multimap, map)", inverse);
		// we get results in order
		/*
		 * inverse maps: 
		 * 1 => {"a"} 
		 * 2 => {"a", "b", "c"} 
		 * 3 => {"c"} 
		 * 4 => {"a", "b"} 
		 * 5 => {"c"} 
		 * 6 => {"b"}
		 */
		
		//3.forMap(Map)把Map包装成SetMultimap。这个方法特别有用，例如，与Multimaps.invertFrom结合使用，可以把多对一的Map反转为一对多的Multimap。
		Map<String, Integer> map = ImmutableMap.of("a", 1, "b", 1, "c", 2);
		SetMultimap<String, Integer> setMultimap = Multimaps.forMap(map);
		print("Multimaps.forMap(map)", setMultimap);
		// multimap：["a" => {1}, "b" => {1}, "c" => {2}]
		HashMultimap<Integer, String> hashMultimap = HashMultimap.create();
		Multimap<Integer, String> inverse2 = Multimaps.invertFrom(setMultimap, hashMultimap);
		print("Multimaps.invertFrom(setMultimap, hashMultimap)", inverse2);
		// inverse：[1 => {"a","b"}, 2 => {"c"}]

	}
}
