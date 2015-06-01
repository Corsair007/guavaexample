package com.yeahmobi.rundemo.guavaexample.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.google.common.io.Closeables;

/**
 * @rundemo_name 关闭资源
 * @author root
 *
 */
public class CloseablesSample {

	public static void main(String[] args) throws FileNotFoundException {
		InputStream in = new FileInputStream("test.txt");
		OutputStream out = new FileOutputStream("out.txt");
		Closeables.closeQuietly(in);
		Closeables.closeQuietly(out);
	}
}
