package com.taven.app.event.sync;

import java.util.ArrayList;
import java.util.List;

import com.taven.app.event.EventListener;
import com.taven.app.event.EventObject;
import com.taven.app.event.EventType;

public class EventDemo2 {

	private List<EventListener> listeners = new ArrayList<EventListener>();

	public void addListener(EventListener listener) {
		listeners.add(listener);
	}

	/**
	 * 同步的方式发送事件
	 */
	public void testEvent() {

		EventObject eventObject = new EventObject(EventType.READY, this);

		for (EventListener listener : listeners) {

			listener.processEvent(eventObject);

		}

	}

}
