package com.yeahmobi.rundemo.guavaexample.strings;

import com.google.common.base.CaseFormat;
import com.google.common.base.Charsets;

/**
 * @rundemo_name 字符集操作
 * @author root
 *
 */
public class CharsetsSample {
	public static void main(String[] args) {
		//Charsets有很多字符格式，如：UTF_8, UTF_16, UTF_16LE, UTF_16BE, ISO_8859_1, US_ASCII
		String string = "123abc 456 -- jkl";
		string.getBytes(Charsets.UTF_8);
		//CaseFormat大小写格式处理
		String result = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "CONSTANT_NAME"); // returns "constantName"
		System.out.println(result);
	}
}
