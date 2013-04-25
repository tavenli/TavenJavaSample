package com.taven.app.javabase.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileIO {

	private static Log log = LogFactory.getLog(FileIO.class);

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		//分隔连续多个路径字符串的分隔符 就是指“;”
		log.info(File.pathSeparator);
		//分隔同一个路径字符串中的目录 就是指“\”
		log.info(File.separator);
		//缺省默认路径
		log.info(System.getProperty("user.dir"));

		//指定目录下创建一个临时文件，当虚拟机退出时，该临时文件会被删除
		//File.createTempFile(prefix, suffix, directory)

		//实例化一个当前路径的 file 对象
		File file = new File(".");
		// 直接获取文件名，输出一点
		System.out.println(file.getName());
		// 获取相对路径的父路径可能出错，下面代码输出null
		System.out.println(file.getParent());
		// 获取绝对路径
		System.out.println(file.getAbsoluteFile());
		// 获取上一级路径
		System.out.println(file.getAbsoluteFile().getParent());
		// 在当前路径下创建一个临时文件
		File tmpFile = File.createTempFile("aaa", ".txt", file);
		// 指定当JVM退出时删除该文件
		tmpFile.deleteOnExit();
		// 以系统当前时间作为新文件名来创建新文件
		File newFile = new File(System.currentTimeMillis() + "");
		System.out.println("newFile对象是否存在：" + newFile.exists());
		// 以指定newFile对象来创建一个文件
		newFile.createNewFile();
		// 以newFile对象来创建一个目录，因为newFile已经存在，
		// 所以下面方法返回false，即无法创建该目录
		newFile.mkdir();
		// 使用list()方法来列出当前路径下的所有文件和路径
		String[] fileList = file.list();
		System.out.println("====当前路径下所有文件和路径如下====");
		for (String fileName : fileList)
		{
			System.out.println(fileName);
		}
		// listRoots()静态方法列出所有的磁盘根路径。
		File[] roots = File.listRoots();
		System.out.println("====系统所有根路径如下====");
		for (File root : roots)
		{
			System.out.println(root);
		}

	}

	public static void appendLog(FileOutputStream out, String msg) {

		try {
			Writer writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
			writer.write(msg);
			writer.flush();
			writer.close();
		}
		catch (IOException e) {
			log.error("追加内容出错：" + e.getMessage());
		}

	}

}
