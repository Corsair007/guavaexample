package com.yeahmobi.rundemo.guavaexample.strings;

import java.util.Arrays;

import com.google.common.base.Joiner;

/**
 * @rundemo_name 字符串拼接
 * @author root
 *
 */
public class JoinerSample {
	public static void main(String[] args) {
		
		String result1 = Joiner.on("; ").skipNulls().join("Harry", null, "Ron", "Hermione");
		System.out.println(result1);

		String result2 = Joiner.on(",").join(Arrays.asList(1, 5, 7)); // returns "1,5,7"
		System.out.println(result2);
	}
}
