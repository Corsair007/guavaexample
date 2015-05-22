package com.yeahmobi.rundemo.guavaexample.collections.utilityclasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

public class ListsSample {
	public static void main(String[] args) {
		//1.一般情况下，我们创建一个List集合
		List<String> strList1 = new ArrayList<String>();
		strList1.add("1");
		strList1.add("2");
		strList1.add("3");
		
		//2.使用Collections工具类，可以简化
		List<String> strList2 = new ArrayList<String>();
		Collections.addAll(strList2, "1", "2", "3");
		
		//3.使用Guava，可以进一步简化：
		List<String> strList3 = Lists.newArrayList("1", "2", "3");
		System.out.println("strList3: "+ strList3);
		
		//4.List的常用方法
		List<Integer> countUp = Ints.asList(1, 2, 3, 4, 5);
		System.out.println(countUp);
		List<Integer> countDown = Lists.reverse(countUp); // {5, 4, 3, 2, 1}
		System.out.println(countDown);
		List<List<Integer>> parts = Lists.partition(countUp, 2); // {{1, 2}, {3, 4}, {5}}
		System.out.println(parts);
		
		
	}
}
