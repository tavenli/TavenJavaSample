package com.taven.app.javabase.io;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.Scanner;

public class RedirectIO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		redirectSystemOut();

		redirectSystemIn();

	}

	/**
	 * 重定向输出流
	 */
	private static void redirectSystemOut() {

		PrintStream printStream = null;
		try {

			printStream = new PrintStream(new FileOutputStream("d:\\test.txt"));

			//设置系统的输出流为 PrintStream
			System.setOut(printStream);

			//以下内容不会在控制台显示，而是直接写入到文件中了
			System.out.println("重定向输入/输出流");

			System.out.println(new Date());

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (printStream != null) {
				printStream.close();
			}
		}

	}

	/**
	 * 重定向输入流
	 */
	private static void redirectSystemIn() {

		try {
			FileInputStream fis = new FileInputStream("d:\\test.txt");
			//输入流被设置重定向后，System.in 为 FileInputStream 了
			System.setIn(fis);

			//如果要让控制台输出信息，要将输出流改回来
			System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

			Scanner scanner = new Scanner(System.in);
			scanner.useDelimiter("\n");

			//Scanner 会输出 text.txt 中的文件内容
			while (scanner.hasNext()) {

				System.out.println("输出：" + scanner.next());

			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
