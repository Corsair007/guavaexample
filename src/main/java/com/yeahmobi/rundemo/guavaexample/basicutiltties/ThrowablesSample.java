package com.yeahmobi.rundemo.guavaexample.basicutiltties;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import com.google.common.base.Throwables;

/**
 * @rundemo_name 异常处理
 * @desc Guava提供的一个异常处理工具类, 可以简单地捕获和重新抛出多个异常
 * @author root
 */
public class ThrowablesSample {
	public static void main(String[] args) throws Exception {
		/*
		 * 传递异常的常用方法：
		 * 
		 * 1.RuntimeException propagate(Throwable)：把throwable包装成RuntimeException，用该方法保证异常传递，抛出一个RuntimeException异常 　　
		 * 2.void propagateIfInstanceOf(Throwable, Class<X extends Exception>) throws X：当且仅当它是一个X的实例时，传递throwable 　　
		 * 3.void propagateIfPossible(Throwable)：当且仅当它是一个RuntimeException和Error时，传递throwable 　　
		 * 4.void propagateIfPossible(Throwable, Class<X extends Throwable>) throws X：当且仅当它是一个RuntimeException和Error时，或者是一个X的实例时，传递throwable。
		 * 
		 * 实例如下：
		 */
		testThrowables();
		//call();
		//testCheckException();
	}

	public static void testThrowables() {
		try {
			throw new Exception();
		} catch (Throwable t) {
			String ss = Throwables.getStackTraceAsString(t);
			System.out.println("ErrorMsg:" + ss);
			Throwables.propagate(t);
		}
	}

	public static void call() throws IOException {
		try {
			throw new IOException();
		} catch (Throwable t) {
			Throwables.propagateIfInstanceOf(t, IOException.class);
			throw Throwables.propagate(t);
		}
	}

	// 将检查异常转换成未检查异常
	public static void testCheckException() {
		try {
			URL url = new URL("http://www.baidu.com");
			final InputStream in = url.openStream();
			// read from the input stream
			in.close();
		} catch (Throwable t) {
			throw Throwables.propagate(t);
		}
	}
}
