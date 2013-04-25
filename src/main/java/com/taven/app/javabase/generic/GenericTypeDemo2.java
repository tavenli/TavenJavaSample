package com.taven.app.javabase.generic;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 泛型中的 类型通配符
 * </pre>
 * 
 * @author Taven.Li <br>
 *         <p>
 *         CreateTime 2012-6-13
 *         </p>
 */
public class GenericTypeDemo2 {

	public void showAll(List<?> list)
	{
		for (int i = 0; i < list.size(); i++) {

			System.out.println(list.get(i));

		}
	}

	/**
	 * 类型的上限
	 * 
	 * @param list
	 */
	public void upLimit(List<? extends Number> list)
	{
		//设定类型的上限，表示都必须继承 Number
		//也就是所有继承 Number 的子类，最上到 Number 截止

		for (int i = 0; i < list.size(); i++) {

			System.out.println(list.get(i));

		}
	}

	public <T extends Number & Serializable> void upLimit2(List<T> list)
	{
		//设定类型的上限，表示都必须继承 Number ，并且还要实现 Serializable 接口

		for (int i = 0; i < list.size(); i++) {

			System.out.println(list.get(i));

		}
	}

	/**
	 * 类型的下限
	 * 
	 * @param list
	 */
	public void downLimit(List<? super Number> list)
	{
		//设定类型的下限，表示都必须是 Number 的父类
		//也就是从 Number ~ Object 这一段

		for (int i = 0; i < list.size(); i++) {

			System.out.println(list.get(i));

		}
	}

}
