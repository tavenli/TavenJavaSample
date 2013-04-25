package com.taven.app.javabase.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		 * 
		 * 运行某个Java程序时，都会启动一个Java虚拟机进程，
		 * 不管这个Java程序多么复杂，开启了多少个线程，它们都处于该虚拟机进程里。
		 * 
		 * 同一个JVM的所有线程、变量都处于同一个进程，它们都使用该JVM进程的内存区。
		 * 
		 * 类先要被加载，然后再是连接，然后再进行类的初始化。
		 * 
		 * 
		 * -------------------------------------------
		 * 
		 * 类的加载器介绍
		 * 
		 * Bootstrap ClassLoader：
		 * 根类加载器，被称为引导（也称为原始或根）类加载器，它负责加载Java的核心类，
		 * 该加载器非常特殊，它并不是java.lang.ClassLoader的子类，而是JVM自身实现的。
		 * 
		 * Extension ClassLoader：
		 * 扩展类加载器，它负责加载JRE的扩展目录（JAVA_HOME/jre/lib/ext 或 java.ext.dirs 系统属性）中JAR包中的类
		 * 
		 * System ClassLoader：
		 * 系统类加载器，也称为应用类加载器，它负责在JVM启动时加载来自java命令的 -classpath 选项、java.class.path 系统属性，
		 * 或CLASSPATH环境变量所指定的JAR包和类路径。
		 * 
		 * 
		 * 
		 */

	}

	//泛型的实例化
	public <T> T createObject(Class<T> cls) throws InstantiationException, IllegalAccessException
	{
		return cls.newInstance();

	}

	//需要转化的泛型
	public <T> T[] createArray(Class<T> cls, int length) throws InstantiationException, IllegalAccessException
	{
		return (T[]) Array.newInstance(cls, length);

	}

	public Object createObject(String clazzName) throws InstantiationException
			, IllegalAccessException, ClassNotFoundException
	{
		// 根据字符串来获取对应的Class对象
		Class<?> clazz = Class.forName(clazzName);
		// 使用clazz对应类的默认构造器创建实例
		return clazz.newInstance();

	}

	public Object createObject2(String clazzName, String initargs) throws InstantiationException
			, IllegalAccessException, ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException
	{
		// 根据字符串来获取对应的Class对象
		Class<?> clazz = Class.forName(clazzName);

		//调用有一个String参数的构造方法
		//,Class<?>... parameterTypes
		Constructor ctor = clazz.getConstructor(String.class);

		// 传入Constructor的参数创建对象
		//Object... initargs
		return ctor.newInstance(initargs);

	}

}
