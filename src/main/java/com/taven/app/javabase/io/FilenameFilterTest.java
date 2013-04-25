package com.taven.app.javabase.io;

import java.io.File;
import java.io.FilenameFilter;

public class FilenameFilterTest
{
	public static void main(String[] args)
	{
		File file = new File(".");
		String[] nameList = file.list(new MyFilenameFilter());
		for (String name : nameList)
		{
			System.out.println(name);
		}
	}
}

// 实现自己的FilenameFilter实现类
class MyFilenameFilter implements FilenameFilter
{
	public boolean accept(File dir, String name)
	{
		// 如果文件名以.java结尾，或者文件对应一个路径，返回true
		return name.endsWith(".java") || new File(name).isDirectory();
	}
}
