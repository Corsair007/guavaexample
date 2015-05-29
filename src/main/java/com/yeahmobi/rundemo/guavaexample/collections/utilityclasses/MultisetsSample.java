package com.yeahmobi.rundemo.guavaexample.collections.utilityclasses;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;

import static com.yeahmobi.rundemo.guavaexample.utils.PrintUtils.*;


/**
 * @rundemo_name 集合工具类之Multisets用法
 * @author root
 *
 */
public class MultisetsSample {
	public static void main(String[] args) {
		Multiset<String> multiset1 = HashMultiset.create();
		multiset1.add("a", 2);

		Multiset<String> multiset2 = HashMultiset.create();
		multiset2.add("a", 5);

		print("multiset1.containsAll(multiset2)", multiset1.containsAll(multiset2)); 
		
		//containsOccurrences(Multiset super, Multiset sub)	对任意o，如果sub.count(o)<=super.count(o)，返回true
		System.out.println(multiset1.count("a")+"----"+multiset2.count("a"));
		print("Multisets.containsOccurrences(multiset1, multiset2)", Multisets.containsOccurrences(multiset1, multiset2)); // returns false

		//removeOccurrences(Multiset  removeFrom, Multiset toRemove)	对toRemove中的重复元素，仅在removeFrom中删除相同个数。
		print("Multisets.removeOccurrences(multiset2, multiset1)", Multisets.removeOccurrences(multiset2, multiset1)); // multiset2 now contains 3 occurrences of "a"
		print("multiset2", multiset2);
		dividingLine();
		//retainOccurrences(Multiset removeFrom, Multiset toRetain)	修改removeFrom，以保证任意o都符合removeFrom.count(o)<=toRetain.count(o)
		Multisets.retainOccurrences(multiset2, multiset1);
		print("multiset2", multiset2);
		
		//intersection(Multiset,   Multiset)	返回两个multiset的交集;
		multiset1.add("abc");
		multiset1.add("abc1");
		multiset1.add("abc2");
		
		multiset2.add("cba");
		multiset2.add("abc1");
		multiset2.add("abc2");
		print("Multisets.intersection(multiset1, multiset2)", Multisets.intersection(multiset1, multiset2));;
		
		//copyHighestCountFirst(Multiset)	返回Multiset的不可变拷贝，并将元素按重复出现的次数做降序排列
		Multiset<String> multiset = HashMultiset.create();
		multiset.add("a", 3);
		multiset.add("b", 5);
		multiset.add("c", 1);
		@SuppressWarnings("rawtypes")
		ImmutableMultiset highestCountFirst = Multisets.copyHighestCountFirst(multiset);
		print("highestCountFirst", highestCountFirst);
		//highestCountFirst，包括它的entrySet和elementSet，按{"b", "a", "c"}排列元素

		multiset2.removeAll(multiset1); // removes all occurrences of "a" from multiset2, even though multiset1.count("a") == 2
		multiset2.isEmpty(); // returns true
	}
}
