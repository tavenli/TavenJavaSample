package com.taven.app.jms.simple;

import java.util.Date;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class SimpleJmsReceiver {

	public void receive() throws JMSException {

		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();

		Connection connection = connectionFactory.createConnection();
		connection.start();

		final Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
		//这里与发送方对应
		Destination destination = session.createQueue("simple-queue");

		MessageConsumer consumer = session.createConsumer(destination);

		/*//listener 方式 
		
		//如果本类实现 MessageListener 接口
		consumer.setMessageListener(this);
		
		//或
		consumer.setMessageListener(new MessageListener() {  

		    public void onMessage(Message msg) {  
		        MapMessage message = (MapMessage) msg;  

		        System.out.println("收到消息：" + new Date(message.getLong("time")));  
		        session.commit();  
		    }  

		});  

		*/

		MapMessage message = (MapMessage) consumer.receive();
		session.commit();

		System.out.println("收到消息：" + new Date(message.getLong("time")));

		session.close();
		connection.close();

	}

}
