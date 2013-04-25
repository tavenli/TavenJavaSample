package com.taven.app.event.async;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.taven.app.event.EventListener;
import com.taven.app.event.EventObject;

public class EventReactor {

	private static Log log = LogFactory.getLog(EventReactor.class);

	private List<EventListener> eventListeners = new ArrayList<EventListener>();

	/**
	 * 异步事件的处理服务
	 * 
	 */
	public void startService() {
		Thread th = new Thread() {
			public void run() {
				while (true) {
					try {
						//无事件时会阻塞
						EventObject event = EventDemux.getInstance().takeEvent();
						for (EventListener listener : eventListeners) {

							listener.processEvent(event);
						}
					}
					catch (Exception e) {
						log.error("事件处理出错", e);
					}
				}
			}
		};
		th.start();
	}

	/**
	 * 添加一个事件监听者
	 * 
	 * @param listener
	 */
	public void addEventListener(EventListener listener) {
		eventListeners.add(listener);
	}

	/**
	 * 移除一个事件监听者
	 * 
	 * @param listener
	 */
	public void removeEventListener(EventListener listener) {
		eventListeners.remove(listener);
	}

}
