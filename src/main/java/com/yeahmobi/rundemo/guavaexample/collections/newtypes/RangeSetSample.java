package com.yeahmobi.rundemo.guavaexample.collections.newtypes;


/**
 * @rundemo_name 新集合之RangeSet
 *               RangeSet用来处理一系列不连续，非空的range。当添加一个range到一个RangeSet之后，
 *                 任何有连续的range将被自动合并，而空的range将被自动去除。
 * @author root
 *
 */
public class RangeSetSample {

	public static void main(String[] args) {
		/*RangeSet<Integer> rangeSet = TreeRangeSet.create();
		rangeSet.add(Range.closed(1, 10));
		System.out.println("rangeSet:" + rangeSet);
		rangeSet.add(Range.closedOpen(11, 15));
		System.out.println("rangeSet:" + rangeSet);
		rangeSet.add(Range.open(15, 20));
		System.out.println("rangeSet:" + rangeSet);
		rangeSet.add(Range.openClosed(0, 0));
		System.out.println("rangeSet:" + rangeSet);
		rangeSet.remove(Range.open(5, 10));
		System.out.println("rangeSet:" + rangeSet);*/
	}

}
