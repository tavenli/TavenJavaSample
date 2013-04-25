package com.taven.app;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

	private static Log log = LogFactory.getLog(AppMain.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		startApp();

		log.info("Java Application Sample 启动完成");

	}

	private static void startApp() {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-app*.xml");

		context.registerShutdownHook();

	}

}
