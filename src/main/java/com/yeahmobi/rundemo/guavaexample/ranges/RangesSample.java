package com.yeahmobi.rundemo.guavaexample.ranges;

import java.util.Arrays;

import com.google.common.collect.BoundType;
import com.google.common.collect.Ranges;

import static com.yeahmobi.rundemo.guavaexample.utils.PrintUtils.*;
/**
 * @rundemo_name 区间Range<C>
 * @desc  Guava 一个强大的API，提供Comparable类型的范围处理，包括连续和离散的情况。
 * @author root
 *
 */
public class RangesSample {

	public static void main(String[] args) {
		//1.构建区间
		Ranges.open(1, 6);//开区间(1,6)
		Ranges.closed(1, 6);//闭区间[1,6]
		Ranges.openClosed(1, 6);//左开右闭区间(1,6]
		Ranges.closedOpen(1, 6);//左闭右开区间[1,6)
		Ranges.greaterThan(8);//(8,+∞)
		Ranges.atLeast(8);//[8,+∞)
		Ranges.lessThan(8);//(-∞,8)
		Ranges.atMost(8);//(-∞,8]
		Ranges.all();//(-∞,+∞)
		Ranges.closed("left", "right"); //字典序在"left"和"right"之间的字符串，闭区间
		Ranges.lessThan(4.0); //严格小于4.0的double值
		
		dividingLine();
		//2.明确地指定边界类型来构造区间：
		//2.1 有界区间
		Ranges.range("a", BoundType.CLOSED, "e", BoundType.OPEN);//[a,e)
		//2.2 无上界区间：((a..+∞) 或[a..+∞))
		Ranges.downTo(6, BoundType.OPEN);
		//2.3 无下界区间：((-∞..b) 或(-∞..b])
		Ranges.upTo(6, BoundType.CLOSED);
		dividingLine();
		//3. 区间运算
		//3.1 contains(C)方法用来区间判断是否包含某个值
		boolean res = Ranges.closed(1, 3).contains(2);//return true
		print("Ranges.closed(1, 3).contains(2)", res);
		res = Ranges.closed(1, 3).contains(4);//return false
		print("Ranges.closed(1, 3).contains(4)", res);
		res = Ranges.lessThan(5).contains(5); //return false
		print("Ranges.lessThan(5).contains(5)", res);
		res = Ranges.closed(1, 4).containsAll(Arrays.asList(1, 2, 3)); //return true
		print("Ranges.closed(1, 4).containsAll(Arrays.asList(1, 2, 3))", res);
		
		dividingLine();
		//3.2 查询运算
		/**
		 * Ranges类提供了以下方法来查看区间的端点：
		 * hasLowerBound()和hasUpperBound()：判断区间是否有特定边界，或是无限的；
		 * lowerBoundType()和upperBoundType()：返回区间边界类型，CLOSED或OPEN；如果区间没有对应的边界，抛出IllegalStateException；
		 * lowerEndpoint()和upperEndpoint()：返回区间的端点值；如果区间没有对应的边界，抛出IllegalStateException；
		 * isEmpty();//判断是否为空区间。
		 * */
		boolean res1 = Ranges.closedOpen(4, 4).isEmpty(); // returns true
		print("Ranges.closedOpen(4, 4).isEmpty()", res1);
		res1 = Ranges.openClosed(4, 4).isEmpty(); // returns true
		print("anges.openClosed(4, 4).isEmpty()", res1);
		res1 = Ranges.closed(4, 4).isEmpty(); // returns false
		print("Ranges.closed(4, 4).isEmpty()", res1);
		
		Integer res2 = Ranges.closed(3, 10).lowerEndpoint(); // returns 3
		print("Ranges.closed(3, 10).lowerEndpoint()", res2);
		res2 = Ranges.open(3, 10).lowerEndpoint(); // returns 3
		print("Ranges.open(3, 10).lowerEndpoint()", res2);
		BoundType res3 = Ranges.closed(3, 10).lowerBoundType(); // returns CLOSED
		print("Ranges.closed(3, 10).lowerBoundType()", res3);
		res3 = Ranges.open(3, 10).upperBoundType(); // returns OPEN
		print("Ranges.open(3, 10).upperBoundType()", res3);
		
		res1 = Ranges.open(4, 4).isEmpty(); // Range.open throws IllegalArgumentException
		print("Ranges.open(4, 4).isEmpty()", res1);

		//3.3 关系运算
		//3.3.1 包含 [encloses(Range)]：如果内区间的边界没有超出外区间的边界，则外区间包含内区间。包含判断的结果完全取决于区间端点的比较！
		Ranges.closed(3, 5).encloses(Ranges.open(5, 10)); // returns false
		Ranges.closed(0, 9).encloses(Ranges.closed(3, 4)); // returns true
		//3.3.2 相连 Ranges.isConnected(Range)判断区间是否是相连的。具体来说，isConnected测试是否有区间同时包含于这两个区间，这等同于数学上的定义”两个区间的并集是连续集合的形式”（空区间的特殊情况除外）。
		Ranges.closed(3, 5).isConnected(Ranges.open(5, 10)); // returns true
		Ranges.closed(0, 9).isConnected(Ranges.closed(3, 4)); // returns true
		Ranges.closed(0, 5).isConnected(Ranges.closed(3, 9)); // returns true
		Ranges.open(3, 5).isConnected(Ranges.open(5, 10)); // returns false
		Ranges.closed(1, 5).isConnected(Ranges.closed(6, 10)); // returns false

		//3.3.3 交集 Ranges.intersection(Range)返回两个区间的交集：既包含于第一个区间，又包含于另一个区间的最大区间。当且仅当两个区间是相连的，它们才有交集。如果两个区间没有交集，该方法将抛出IllegalArgumentException。
		Ranges.closed(3, 5).intersection(Ranges.open(5, 10)); // returns (5, 5]
		Ranges.closed(0, 9).intersection(Ranges.closed(3, 4)); // returns [3, 4]
		Ranges.closed(0, 5).intersection(Ranges.closed(3, 9)); // returns [3, 5]
		Ranges.open(3, 5).intersection(Ranges.open(5, 10)); // throws IAE
		Ranges.closed(1, 5).intersection(Ranges.closed(6, 10)); // throws IAE

		//3.3.4 跨区间 Ranges.span(Range)返回”同时包括两个区间的最小区间”，如果两个区间相连，那就是它们的并集。
		Ranges.closed(3, 5).span(Ranges.open(5, 10)); // returns [3, 10)
		Ranges.closed(0, 9).span(Ranges.closed(3, 4)); // returns [0, 9]
		Ranges.closed(0, 5).span(Ranges.closed(3, 9)); // returns [0, 9]
		Ranges.open(3, 5).span(Ranges.open(5, 10)); // returns (3, 10)
		Ranges.closed(1, 5).span(Ranges.closed(6, 10)); // returns [1, 10]

		
	}

}
