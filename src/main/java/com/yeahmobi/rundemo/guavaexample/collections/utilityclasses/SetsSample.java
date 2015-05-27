package com.yeahmobi.rundemo.guavaexample.collections.utilityclasses;

import static com.yeahmobi.rundemo.guavaexample.utils.PrintUtils.print;

import java.util.List;
import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

/**
 * @rundemo_name Sets用法
 * @author root
 *
 */
public class SetsSample {
	public static void main(String[] args) {
		
		Set<String> set1 = Sets.newHashSet("202","111","33","44","5","5");
		Set<String> set2 = Sets.newHashSet("101","202","303","44");
		//1.集合的合并
		SetView<String> union = Sets.union(set1, set2);
		print("union结果", union.immutableCopy());
		
		//2.返回set1中与set2不同的元素集合
		SetView<String> difference = Sets.difference(set1, set2);
		print("difference结果", difference.immutableCopy());
		
		//3.返回set1和set2中所有不同的元素
		SetView<String> symmetricDifference = Sets.symmetricDifference(set1, set2);
		print("symmetricDifference结果", symmetricDifference.immutableCopy());
		
		Set<String> wordsWithPrimeLength = ImmutableSet.of("one", "two", "three", "six", "seven", "eight");
		Set<String> primes = ImmutableSet.of("two", "three", "five", "seven");

		//4.返回两集合中共同存在的元素
		SetView<String> intersection = Sets.intersection(primes, wordsWithPrimeLength); // contains "two", "three", "seven"
		// I can use intersection as a Set directly, but copying it can be more efficient if I use it a lot.
		print("intersection结果", intersection.immutableCopy());
		
		Set<String> animals = ImmutableSet.of("gerbil", "hamster");
		Set<String> fruits = ImmutableSet.of("apple", "orange", "banana");
		//5.返回两集合的笛卡尔集
		@SuppressWarnings("unchecked")
		Set<List<String>> product = Sets.cartesianProduct(animals, fruits);
		print("cartesianProduct结果", product);
		//6.返回集合的所有子集
		Set<Set<String>> animalSets = Sets.powerSet(animals);
		print("powerSet结果", animalSets);
	}
}
