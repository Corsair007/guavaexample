package com.yeahmobi.rundemo.guavaexample.collections.extensionutils;


public class ForwardingDecoratorsSample {

	/**
	 * @rundemo_name Forwarding装饰器
	 * @desc 针对所有类型的集合接口，Guava都提供了Forwarding抽象类以简化装饰者模式的使用。
	 *       Forwarding抽象类定义了一个抽象方法：delegate()，你可以覆盖这个方法来返回被装饰对象。
	 *       所有其他方法都会直接委托给delegate()。例如说：ForwardingList.get(int)实际上执行了delegate().get(int)。
	 * @param args
	 */
	public static void main(String[] args) {

	}

}