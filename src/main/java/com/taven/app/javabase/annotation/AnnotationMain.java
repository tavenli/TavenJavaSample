package com.taven.app.javabase.annotation;

public class AnnotationMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		 * 从JDK 5开始，Java增加了对元数据（MetaData）的支持，也就是 Annotation（注释/注解）
		 * Annotation 是一个接口，程序可以通过反射来获取指定程序元素的Annotation对象，然后通过Annotation对象来取得注释里面的元数据
		 * 
		 * 3个基本的Annotation：
		 * 
		 * @Override
		 *           重写/覆盖 父类的方法
		 * 
		 * @Deprecated
		 *             表示某个类、方法已经过时
		 * 
		 * @SuppressWarnings
		 *                   抑制编译器警告
		 * 
		 *                   -------------------
		 * @SafeVarargs //JDK 7新增
		 * 
		 * 
		 *              4个元Annotation
		 * 
		 * @Retention
		 *            修饰一个Annotation可以保留多长时间。
		 *            取值范围：
		 * 
		 *            RetentionPolicy.CLASS：
		 *            编译器把Annotation记录在class文件中，Java运行程序时，JVM不再保留Annotation（默认）
		 * 
		 *            RetentionPolicy.RUNTIME：
		 *            编译器把Annotation记录在class文件中，Java运行程序时，JVM会保留Annotation，程序可通过反射获取该Java运行程序时，JVM不再保留Annotation信息
		 * 
		 *            RetentionPolicy.SOURCE
		 *            Annotation只保留在源代码中，编译器会丢弃这种Annotation
		 * 
		 * 
		 * @Target
		 *         修饰一个Annotation可以用于哪些程序单元。
		 *         取值范围：
		 * 
		 *         ElementType.ANNOTATION_TYPE
		 *         指定该策略的Annotation只能修饰Annotation
		 * 
		 *         ElementType.CONSTRUCTOR
		 *         指定该策略的Annotation只能修饰构造器
		 * 
		 *         ElementType.FIELD
		 *         指定该策略的Annotation只能修饰成员变量
		 * 
		 *         ElementType.LOCAL_VARIABLE
		 *         指定该策略的Annotation只能修饰局部变量
		 * 
		 *         ElementType.METHOD
		 *         指定该策略的Annotation只能修饰方法定义
		 * 
		 *         ElementType.PACKAGE
		 *         指定该策略的Annotation只能修饰包定义
		 * 
		 *         ElementType.PARAMETER
		 *         指定该策略的Annotation可以修饰参数
		 * 
		 *         ElementType.TYPE
		 *         指定该策略的Annotation可以修饰 类、接口（包括注解类型）或枚举
		 * 
		 * 
		 * @Documented
		 *             修饰的Annotation将被javadoc工具提取成文档，如果定义Annotation类时使用了该修饰，
		 *             则所有使用该Annotation修饰的程序元素的API文档中将会包含该Annotation说明
		 * 
		 * 
		 * @Inherited
		 *            修饰的Annotation将具有继承性，如果某个类使用了带有Inherited的Annotation，
		 *            则其子类将自动被Annotation修饰
		 * 
		 */

	}

}
