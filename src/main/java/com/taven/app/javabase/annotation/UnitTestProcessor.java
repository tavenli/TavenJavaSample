package com.taven.app.javabase.annotation;

import java.lang.reflect.Method;

public class UnitTestProcessor {

	public static void process(String className) throws ClassNotFoundException
	{
		int passed = 0;
		int failed = 0;
		// 遍历clazz对应的类里的所有方法
		for (Method m : Class.forName(className).getMethods())
		{
			// 如果该方法使用了@TestAnnotation修饰
			if (m.isAnnotationPresent(TestAnnotation.class))
			{
				try
				{
					// 调用m方法
					m.invoke(null);
					// passed加1
					passed++;
				}
				catch (Exception ex)
				{
					System.out.println("方法" + m + "运行失败，异常："
							+ ex.getCause());
					failed++;
				}
			}
		}
		//统计测试结果
		System.out.println("共运行了:" + (passed + failed)
				+ "个方法，其中：\n" + "失败了:" + failed + "个，\n"
				+ "成功了:" + passed + "个！");
	}
}
