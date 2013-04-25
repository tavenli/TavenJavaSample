package com.taven.app.javabase.gc;

/**
 * <pre>
 * 该例子演示在 finalize 复活自身
 * </pre>
 * 
 * @author Taven.Li <br>
 *         <p>
 *         CreateTime 2012-6-13
 *         </p>
 */
public class GCDemo2 {

	private static GCDemo2 self = null;

	public void info()
	{
		System.out.println("测试资源清理的finalize方法");
	}

	public static void main(String[] args) throws Exception
	{
		//创建GCDemo2对象立即进入可恢复状态
		new GCDemo2();
		//通知系统进行资源回收
		System.gc();

		//--------------------------
		//方式1
		//让程序暂停2秒
		Thread.sleep(2000);
		//--------------------------
		//方式2
		//强制垃圾回收机制调用可恢复对象的finalize方法
		Runtime.getRuntime().runFinalization();
		//System.runFinalization();

		//测试
		self.info();
	}

	public void finalize()
	{
		//让 self 引用到试图回收的可恢复对象，可恢复对象重新变成可达状态
		self = this;
	}

}
