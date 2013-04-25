package com.taven.app.event.sync;

import com.taven.app.event.EventListener;
import com.taven.app.event.EventObject;

public class EventDemo1 implements EventListener {

	public void processEvent(EventObject eventObject) {

		System.out.println("接收到事件：" + eventObject.getEventType().toString());

	}

}
