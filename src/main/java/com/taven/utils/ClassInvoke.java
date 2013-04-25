package com.taven.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ClassInvoke {

	private static Log log = LogFactory.getLog(ClassInvoke.class);

	/**
	 * 使用方式：
	 * 1秒钟后开始执行 dependChecker 对象中的 checkDepend 方法，每5秒自动执行
	 * ClassInvoke.startServiceTask(dependChecker, "checkDepend", 1000, 1000 * 5);
	 * 
	 * @param obj
	 * @param methodName
	 * @param delay
	 * @param period
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public static void startServiceTask(final Object obj, String methodName, long delay, long period) throws SecurityException, NoSuchMethodException {
		final Method method = obj.getClass().getMethod(methodName);

		TimerTask task = new TimerTask() {
			public void run() {
				try {
					//new Object[] { } 方法的参数
					method.invoke(obj, new Object[] {});
				}
				catch (IllegalArgumentException e) {
					log.error("IllegalArgumentException Msg:" + e.getMessage());
					log.error("IllegalArgumentException 的类:" + obj.getClass() + " 方法名：" + method.getName());
				}
				catch (IllegalAccessException e) {
					log.error("IllegalAccessException Msg:" + e.getMessage());
					log.error("IllegalAccessException 的类:" + obj.getClass() + " 方法名：" + method.getName());
				}
				catch (InvocationTargetException e) {
					log.error("InvocationTargetException Msg:" + e.getMessage());
					log.error("InvocationTargetException 的类:" + obj.getClass() + " 方法名：" + method.getName());
					log.error(((InvocationTargetException) e).getTargetException().getMessage());
				}
			}
		};

		Timer timer = new Timer();
		timer.schedule(task, delay, period);

	}

}
