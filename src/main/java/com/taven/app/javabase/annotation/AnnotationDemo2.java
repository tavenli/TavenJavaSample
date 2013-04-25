package com.taven.app.javabase.annotation;

public class AnnotationDemo2 {

	// 使用@TestAnnotation标记注释指定该方法是可测试的
	@TestAnnotation
	public static void m1()
	{}

	public static void m2()
	{}

	@TestAnnotation
	public static void m3()
	{
		throw new RuntimeException("Boom");
	}

	public static void m4()
	{}

	@TestAnnotation
	public static void m5()
	{}

	public static void m6()
	{}

	@TestAnnotation
	public static void m7()
	{
		throw new RuntimeException("Crash");
	}

	public static void m8()
	{}

}
