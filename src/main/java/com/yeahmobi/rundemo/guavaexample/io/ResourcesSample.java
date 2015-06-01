package com.yeahmobi.rundemo.guavaexample.io;

import static com.yeahmobi.rundemo.guavaexample.utils.PrintUtils.dividingLine;
import static com.yeahmobi.rundemo.guavaexample.utils.PrintUtils.print;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.io.Closeables;
import com.google.common.io.Files;
import com.google.common.io.Resources;

/**
 * @rundemo_name 资源操作Resources
 * @desc Resources提供操作classpath路径下所有资源的方法。除非另有说明，否则类中所有方法的参数都不能为null。
 * @link http://docs.guava-libraries.googlecode.com/git/javadoc/com/google/common/io/Resources.html
 * @author root
 *
 */
public class ResourcesSample {

	public static void main(String[] args) throws IOException {

		URL url = Resources.getResource("test.properties");
		// 读出文件内容
		String content = Resources.toString(url, Charsets.UTF_8);
		print("test.properties内容为", content);
		dividingLine();
		// 按行读取
		List<String> lines = Resources.readLines(url, Charsets.UTF_8);
		for (int i = 0; i < lines.size(); i++) {
			print("第" + (i + 1) + "行", lines.get(i));
		}
		// byte[] content = Resources.toByteArray(url);//如果是一个二进制文件,
		// 可以用Resources.toByteArray():
		dividingLine();
		// Copies all bytes from a URL to an output stream.
		OutputStream outputStream = new FileOutputStream("testCopy.txt");
		Resources.copy(url, outputStream);
		Closeables.closeQuietly(outputStream);
		print("testCopy.txt内容为", Files.readLines(new File("testCopy.txt"),
				Charsets.UTF_8));

	}

}
