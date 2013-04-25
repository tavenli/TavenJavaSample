package com.taven.app.javabase.thread.ProducerAndConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * <pre>
 * 简单的生产和消费 Demo
 * </pre>
 * 
 * @author Taven.Li <br>
 *         <p>
 *         CreateTime 2012-4-28
 *         </p>
 */
public class Demo1 {

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

}
