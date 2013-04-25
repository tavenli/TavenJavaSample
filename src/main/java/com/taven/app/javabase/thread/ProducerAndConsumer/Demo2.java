package com.taven.app.javabase.thread.ProducerAndConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * <pre>
 * 用类中类实现的一个 生产和消费
 * </pre>
 * 
 * @author Taven.Li <br>
 *         <p>
 *         CreateTime 2012-4-28
 *         </p>
 */
public class Demo2 {

	private static BlockingQueue q = new ArrayBlockingQueue(20);
	private static Thread tpp;

	public static void main(String[] args) {
		//一个生产者 生产东西
		Producer p = new Producer(q);
		tpp = new Thread(p);
		tpp.start();

		//两个消费者 消费东西
		Consumer c1 = new Consumer(q);
		new Thread(c1).start();

		Consumer c2 = new Consumer(q);
		new Thread(c2).start();
	}

	public static class Producer implements Runnable {
		private final BlockingQueue queue;

		public Producer(BlockingQueue q) {
			queue = q;
		}

		public void run() {

			try {
				while (true) {
					String msg = "" + new Random().nextInt(9999);
					queue.put(msg);
					System.out.println("Demo2生产出：" + msg);

					Thread.sleep(100);

				}

			}
			catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

	public static class Consumer implements Runnable {
		private final BlockingQueue queue;

		public Consumer(BlockingQueue q) {
			queue = q;
		}

		public void run() {
			try {
				while (true) {
					String msg;

					msg = (String) queue.take();

					System.out.println("Demo2消费：" + msg);
					Thread.sleep(1000);
				}
			}
			catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
	}

}
