package com.taven.app.javabase.thread.ProducerAndConsumer;

import java.util.concurrent.BlockingQueue;

/**
 * <pre>
 * 消费者
 * </pre>
 * 
 * @author Taven.Li <br>
 *         <p>
 *         CreateTime 2012-4-28
 *         </p>
 */
public class Consumer implements Runnable {
	private final BlockingQueue queue;

	public Consumer(BlockingQueue q) {
		queue = q;
	}

	public void run() {
		try {
			while (true) {
				String msg;
				//这里会自动阻塞
				msg = (String) queue.take();

				System.out.println("消费：" + msg);
				Thread.sleep(1000);
			}
		}
		catch (InterruptedException e) {

			e.printStackTrace();
		}

	}
}
