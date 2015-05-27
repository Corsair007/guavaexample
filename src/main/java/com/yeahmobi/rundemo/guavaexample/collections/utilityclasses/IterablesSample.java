package com.yeahmobi.rundemo.guavaexample.collections.utilityclasses;

import static com.yeahmobi.rundemo.guavaexample.utils.PrintUtils.print;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Iterables;
import com.google.common.primitives.Ints;

/**
 * @rundemo_name 支持所有集合的Iterables工具类
 * @author root
 *
 */
public class IterablesSample {

	@SuppressWarnings({ "unchecked", "rawtypes"})
	public static void main(String[] args) {
		//1.连接若干个list
		Iterable<Integer> concatenated = Iterables.concat(
		Ints.asList(1, 2, 4),
		Ints.asList(4, 5, 6, 7, 8, 9));
		// concatenated has elements 1, 2, 4, 4, 5, 6
		print("concatenated内容", concatenated);
		
		//2.返回concatenated中4出现的次数，这里是2次
		int count = Iterables.frequency(concatenated, 4);
		print("concatenated中4出现的次数", count);
		
		//3.partitioning an iterable containing [a, b, c, d, e] with a partition size of 3 yields [[a, b, c], [d, e]]
		Iterable<List<Integer>> listIterable = Iterables.partition(concatenated, 4);
		print("partition结果", listIterable);
		
		//4.返回concatenated中的第一个元素，如果concatenated为空，则默认返回0
		Integer first = Iterables.getFirst(concatenated, 0);
		print("getFirst结果1", first);
		first = Iterables.getFirst(Iterables.concat(new ArrayList()), 0);
		print("getFirst结果2", first);
		
		//5.返回concatenated中的最后一个元素，如果concatenated为空，则默认返回-1
		Integer last = Iterables.getLast(concatenated, -1);
		print("getLast结果1", last);
		last = Iterables.getFirst(Iterables.concat(new ArrayList()), -1);
		print("getLast结果2", last);
		
		//6.判断两个iterable中的元素是否相等
		boolean isEqual = Iterables.elementsEqual(concatenated, concatenated);
		print("elementsEqual结果1", isEqual);
		isEqual = Iterables.elementsEqual(concatenated, Iterables.concat(Ints.asList(4, 5, 6, 7, 8, 9)));
		print("elementsEqual结果2", isEqual);
		
	}
	
}