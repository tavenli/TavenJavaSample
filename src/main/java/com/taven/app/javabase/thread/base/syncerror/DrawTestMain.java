package com.taven.app.javabase.thread.base.syncerror;

/**
 * <pre>
 * 演示一个因为线程同步问题，而出现的程序错误
 * </pre>
 * 
 * @author Taven.Li <br>
 *         <p>
 *         CreateTime 2012-6-14
 *         </p>
 */
public class DrawTestMain
{
	public static void main(String[] args)
	{

		// 创建一个账户
		Account acct = new Account("1234567", 1000);
		// 模拟两个线程对同一个账户取钱
		new DrawThread("甲", acct, 800).start();
		new DrawThread("乙", acct, 800).start();

		/**
		 * 可能输入如下：
		 * 
		 * 甲取钱成功！吐出钞票:800.0
		 * 乙取钱成功！吐出钞票:800.0
		 * 余额为: 200.0
		 * 余额为: -600.0
		 */
	}
}
