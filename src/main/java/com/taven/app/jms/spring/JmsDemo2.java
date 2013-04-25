package com.taven.app.jms.spring;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taven.utils.DateUtil;

/**
 * <pre>
 * 发送JMS的Demo，同时在Java App中集成ActiveMQ服务端
 * 服务端的集成，需要在Maven中引用activemq-all的包，相关配置文件在 applicationContext-app-activemq.xml 中
 * </pre>
 * 
 * @author Taven.Li <br>
 *         <p>
 *         CreateTime 2012-5-16
 *         </p>
 */
@Service
public class JmsDemo2 {

	@Autowired
	private JmsSender jmsSender;

	@PostConstruct
	public void sendJmsMsg() {

		jmsSender.sendJmsMsg("哈哈，您好JMS接收者." + DateUtil.getCurrentTime());

	}

}
