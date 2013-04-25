package com.taven.app.javabase.generic;

public class GenericTypeDemo3 {

	/**
	 * 泛型方法
	 * 
	 * 在方法中应用 泛型
	 * 
	 * @param array
	 */
	public static <E> void doSomeThing(E[] array)
	{
		for (E e : array) {

			System.out.println(e);

		}
	}
}
