package com.yeahmobi.rundemo.guavaexample.utils;

import java.util.Iterator;

public class PrintUtils {
	
	public static void print(Iterator<String> result){
		System.out.println("-------------------------华丽丽的分割线---------------------------");
		while (result.hasNext()) {
			String string = result.next();
			System.out.println(string);
		}
		System.out.println();
	}
	
	public static void print(String desc, Object result){
		System.out.println(desc + " : " + result);
	}
}
