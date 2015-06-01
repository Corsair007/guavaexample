package com.yeahmobi.rundemo.guavaexample.io;

import static com.yeahmobi.rundemo.guavaexample.utils.PrintUtils.dividingLine;
import static com.yeahmobi.rundemo.guavaexample.utils.PrintUtils.print;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;

public class FileOperateSample {

	public static void main(String[] args) throws IOException {
		//1.向文件中写入字节流
		demoFileWrite("test.txt", "Hello world! I'm testing string!");
		//2.读取刚写入到test.txt中的内容
		readFileContent("test.txt");
		dividingLine();
		//3.从一个大文件中逐行读取文本，并做行号计数
		readBigFileByLines("pom.xml");
		dividingLine();
		//4.文件拷贝
		demoSimpleFileCopy("test.txt", "testTargetFile.txt");
		readFileContent("testTargetFile.txt");
		dividingLine();
		//5.来比较两个文件的内容
		demoEqual("test.txt", "testTargetFile.txt");
		demoEqual("test.txt", "pom.xml");
		
		/**
		 * 6. 其他有用的方法
		 * 
		 * Guava的Files类中还提供了其他一些文件的简捷方法。比如
		 * 
		 * touch方法创建或者更新文件的时间戳。 
		 * createTempDir()方法创建临时目录 
		 * Files.createParentDirs(File)创建父级目录 
		 * getChecksum(File)获得文件的
		 * checksum hash(File)获得文件的hash
		 * map系列方法获得文件的内存映射 
		 * getFileExtension(String)获得文件的扩展名
		 * getNameWithoutExtension(String file)获得不带扩展名的文件名
		 */
		dividingLine();
		print("获得文件的扩展名", Files.getFileExtension("pom.xml"));
	}

	/**
	 * 1.演示向文件中写入字节流
	 * 
	 * @param fileName
	 *            要写入文件的文件名
	 * @param contents
	 *            要写入的文件内容
	 */
	public static void demoFileWrite(final String fileName, final String contents) {
		Preconditions.checkNotNull(fileName,
				"Provided file name for writing must NOT be null.");
		Preconditions.checkNotNull(contents, "Unable to write null contents.");
		final File newFile = new File(fileName);
		try {
			Files.write(contents.getBytes(), newFile);
		} catch (IOException e) {
			System.err.println("ERROR trying to write to file '" + fileName
					+ "' - " + e.toString());
		}

	}

	/**
	 * 2. 获取文件内容
	 * Files类提供了readLines方法可以方便的读取文件的内容,注意这里的readLines方法返回的是List<String>的接口
	 * ，这对于大文件处理是会有问题的。 大文件处理可以使用readLines方法的另一个重载。
	 */
	public static void readFileContent(String testFilePath) {
		File testFile = new File(testFilePath);
		List<String> lines = null;
		try {
			lines = Files.readLines(testFile, Charsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i=0; i<lines.size(); i++) {
			print(testFilePath+" 第"+(i+1)+"行", lines);
		}
	}

	/**
	 *3. 从一个大文件中逐行读取文本，并做行号计数。
	 * 
	 * @throws IOException
	 */
	public static void readBigFileByLines(String testFilePath) throws IOException {
		File testFile = new File(testFilePath);
		CounterLine counter = new CounterLine();
		Files.readLines(testFile, Charsets.UTF_8, counter);
		System.out.println(counter.getResult());
	}

	/**
	 * 这个readLines的重载，需要我们实现一个LineProcessor的泛型接口，
	 * 在这个接口的实现方法processLine方法中我们可以对行文本进行处理
	 * ，getResult方法可以获得一个最终的处理结果，这里我们只是简单的返回了一个行计数。
	 */
	static class CounterLine implements LineProcessor<Integer> {
		private int rowNum = 0;

		public boolean processLine(String line) throws IOException {
			print("第"+rowNum+"行", line);
			rowNum++;
			return true;
		}

		public Integer getResult() {
			return rowNum;
		}
	}

	/**
	 * 4.演示如何使用guava的Files.copy方法复制文件
	 * 
	 * @param sourceFileName
	 *            复制的源文件名
	 * @param targetFileName
	 *            目标文件名
	 */
	public static void demoSimpleFileCopy(final String sourceFileName,
			final String targetFileName) {
		Preconditions.checkNotNull(sourceFileName,
				"Copy source file name must NOT be null.");
		Preconditions.checkNotNull(targetFileName,
				"Copy target file name must NOT be null.");
		final File sourceFile = new File(sourceFileName);
		final File targetFile = new File(targetFileName);
		try {
			Files.copy(sourceFile, targetFile);
		} catch (IOException fileIoEx) {
			System.err.println("ERROR trying to copy file '" + sourceFileName
					+ "' to file '" + targetFileName + "' - "
					+ fileIoEx.toString());
		}
	}

	/**
	 * 5.演示 Files.equal(File,File) 来比较两个文件的内容
	 * 
	 * @param fileName1
	 *            比较的文件1文件名
	 * @param fileName2
	 *            比较的文件2文件名
	 */
	public static void demoEqual(final String fileName1, final String fileName2) {
		Preconditions.checkNotNull(fileName1,
				"First file name for comparison must NOT be null.");
		Preconditions.checkNotNull(fileName2,
				"Second file name for comparison must NOT be null.");
		final File file1 = new File(fileName1);
		final File file2 = new File(fileName2);
		try {
			System.out.println("File '" + fileName1 + "' "
					+ (Files.equal(file1, file2) ? "IS" : "is NOT")
					+ " the same as file '" + fileName2 + "'.");
		} catch (IOException fileIoEx) {
			System.err.println("ERROR trying to compare two files '"
					+ fileName1 + "' and '" + fileName2 + "' - "
					+ fileIoEx.toString());
		}
	}
	
}
