package com.taven.app.javabase.exception;

import java.io.FileInputStream;
import java.io.IOException;

public class ExceptionMain {

	/**
	 * @param args
	 * @throws ExceptionDemo1
	 */
	public static void main(String[] args) throws ExceptionDemo1 {

		/**
		 * 
		 * Java异常分为两大类：
		 * 
		 * 1、Checked异常
		 * 必须显示处理的异常，如果不处理，编译时会报错
		 * 目前只有Java提供了Checked异常，像C#只有Runtime异常
		 * 
		 * 2、Runtime异常
		 * 可以不显示处理的异常，如果不处理，编译时不会报错
		 * 
		 * 在定义 方法 的后面用 throws 来声明要抛出的异常
		 * 在方法的代码块中用 throw 来抛出一个异常
		 * 
		 * 
		 */

		int i = 1;
		if (i == 2) {

			throw new ExceptionDemo1("Checked异常");
		}

		//这个运行时异常可以不处理
		throw new ExceptionDemo2("运行时异常");

	}

	public static void catchTest(String[] args)
	{

		//异常的捕获是按 catch 的异常顺序来的
		try
		{
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int c = a / b;
			System.out.println("您输入的两个数相除的结果是：" + c);
		}
		catch (IndexOutOfBoundsException ie)
		{
			System.out.println("数组越界：运行程序时输入的参数个数不够");
		}
		catch (NumberFormatException ne)
		{
			System.out.println("数字格式异常：程序只能接受整数参数");
		}
		catch (ArithmeticException ae)
		{
			System.out.println("算术异常");
		}
		catch (Exception e)
		{
			System.out.println("未知异常");
		}
	}

	public static void finallyTest(String[] args)
	{
		//使用 finally 回收资源
		FileInputStream fis = null;
		try
		{
			fis = new FileInputStream("a.txt");
		}
		catch (IOException ioe)
		{
			System.out.println(ioe.getMessage());
			//return语句强制方法返回
			return;
			//使用exit来退出虚拟机
			//System.exit(1); 
		}
		finally
		{
			//关闭磁盘文件，回收资源
			if (fis != null)
			{
				try
				{
					fis.close();
				}
				catch (IOException ioe)
				{
					ioe.printStackTrace();
				}
			}
			System.out.println("执行finally块里的资源回收!");
		}
	}

}
