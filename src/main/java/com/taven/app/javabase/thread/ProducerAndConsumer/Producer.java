package com.taven.app.javabase.thread.ProducerAndConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * <pre>
 * 生产者
 * </pre>
 * 
 * @author Taven.Li <br>
 *         <p>
 *         CreateTime 2012-4-28
 *         </p>
 */
public class Producer implements Runnable {
	private final BlockingQueue queue;

	public Producer(BlockingQueue q) {
		queue = q;
	}

	public void run() {

		try {
			while (true) {
				String msg = "" + new Random().nextInt(9999);
				queue.put(msg);
				System.out.println("生产出：" + msg);

				Thread.sleep(100);

			}

		}
		catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}
