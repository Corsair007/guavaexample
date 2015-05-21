package com.yeahmobi.rundemo.guavaexample.strings;

import java.util.Arrays;

import com.google.common.base.Joiner;

public class JoinerSample {
	public static void main(String[] args) {
		//自定义字符串拼接
		
		String result1 = Joiner.on("; ").skipNulls().join("Harry", null, "Ron", "Hermione");
		System.out.println(result1);

		String result2 = Joiner.on(",").join(Arrays.asList(1, 5, 7)); // returns "1,5,7"
		System.out.println(result2);
	}
}
