package com.taven.app.javabase.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <pre>
 * 用 ReentrantLock 实现同步的线程安全List
 * </pre>
 * 
 * @author Taven.Li <br>
 *         <p>
 *         CreateTime 2012-4-28
 *         </p>
 * @param <T>
 */
public class ReentrantLockList<T> {

	private final ReentrantLock lock = new ReentrantLock(true);
	private final Condition notEmpty = lock.newCondition();

	private List<T> queueList = new ArrayList<T>();

	public boolean put(T e) {
		final ReentrantLock lock = this.lock;
		lock.lock();
		try {

			boolean ok = queueList.add(e);
			assert ok;
			notEmpty.signal();
			return true;
		}
		finally {
			lock.unlock();
		}
	}

	public T take() throws InterruptedException {
		final ReentrantLock lock = this.lock;
		lock.lockInterruptibly();
		try {
			try {
				while (queueList.size() == 0)
					notEmpty.await();
			}
			catch (InterruptedException ie) {
				//中断前通知未其它未被中断的线程
				notEmpty.signal();
				throw ie;
			}
			T x = queueList.remove(0);
			assert x != null;
			return x;
		}
		finally {
			lock.unlock();
		}
	}

	public int size() {
		final ReentrantLock lock = this.lock;
		lock.lock();
		try {
			return queueList.size();
		}
		finally {
			lock.unlock();
		}
	}

}
