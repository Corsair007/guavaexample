package com.yeahmobi.rundemo.guavaexample.strings;

import java.util.Arrays;

import com.google.common.base.Joiner;

public class JoinerSample {
	public static void main(String[] args) {
		Joiner joiner = Joiner.on("; ").skipNulls();
		String result1 = joiner.join("Harry", null, "Ron", "Hermione");
		System.out.println(result1);

		String result2 = Joiner.on(",").join(Arrays.asList(1, 5, 7)); // returns "1,5,7"
		System.out.println(result2);
	}
}
