package com.taven.app.javabase.reflect;

import java.lang.reflect.Array;

public class ReflectArrayTest {

	public static void main(String args[])
	{
		try
		{
			// 创建一个元素类型为String ，长度为10的数组
			Object arr = Array.newInstance(String.class, 10);

			// 依次为arr数组中index为5、6的元素赋值
			Array.set(arr, 5, "疯狂Java");
			Array.set(arr, 6, "Java EE");

			// 依次取出arr数组中index为5、6的元素的值
			Object book1 = Array.get(arr, 5);
			Object book2 = Array.get(arr, 6);

			// 输出arr数组中index为5、6的元素
			System.out.println(book1);
			System.out.println(book2);
		}
		catch (Throwable e)
		{
			System.err.println(e);
		}

		// 创建一个三维数组
		Object arr = Array.newInstance(String.class, 3, 4, 10);
		// 获取arr数组中index为2的元素，应该是二维数组
		Object arrObj = Array.get(arr, 2);

	}
}
