package com.taven.app.javabase.specialClass;

public class SpecialClassDemo4 {

	//先执行静态初始化块将a静态Field赋值为6
	static
	{
		a = 6;
	}

	//再执行将a静态Field赋值为9
	static int a = 9;

	public static void main(String[] args)
	{
		//下面代码将输出9。
		System.out.println(SpecialClassDemo4.a);
	}

}
