package com.yeahmobi.rundemo.guavaexample.collections.utilityclasses;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.common.collect.UnmodifiableIterator;

import static com.yeahmobi.rundemo.guavaexample.utils.PrintUtils.*;


/**
 * @rundemo_name Maps用法
 * @author root
 *
 */
public class MapsSample {
	public static void main(String[] args) {
		
		/**
		 * 1.Maps.uniqueIndex(Iterable,Function)
		 * 有一组对象，它们在某个属性上分别有独一无二的值，而我们希望能够按照这个属性值查找对象,
		 * 这个方法返回一个Map，键为Function返回的属性值，值为Iterable中相应的元素，因此我们可以反复用这个Map进行查找操作。
		 */
		//假如，有一堆字符串，这些字符串的长度都是独一无二的，而我们希望能够按照特定长度查找字符串：
		List<String> strings = Lists.newArrayList("hello world!","nice to meet you","ok!Thanks!") ;
		ImmutableMap<Integer, String> stringsByIndex = Maps.uniqueIndex(strings,
		    new Function<String, Integer> () {
		        public Integer apply(String string) {
		            return string.length();
		        }
		    });
		ImmutableSet<Entry<Integer, String>> entrys = stringsByIndex.entrySet();
		UnmodifiableIterator<Entry<Integer, String>> iterators = entrys.iterator();
		while (iterators.hasNext()) {
			Entry<Integer, String> entry = iterators.next();
			print("Key--"+entry.getKey(), entry.getValue());
		}
		dividingLine();
		//2.Maps.difference(Map, Map)用来比较两个Map以获取所有不同点,该方法返回MapDifference对象
		Map<String, Integer> left = ImmutableMap.of("a", 1, "b", 2, "c", 3);
		Map<String, Integer> right = ImmutableMap.of("b", 2, "c", 4, "d", 5);
		MapDifference<String, Integer> diff = Maps.difference(left, right);
		//2.1 entriesInCommon()返回两个Map中都有的映射项，包括匹配的键与值
		print("entriesInCommon结果", diff.entriesInCommon()); // {"b" => 2}
		//2.2 entriesDiffering()返回键相同但值不相同的映射项
		print("entriesDiffering结果", diff.entriesDiffering()); // {"c" => (3, 4)}
		//2.3 entriesOnlyOnLeft()返回键只存在于左边Map的映射项
		print("entriesOnlyOnLeft结果", diff.entriesOnlyOnLeft()); // {"a" => 1}
		//2.4 entriesOnlyOnRight()返回键只存在于右边Map的映射项
		print("entriesOnlyOnRight结果", diff.entriesOnlyOnRight()); // {"d" => 5}
	}
}
