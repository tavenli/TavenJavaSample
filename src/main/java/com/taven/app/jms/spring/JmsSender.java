package com.taven.app.jms.spring;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.taven.utils.DateUtil;

@Service
public class JmsSender {

	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private Queue msg_queue;

	public void sendJmsMsg(final String msgContent) {

		jmsTemplate.send(msg_queue, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {

				MapMessage mapMessage = session.createMapMessage();

				//结合配置项 messageSelector ，指定一个值，使得接收方在接收一个JMS消息时，会先判断是否有这个值的匹配，如果有，则接收，否则不接收
				//mapMessage.setString("receiver", "sample");

				mapMessage.setString("msgContent", msgContent);
				mapMessage.setString("sendTime", DateUtil.getCurrentTime());

				return mapMessage;
			}
		});

	}

}
