package com.taven.app.javabase.gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class GCReference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		 * Java中对象的引用有4种方式：
		 * 
		 * 1、强引用 StrongReference （一般都是强引用）
		 * 当对象被一个或以上的引用变量所引用，不会被垃圾回收。
		 * 
		 * 2、软引用 SoftReference
		 * 当系统内存空间不足时，系统可能回收它。
		 * 
		 * 3、弱引用 WeakReference
		 * 弱引用比软引用级别更低，不管系统内存是否足够，系统都有可能回收它。
		 * 
		 * 4、虚引用 PhantomReference
		 * 虚引用完全类似于没有引用。
		 * 虚引用主要用于跟踪对象被垃圾回收的状态，不能单独使用，必须和引用队列 ReferenceQueue 联合使用。
		 * 
		 * 
		 * 在 java.lang.ref 下面提供了3个类：
		 * SoftReference、WeakReference、PhantomReference
		 */
	}

	public static void WeakReferenceTest() throws Exception
	{
		//创建一个字符串对象
		String str = new String("疯狂Java");

		//创建一个弱引用，让此弱引用引用到"疯狂Java"字符串
		WeakReference wr = new WeakReference(str);

		//切断str引用和"疯狂Java"字符串之间的引用
		str = null;

		//取出弱引用所引用的对象
		System.out.println(wr.get());

		//强制垃圾回收
		System.gc();
		System.runFinalization();

		//再次取出弱引用所引用的对象
		System.out.println(wr.get());

	}

	public static void PhantomReferenceTest() throws Exception
	{
		//创建一个字符串对象
		String str = new String("疯狂Java");

		//创建一个引用队列
		ReferenceQueue rq = new ReferenceQueue();

		//创建一个虚引用，让此虚引用引用到"疯狂Java"字符串
		PhantomReference pr = new PhantomReference(str, rq);

		//切断str引用和"疯狂Java"字符串之间的引用
		str = null;

		//取出虚引用所引用的对象，
		//并不能通过虚引用访问被引用的对象，所以此处输出null
		System.out.println(pr.get());

		//强制垃圾回收
		System.gc();
		System.runFinalization();

		//垃圾回收之后，虚引用将被放入引用队列中
		//取出引用队列中最先进入队列中的引用与pr进行比较
		System.out.println(rq.poll() == pr);

	}

}
