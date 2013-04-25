package com.taven.app.jms.simple;

import java.util.Date;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class SimpleJmsSender {

	public void sender() throws JMSException {

		//ActiveMQConnectionFactory 默认 tcp://localhost:61616
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		//也可以指定brokerURL
		//connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

		Connection connection = connectionFactory.createConnection();
		connection.start();

		//AUTO_ACKNOWLEDGE 为自动签收
		Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
		//Destination：消息的目的地，消息发送给谁
		//接收方根据这个来接收
		Destination destination = session.createQueue("simple-queue");

		//消息生产者
		MessageProducer producer = session.createProducer(destination);
		//设置不持久化 
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

		MapMessage message = session.createMapMessage();
		message.setLong("time", new Date().getTime());
		//通过消息生产者发出消息   
		producer.send(message);

		/*
		 * 消息类型除了常用的 MapMessage ，还有 TextMessage
		 * 
		 */

		session.commit();
		session.close();
		connection.close();

	}
}
