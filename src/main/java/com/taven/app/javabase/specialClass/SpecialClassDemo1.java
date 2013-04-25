package com.taven.app.javabase.specialClass;

/**
 * <pre>
 * 内部类编译成class文件，一般格式为：
 * SpecialClassDemo1$A.class
 * 
 * </pre>
 * 
 * @author Taven.Li <br>
 *         <p>
 *         CreateTime 2012-6-13
 *         </p>
 */
public class SpecialClassDemo1 {

	{
		//初始化代码块
		System.out.println("--初始化代码块--");
	}

	static
	{
		//静态初始化代码块
		System.out.println("--静态初始化代码块--");
	}

	//定义两个内部类
	class A {}

	public class B {}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//内部类 的实例化必须先实例化 外部类
		A a = new SpecialClassDemo1().new A();

		//定义局部内部类
		class C {}

		//实例化局部内部类
		C c = new C();

	}
}
