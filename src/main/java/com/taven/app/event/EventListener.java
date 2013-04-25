package com.taven.app.event;

/**
 * <pre>
 * 接收事件的类/监听者，需要实现该接口
 * </pre>
 * 
 * @author Taven.Li <br>
 *         <p>
 *         CreateTime 2012-6-15
 *         </p>
 */
public interface EventListener {

	public void processEvent(EventObject eventObject);

}