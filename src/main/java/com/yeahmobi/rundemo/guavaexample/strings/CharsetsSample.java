package com.yeahmobi.rundemo.guavaexample.strings;

import com.google.common.base.CaseFormat;
import com.google.common.base.Charsets;


public class CharsetsSample {
	public static void main(String[] args) {
		//字符格式
		String string = "123abc 456 -- jkl";
		byte[] bytes = string.getBytes(Charsets.UTF_8);
		
		String result = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "CONSTANT_NAME"); // returns "constantName"
		System.out.println(result);
	}
}
