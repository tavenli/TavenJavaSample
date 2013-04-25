package com.taven.app.event.async;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.taven.app.event.EventObject;
import com.taven.app.event.EventType;

public class EventDemux {

	private static Log log = LogFactory.getLog(EventDemux.class);
	private static EventDemux instance;

	private BlockingQueue<EventObject> eventQueue = new ArrayBlockingQueue<EventObject>(20);

	private EventDemux() {}

	public static EventDemux getInstance() {

		if (instance == null) {
			return new EventDemux();
		}
		else {
			return instance;
		}
	}

	/**
	 * 触发一个异步事件
	 * 
	 * @param eventType
	 * @param job
	 */
	public void createEvent(EventType eventType, Object job) {
		try {
			eventQueue.put(new EventObject(eventType, job));
		}
		catch (InterruptedException e) {
			log.error("创建事件失败：" + e.getMessage());
		}

	}

	/**
	 * 取事件，无事件时会阻塞
	 * 
	 * @return
	 */
	public EventObject takeEvent() {
		EventObject event = null;

		try {
			event = eventQueue.take();
		}
		catch (InterruptedException e) {
			log.error("中断异常", e);
		}

		return event;
	}

}
