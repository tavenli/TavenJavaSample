package com.taven.app.hibernate;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * 使用注解方式的JPA 数据库操作
 * </pre>
 * 
 * @author Taven.Li <br>
 *         <p>
 *         CreateTime 2012-5-16
 *         </p>
 */
@Service
public class HibernateDemo1 {

	private static Log log = LogFactory.getLog(HibernateDemo1.class);

	@Autowired
	private HibernateDemo2 hibernateDemo2;

	@PostConstruct
	public void startDemo() {

		//hibernateDemo2.addUserInfo();
		hibernateDemo2.showUserInfo();

	}
}
