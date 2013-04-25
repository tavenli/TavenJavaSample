package com.taven.app.javabase.thread;

import java.util.Random;


public class ThreadGroupDemo {

	public static void main(String[] args) throws InterruptedException {

		ThreadGroup group = new ThreadGroup("Group01");

		Thread t1 = new Thread(group, new MyRunnable());
		MyGroupThread t2 = new MyGroupThread(group, "GroupThread02");
		MyGroupThread t3 = new MyGroupThread(group, "GroupThread03");

		t1.start();
		t2.start();
		t3.start();

		//Thread.sleep(2);
		System.out.println(group.activeCount() + " threads in thread group.");
		Thread thrds[] = new Thread[group.activeCount()];
		group.enumerate(thrds);
		for (Thread t : thrds){
			System.out.println(t.getName());
		}
		
		Thread.sleep(2000);
		System.out.println(group.activeCount() + " threads in tg.");
		group.interrupt();

	}

}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "正在执行...");

	}

}

class MyGroupThread extends Thread {
	public int result = 0;

	public MyGroupThread() {

	}

	public MyGroupThread(ThreadGroup group, String name) {
		super(group, name);
	}

	@Override
	public void run() {
		result = new Random().nextInt();
		System.out.println(Thread.currentThread().getName() + "正在执行...");
	}
}
