package com.taven.app.javabase.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodTest {

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, SecurityException, InvocationTargetException, NoSuchMethodException {

		Class<?> clazz = Class.forName("com.taven.app.javabase.reflect.model.Person");
		//Class<Person2> clazz = Person.class;
		Object obj = clazz.newInstance();

		//方式1
		//invoke(Object obj, Object... args)
		//invoke方法的 obj 参数是执行该方法的主调，后面的 args 是执行该方法时传入该方法的实参
		Method method = clazz.getMethod("sayHello");
		method.invoke(obj);

		//方式2
		obj.getClass().getMethod("sayHello").invoke(obj);

		//---------------------------------

		//有参数的
		Method method2 = clazz.getMethod("sayHello", String.class);
		//获取返回值
		String result = (String) method2.invoke(obj, "Taven.li");
		System.out.println("Return:" + result);

	}
}
