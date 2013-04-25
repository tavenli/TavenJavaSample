package com.taven.app.jms.spring;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class JmsMsgProcessor implements MessageListener {

	private Log log = LogFactory.getLog(JmsMsgProcessor.class);

	public void onMessage(Message message) {

		MapMessage mapMessage = (MapMessage) message;

		try {
			String msgContent = mapMessage.getString("msgContent");
			String sendTime = mapMessage.getString("sendTime");

			log.info("收到了一条JMS消息，消息内容：" + msgContent);
		}
		catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
