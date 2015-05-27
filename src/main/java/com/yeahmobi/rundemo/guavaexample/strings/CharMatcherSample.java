package com.yeahmobi.rundemo.guavaexample.strings;

import com.google.common.base.CharMatcher;

/**
 * @rundemo_name 字符匹配器
 * @author root
 *
 */
public class CharMatcherSample {
	public static void main(String[] args) {
		String string = "123abc 456 -- jkl";
		
		//1. remove control characters
		String noControl = CharMatcher.JAVA_ISO_CONTROL.removeFrom(string); 
		System.out.println("CharMatcher.JAVA_ISO_CONTROL.removeFrom:                             "+ noControl);
		
		//2. only the digits
		String theDigits = CharMatcher.DIGIT.retainFrom(string);
		System.out.println("CharMatcher.DIGIT.retainFrom:                                        "+ theDigits);
		
		//3. trim whitespace at ends, and replace/collapse whitespace into single spaces
		String spaced = CharMatcher.WHITESPACE.trimAndCollapseFrom(string, ' ');
		System.out.println("CharMatcher.WHITESPACE.trimAndCollapseFrom:                          "+ spaced);
		
		//4. star out all digits
		String noDigits = CharMatcher.JAVA_DIGIT.replaceFrom(string, "*"); 
		System.out.println("CharMatcher.JAVA_DIGIT.replaceFrom:                                  "+ noDigits);
		
		//5. eliminate all characters that aren't digits or lowercase
		String lowerAndDigit = CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom(string);
		System.out.println("CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom:   "+ lowerAndDigit);
		/**
		 * print result:
		 * 
		 * 1.CharMatcher.JAVA_ISO_CONTROL.removeFrom:                             123abc 456 -- jkl
		 * 2.CharMatcher.DIGIT.retainFrom:                                        123456
		 * 3.CharMatcher.WHITESPACE.trimAndCollapseFrom:                          123abc 456 -- jkl
		 * 4.CharMatcher.JAVA_DIGIT.replaceFrom:                                  ***abc *** -- jkl
		 * 5.CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom:   123abc456jkl
		 * 
		*/
	}
}
