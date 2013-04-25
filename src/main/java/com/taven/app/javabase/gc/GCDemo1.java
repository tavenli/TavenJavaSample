package com.taven.app.javabase.gc;

/**
 * <pre>
 * 强制垃圾回收
 * </pre>
 * 
 * @author Taven.Li <br>
 *         <p>
 *         CreateTime 2012-6-13
 *         </p>
 */
public class GCDemo1 {

	public static void main(String[] args)
	{
		for (int i = 0; i < 4; i++)
		{
			new GCDemo1();
			//下面两行代码的作用完全相同，强制系统进行垃圾回收
			//只有强制垃圾回收才会调用用户自定义的 finalize() 方法
			//System.gc();
			Runtime.getRuntime().gc();

		}
	}

	public void finalize()
	{
		System.out.println("系统正在清理GcTest对象的资源...");
	}

}
