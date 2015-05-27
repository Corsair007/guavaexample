package com.yeahmobi.rundemo.guavaexample.strings;

import java.util.Iterator;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import static com.yeahmobi.rundemo.guavaexample.utils.PrintUtils.*;

/**
 * @rundemo_name 字符分割器
 * @author root
 *
 */
public class SplitterSample {
	public static void main(String[] args) {
		//1.字符串分割		
		Iterator<String> result1 = Splitter.on(';').split("hello;---  world;  hao123").iterator();
		print(result1);
		
		//2.按逗号分割并剔除空格、剔除空串
		Iterator<String> result2 = Splitter.on(',').trimResults().omitEmptyStrings().split("foo,bar,,   qux").iterator();
		print(result2);
		
		//3.自定义按某几个符号分割
		Iterator<String> result3 = Splitter.on(CharMatcher.anyOf(";,.")).split("foo,bar,;, hello. ni; hao123.  qux").iterator();
		print(result3);
		
		//4.按正则表达式分割
		Iterator<String> result4 = Splitter.onPattern("\r?\n").split("ASD \n 787\r kkk\n").iterator();
		print(result4);
		
		//5.按长度4位截取分割
		Iterator<String> result5 = Splitter.fixedLength(4).split("1234556789009876654432").iterator();
		print(result5);

		//6.到第三个分隔符处停止分割
		Iterator<String> result6 = Splitter.on(',').limit(3).split("a1,b2,c,d,e").iterator();
		print(result6);
		
		//7.
		Iterator<String> result7 = Splitter.on(',').trimResults(CharMatcher.is('_')).split("_a ,_b_ ,c__").iterator();
		print(result7);
	}
	
}
