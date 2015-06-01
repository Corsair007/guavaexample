package com.yeahmobi.rundemo.guavaexample.primitives;



/**
 * @rundemo_name 原生类型Primitives
 * @desc 扩展 JDK 未提供的原生类型（如int、char）操作，包括某些类型的无符号形式
 * @author root
 */
public class PrimitivesSample {

	/**
	 * 4.1 Booleans： 
	 * hashCode(boolean value)：返回 value的哈希码，与 (Boolean)value.hashCode()返回值相同， true的哈希码是 1231， false的哈希码是 1237。
	 * compare(boolean a, boolean b)：如果 a和 b相等返回 0，否则 true比 false大，即如果 a是 true，b是 false，则返回 1，否则返回 -1。 
	 * contains(boolean[] array, boolean target)：省略 n字。
	 * indexOf(...)：省略 n字。 lastIndexOf(...)：省略 n字。
	 * concat(boolean[]...)：将参数中的多个数组按顺序合为一个数组。 
	 * ensureCapacity(boolean[] array, int minLength, int padding)：如果 array的长度大于或等于 minLength，则返回 array，否则新建一个长度为 minLength+padding的数组，将 array复制到该数组，并返回该数组。
	 * join(String separator, boolean... array)：返回字符串。 
	 * lexicographicalComparator()：返回一个 Comparator()，该比较器比较两个 boolean数组。 
	 * toArray(Collection<Boolean> collection)：将 collection转换为数组，返回数组。 asList(boolean... backingArray)：将参数作为List<Boolean>返回。
	 * 
	 * 4.2 Bytes：接口与 Booleans类似。 
	 * 
	 * 4.3 Chars：接口与 Booleans类似。
	 * 增加了 int型的静态常量 BYTES，值为
	 * Character. SIZE / Byte. SIZE ，一般情况下是 2。
	 * 增加的静态方法有： checkCase(long value)：返回 value代表的字符，如果 value超出字符范围，则抛出异常。 
	 * saturatedCase(long value)：如果 value小于 Character.MIN_VALUE，则返回 Character. MIN_VALUE，如果 value大于
	 * Character.MAX_VALUE，则返回 Character.MAX_VALUE，否则返回 value所表示的字符。 
	 * min(char... array)：返回 array中最小的字符。 max(char... array)：返回 array中最大的字符。
	 * toByteArray(char value)：将 value转换为 byte数组，高位作为数组的第一个元素，地位作为数组的第二个元素。例如：
	 * toByteArray('\\u5432')返回 {0x54, 0x32}。 
	 * fromByteArray(byte[] bytes)：将 bytes转换为字符，与上面的方法相反。 
	 * fromBytes(byte b1, byte b2)：将 b1和 b2转换为字符。
	 * 
	 *  4.4 Doubles：接口与前面的几个类相似。
	 *  4.5 Floats：接口与前面的几个类相似。 
	 *  4.6 Ints：接口和常量与 Chars类似。 
	 *  4.7 Longs：接口和常量与 Chars类似。 
	 *  4.8 Shorts：接口和常量与 Chars类似。 
	 *  4.9 SignedBytes：接口与 Chars类似。 
	 *  4.10 UnsignedBytes：接口与 Chars类似。增加了 toInt(byte value)静态方法。 
	 *  
	 *  4.11 Primitives：提供了原始类和包装类相互转换的工具方法。 静态方法： 
	 *  allPrimitiveTypes()：返回 Set<Class<?>>，获取所有的原始类型。 
	 *  allWrapperTypes()：返回 Set<Class<?>>，获取所有的包装类型。
	 *  isWrapperType(Class<?> type)：判断 type是否是包装类型。 
	 *  wrap(Class<?> type)：返回 type的包装类型。 
	 *  unWrap(Class<?> type)：返回 type的原始类型。
	 * 
	 */
	public static void main(String[] args) {
		//TODO DIY
		//参看 http://guava-libraries.googlecode.com/svn/tags/release09/javadoc/index.html
	}

}
