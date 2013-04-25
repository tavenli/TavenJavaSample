package com.taven.app.javabase.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 实现一个线程安全的List
 * </pre>
 * 
 * @author Taven.Li <br>
 *         <p>
 *         CreateTime 2012-4-28
 *         </p>
 * @param <T>
 */
public class SyncList<T> {

	private List<T> queueList = new ArrayList<T>();

	public boolean put(T e) {
		synchronized (this) {
			boolean result = queueList.add(e);
			this.notifyAll();
			return result;
		}
	}

	public T take() throws InterruptedException {

		synchronized (this) {

			while (queueList.size() == 0) {
				this.wait();
			}

			T x = queueList.remove(0);
			return x;
		}
	}

	public int size() {

		synchronized (this) {
			return queueList.size();
		}
	}

}
