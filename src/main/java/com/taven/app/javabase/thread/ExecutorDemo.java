package com.taven.app.javabase.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ExecutorDemo {

	public static void main(String[] args) {

		// 创建一个可重用固定线程数的线程池
		// Executors 封装了 ThreadPoolExecutor
		ExecutorService pool = Executors.newFixedThreadPool(4);
		// 创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
		Thread t1 = new MyThread();
		Thread t2 = new MyThread();
		Thread t3 = new MyThread();
		Thread t4 = new MyThread();
		Thread t5 = new MyThread();
		// 将线程放入池中进行执行
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
		// 关闭线程池
		pool.shutdown();

		// 创建一个使用单个 worker 线程的 Executor，以无界队列方式来运行该线程。
		ExecutorService pool2 = Executors.newSingleThreadExecutor();

		pool2.execute(t1);
		pool2.execute(t2);
		pool2.execute(t3);
		pool2.execute(t4);
		pool2.execute(t5);
		// 关闭线程池
		pool2.shutdown();

	}

}

class MyThread extends Thread {
	public int result = 0;

	@Override
	public void run() {
		result = new Random().nextInt();
		System.out.println(Thread.currentThread().getName() + "正在执行...");
	}

}