package com.taven.app.spring;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * 使用Spring注解的例子
 * </pre>
 * 
 * @author Taven.Li <br>
 *         <p>
 *         CreateTime 2012-5-16
 *         </p>
 */
@Service
public class SpringDemo1 {

	private static Log log = LogFactory.getLog(SpringDemo1.class);

	@Autowired
	private Hello hello;

	@Autowired(required = false)
	private Hello hello1;

	@Autowired
	@Qualifier("helloImpl")
	private Hello hello2;

	/**
	 * 将配置文件中的值注入
	 */
	@Value("${myapp.name}")
	private String appName;

	@PostConstruct
	public void showMsg() {

		log.info(this.hello.sayHello());
		log.debug("appName:" + appName);
	}

}
