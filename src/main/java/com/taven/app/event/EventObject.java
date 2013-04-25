package com.taven.app.event;

public class EventObject {

	private EventType eventType;
	private Object obj;

	public EventObject(EventType e, Object o) {

		this.eventType = e;
		this.obj = o;

	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

}
